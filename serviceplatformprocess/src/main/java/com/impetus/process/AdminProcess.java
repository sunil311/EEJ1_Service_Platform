package com.impetus.process;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.impetus.process.dao.UserDao;
import com.impetus.process.dto.DBResponse;
import com.impetus.process.dto.DbProfileData;
import com.impetus.process.dto.InputData;
import com.impetus.process.dto.UserData;
import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.TenantDatabaseMetadata;
import com.impetus.process.enums.Template;
import com.impetus.process.exception.ServicePlatformException;
import com.impetus.process.service.IManageTenant;
import com.impetus.process.utils.ZipDirectory;

/**
 * @author amitb.kumar
 */
@Configuration
@PropertySource({ "classpath:package.properties", "classpath:config.properties" })
public class AdminProcess {

	public static final String SUCCESS = "SUCCESS";

	public static final String INPUT = "INPUT";

	public static final String DATABASE_SUCCESS = "Database created successfully";

	@Autowired
	Environment env;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	IManageTenant iManageTenant;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminProcess.class);

	/**
	 * @return
	 */
	public List<UserData> getAllInactiveUsers() {
		List<SecUser> secUsers = userDao.getAllInactiveUsers();
		List<UserData> userData = new ArrayList<UserData>();
		if (!secUsers.isEmpty()) {
			for (SecUser secUser : secUsers) {
				userData.add(transformSecToUserData(secUser));
			}
		}
		return userData;
	}

	/**
	 * @param secUser
	 * @return
	 */
	public UserData transformSecToUserData(SecUser secUser) {
		UserData userData = new UserData();
		userData.setAccountNumber(secUser.getAccountNumber());
		userData.setBankAccountHolder(secUser.getBankAccountHolder());
		userData.setBankName(secUser.getBankName());
		userData.setBranchAddress(secUser.getBranchAddress());
		userData.setBranchAddress(secUser.getBranchAddress());
		userData.setCompanyName(secUser.getCompanyName());
		userData.setDisplayName(secUser.getDisplayName());
		userData.setDomainName(secUser.getDomainName());
		userData.setEmail(secUser.getEmail());
		userData.setFacebookURL(secUser.getFacebookURL());
		userData.setFirstName(secUser.getFirstName());
		userData.setHouseNo(secUser.getHouseNo());
		userData.setIfscCode(secUser.getIfscCode());
		userData.setLastName(secUser.getLastName());
		userData.setLocality(secUser.getLocality());
		userData.setMobile(secUser.getMobile());
		userData.setPostCode(secUser.getPostCode());
		userData.setState(secUser.getState());
		userData.setTwitterURL(secUser.getTwitterURL());
		return userData;

	}

	/**
	 * @param dbProfileData
	 * @return
	 * @throws ServicePlatformException
	 */
	public String updateAggrigator(DbProfileData dbProfileData)
			throws ServicePlatformException {
		SecUser secUser = userDao.findUserByEmailId(dbProfileData.getEmail());
		updateDbprofileData(dbProfileData, secUser);
		String dbResponse = createDataBase(dbProfileData);
		Integer dbDetailsId = createEntryforTenantDatabaseMetadata(dbProfileData);
		LOGGER.debug("database details Id :"+dbDetailsId);
		updateDataSourceMapAtAggregatorSite(dbProfileData);
		if (DATABASE_SUCCESS.equalsIgnoreCase(dbResponse)) {
			if (sendEmail(secUser)) {
				secUser.setActivated(true);
				userDao.save(secUser);
			}
		}
		return dbResponse;
	}

	/**
	 * @param dbProfileData
	 * @return
	 */
	public String createDataBase(DbProfileData dbProfileData)
			throws ServicePlatformException {
		RestTemplate rt = new RestTemplate();
		rt.getMessageConverters().add(new StringHttpMessageConverter());
		String uri = new String(env.getProperty("process.create.db.uri"));

		InputData input = new InputData();
		input.setDbURL(env.getProperty("process.db.sqlserver.url")
				+ dbProfileData.getHostName() + ":"
				+ dbProfileData.getPortNumber());
		input.setDbName(dbProfileData.getDbName());
		input.setDbUserName(dbProfileData.getUserName());
		input.setDbPassword(dbProfileData.getPassword());
		DBResponse response = null;
		try {
			response = rt.postForObject(uri, input, DBResponse.class);
		} catch (ResourceAccessException e) {
			throw new ServicePlatformException(
					"Exception occured in creating database: ", e);
		}
		return response.getResult();

	}

	/**
	 * This method is used to update datasource map for a Tenant which is going to
	 * register with fecilitator
	 * 
	 * @param dbProfileData
	 * @return
	 */
	public String updateDataSourceMapAtAggregatorSite(DbProfileData dbProfileData)
			throws ServicePlatformException {
		RestTemplate rt = new RestTemplate();
		rt.getMessageConverters().add(new StringHttpMessageConverter());
		String uri = new String(env.getProperty("process.update.datasource.map"));

		DBResponse response = null;
		try {
			response = rt.postForObject(uri, dbProfileData.getTenantId(), DBResponse.class);
			LOGGER.debug(response.getResult());
		} catch (ResourceAccessException e) {
			throw new ServicePlatformException(
					"Exception occured in creating database: ", e);
		}
		return response.getResult();

	}

	/**
	 * @param dbProfileData
	 * @return
	 */
	public Integer createEntryforTenantDatabaseMetadata(
			DbProfileData dbProfileData) throws ServicePlatformException {

		InputData input = new InputData();
		input.setDbName(dbProfileData.getDbName());
		input.setDbUserName(dbProfileData.getUserName());
		input.setDbPassword(dbProfileData.getPassword());
		input.setDbHostName(dbProfileData.getHostName());
		input.setDbPort(dbProfileData.getPortNumber());
		input.setTenantId(dbProfileData.getTenantId());
		TenantDatabaseMetadata tenantDatabaseMetadata = iManageTenant
				.createTenantDatabaseMetadatDetail(input);
		return tenantDatabaseMetadata.getDbDetailsId();
	}
	/**
	 * @param secUser
	 * @return
	 * @throws ServicePlatformException
	 */
	public boolean sendEmail(SecUser secUser) throws ServicePlatformException {
		String to = secUser.getEmail();
		String from = env.getProperty("process.email.from");
		String host = env.getProperty("process.email.host");// or IP address

		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty(env.getProperty("process.email.smtp"), host);
		Session session = Session.getDefaultInstance(properties);

		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject(env.getProperty("process.email.subject"));

			String htmlBody = env.getProperty("process.email.hello")
					+ secUser.getLastName()
					+ env.getProperty("process.emial.content");
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlBody, "text/html");
			mp.addBodyPart(htmlPart);

			MimeBodyPart attachment = new MimeBodyPart();

			String fileName = env.getProperty("process.email.attachment.name");

			// TODO get template which was select at sign up
			String tenanteTeamplate = Template.getEnum(secUser.getTemplate())
					.getName();
			String filestore = env.getProperty("sp.filestore.path");
			String tempFolder = env.getProperty("sp.temp.path");
			String teamplate_loc = env
					.getProperty("process.email.zip.location")
					+ tenanteTeamplate;

			String source_folder = filestore + teamplate_loc;
			String downloadLink = tempFolder + teamplate_loc + ".zip";
			ZipDirectory.zipDir(source_folder, downloadLink);

			DataSource source = new FileDataSource(new File(downloadLink));
			attachment.setDataHandler(new DataHandler(source));
			attachment.setFileName(fileName);
			mp.addBodyPart(attachment);

			message.setContent(mp);

			// Send message
			Transport.send(message);
			LOGGER.info("message sent successfully....");
		} catch (Exception e) {
			throw new ServicePlatformException(
					"Exception occured in sendEmail: ", e);
		}
		return true;
	}

	/**
	 * @param tenantId
	 * @return
	 */
	private String getTemplateLocation(String tenantId) {
		// TODO: use tenantId to find correct template location
		String teamplate_loc = "client_templates\\";
		return teamplate_loc;
	}

	/**
	 * @param profileData
	 * @param secUser
	 * @return
	 */
	private DbProfileData updateDbprofileData(DbProfileData profileData,
			SecUser secUser) {
		profileData.setTenantId(secUser.getTenantId());
		return profileData;
	}
}
