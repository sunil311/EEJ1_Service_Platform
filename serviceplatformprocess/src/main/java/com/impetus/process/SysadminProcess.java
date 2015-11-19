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

import com.impetus.process.dao.UserDao;
import com.impetus.process.dto.DbProfileData;
import com.impetus.process.dto.UserData;
import com.impetus.process.entities.SecUser;

@Configuration
@PropertySource("classpath:com/impetus/process/package.properties")
public class SysadminProcess
{
  @Autowired
  Environment env;

  @Autowired
  private UserDao userDao;
  Logger logger = LoggerFactory.getLogger(getClass());

  public List<UserData> getAllInactiveUsers()
  {
    List<SecUser> secUsers = userDao.getAllInactiveUsers();
    List<UserData> userData = new ArrayList<>();
    if (!secUsers.isEmpty())
    {
      for (SecUser secUser : secUsers)
      {
        userData.add(transformSecToUserData(secUser));
      }
    }
    return userData;
  }

  public UserData transformSecToUserData(SecUser secUser)
  {
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

  public String updateAggrigator(DbProfileData dbProfileData)
  {
    String status = null;
    SecUser secUser = userDao.findUserByEmailId(dbProfileData.getEmail());
    status = createDataBase(secUser);

    secUser.setActivated(true);
    userDao.save(secUser);
    return status;

  }

  public String createDataBase(SecUser secUser)
  {
    // TODO include zip functionality here
    // TODO write code to trigger script to create database at runtime here
    sendEmail(secUser);
    return "SUCCESS";
  }

  public void sendEmail(SecUser secUser)
  {
    String to = secUser.getEmail();
    String from = env.getProperty("process.email.from");
    String host = env.getProperty("process.email.host");// or IP address

    // Get the session object
    Properties properties = System.getProperties();
    properties.setProperty(env.getProperty("process.email.smtp"), host);
    Session session = Session.getDefaultInstance(properties);

    // compose the message
    try
    {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject(env.getProperty("process.email.subject"));

      String htmlBody = env.getProperty("process.email.hello") + secUser.getLastName()
        + env.getProperty("process.emial.content");
      Multipart mp = new MimeMultipart();

      MimeBodyPart htmlPart = new MimeBodyPart();
      htmlPart.setContent(htmlBody, "text/html");
      mp.addBodyPart(htmlPart);

      MimeBodyPart attachment = new MimeBodyPart();

      String fileName = env.getProperty("process.email.attachment.name");
      DataSource source = new FileDataSource(
        new File(env.getProperty("process.email.zip.location")));
      attachment.setDataHandler(new DataHandler(source));
      attachment.setFileName(fileName);
      mp.addBodyPart(attachment);

      message.setContent(mp);

      // Send message
      Transport.send(message);
      logger.info("message sent successfully....");
    }
    catch (Exception e)
    {
      logger.debug(e.getMessage());
    }
  }

}
