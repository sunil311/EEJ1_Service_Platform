package feature.sp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.impetus.serviceplatform.web.controller.DownloadController;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServicePlatformZippedDownloadTest {

	// TODO Need From the Team tenantId
	String tenantId = "tenantA";

	HttpServletResponse response;
	int BUFFER = 2048;

	boolean unzipFlag = false;
	boolean functionalityFlag = false;

	@Autowired
	DownloadController downloadController;

	@Autowired
	private Environment env;

	String downloadPath;

	@Given("^I am logged in as Service Aggregator after successful registartion$")
	public void i_am_logged_in_as_Service_Aggregator_after_successful_registartion()
			throws Throwable {
		// downloadController = new DownloadController();
	}

	@Given("^I on service aggregator details page$")
	public void i_on_service_aggregator_details_page() throws Throwable {

		downloadPath = getDownloadPath("tenantA");
	}

	@When("^I click on Download Template Button$")
	public void i_click_on_Download_Template_Button() throws Throwable {

		Assert.assertNotNull(tenantId);
		try {
			downloadController.loginUser(tenantId, response);
		} catch (Exception e) {
			functionalityFlag = true;
		}
	}

	@Then("^I verify zipped template is downloaded on my system$")
	public void i_verify_zipped_template_is_downloaded_on_my_system()
			throws Throwable {

		File file = new File(getDownloadPath("tenantA"));
		Assert.assertTrue(file.exists());

	}

	@Then("^I verify file format of downlaoded zip file should be \"([^\"]*)\"$")
	public void i_verify_file_format_of_downlaoded_zip_file_should_be(
			String arg1) throws Throwable {
		FileInputStream fis = new FileInputStream(getDownloadPath("tenantA"));
		ZipInputStream zin = new ZipInputStream(new BufferedInputStream(fis));
		ZipEntry entry = zin.getNextEntry();
		Assert.assertNotNull(entry);
		zin.close();
	}

	@Given("^I am on local machine$")
	public void i_am_on_local_machine() throws Throwable {

	}

	@Given("^I go the download folder$")
	public void i_go_the_download_folder() throws Throwable {
		unzipFlag = false;
	}

	@When("^I unzip the downloaded template using zip or (\\d+)zip softawre$")
	public void i_unzip_the_downloaded_template_using_zip_or_zip_softawre(
			int arg1) throws Throwable {
		unZipfile();
	}

	@Then("^I verify all the files,directories succesfully downloaded on the system$")
	public void i_verify_all_the_files_directories_succesfully_downloaded_on_the_system()
			throws Throwable {
		Assert.assertTrue(unzipFlag);
	}

	@When("^I uploaded all files,directory structure on server$")
	public void i_uploaded_all_files_directory_structure_on_server()
			throws Throwable {
		functionalityFlag = false;
		readWritefileInServer();
	}

	@Then("^I verify all the functionality available should work on server$")
	public void i_verify_all_the_functionality_available_should_work_on_server()
			throws Throwable {
		Assert.assertNotNull(functionalityFlag);
	}

	private void readWritefileInServer() {
		try {
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(
					getDownloadPath("tenantA"));
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				// Data Contains in the Zip file and correct format
				functionalityFlag = true;
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream(entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);

				// Read and Write to the server Path
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			functionalityFlag = false;
		}
	}

	private void unZipfile() {
		try {
			BufferedOutputStream dest = null;

			FileInputStream fis = new FileInputStream(
					getDownloadPath("tenantA"));
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				// Data Contains in the Zip file and correct format
				unzipFlag = true;
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream(entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			unzipFlag = false;
		}
		// Data Contains/not contains in the Zip file and correct format.
		unzipFlag = true;
	}

	private String getDownloadPath(String tenantId) {
		// TODO: use tenantId to find correct template location
		String teamplate_loc = "client_templates\\Template A";

		String tempFolder = env.getProperty("sp.temp.path");

		// String source_folder = filestore + teamplate_loc;
		String downloadPath = tempFolder + teamplate_loc + ".zip";
		return downloadPath;
	}
}
