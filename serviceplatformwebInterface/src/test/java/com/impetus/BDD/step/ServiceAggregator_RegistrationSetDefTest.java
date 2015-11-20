package com.impetus.BDD.step;

import java.util.Random;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.process.RegisterProcess;
import com.impetus.process.dto.UserData;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceAggregator_RegistrationSetDefTest {

	UserData UserData;
	String result;
	@Autowired
	RegisterProcess registerProcess;
	
	Random random = new Random();

	String concatTempString = "7";

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Given("^User is on Registration Page$")
	public void user_is_on_Registration_Page() throws Throwable {
		UserData = new UserData();
	}

	@Given("^Servie Aggregator enters valid FirstName,LastName,Password,Email,MobileNumber$")
	public void servie_Aggregator_enters_valid_FirstName_LastName_Password_Email_MobileNumber()
			throws Throwable {
		UserData.setFirstName("FirstName_"+concatTempString);
		UserData.setLastName("LastName_"+concatTempString);
		UserData.setPassword("Password_"+concatTempString);
		UserData.setEmail(random.nextInt()+"_email@gmail.com");
		UserData.setMobile("8095182141_"+concatTempString);
		UserData.setDisplayName("Hari_"+concatTempString);
		UserData.setCompanyName("Impetus_"+concatTempString);
	}

	@When("^I clicked on Submit Button$")
	public void i_clicked_on_Submit_Button() throws Throwable {
		result = registerProcess.registerUser(UserData);
	}

	@Then("^Message displayed Registration successful$")
	public void message_displayed_Registration_successful() throws Throwable {
		Assert.assertEquals(result, "SUCCESS");

	}

	@Given("^I filled Andyabcabcd(\\d+)andy@gmail\\.com(\\d+)$")
	public void i_filled_Andyabcabcd_andy_gmail_com(int arg1, int arg2)
			throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Andy"+concatTempString);
		UserData.setLastName("abc"+concatTempString);
		UserData.setPassword("abcd1234"+concatTempString);
		UserData.setEmail(random.nextInt()+"andy1@gmail.com");
		UserData.setMobile("8095182141"+concatTempString);
		UserData.setDisplayName("Andy_"+concatTempString);
		UserData.setCompanyName("Impetus_"+concatTempString);		
		//result = registerProcess.registerUser(UserData);
	}

	@Then("^I should see success message $")
	public void i_should_see_success_message() throws Throwable {
		Assert.assertEquals(result, "SUCCESS");
	}

	@Given("^I filled Mikexyzabcd(\\d+)mike@gmail\\.com(\\d+)$")
	public void i_filled_Mikexyzabcd_mike_gmail_com(int arg1, int arg2)
			throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Mike"+concatTempString);
		UserData.setLastName("xyz"+concatTempString);
		UserData.setPassword("abcd1234"+concatTempString);
		UserData.setEmail(random.nextInt()+"mike@gmail.com");
		UserData.setMobile("8095182141"+concatTempString);
		UserData.setDisplayName("Mike_"+concatTempString);
		UserData.setCompanyName("Impetus_"+concatTempString);
		
		//result = registerProcess.registerUser(UserData);

		Assert.assertEquals(result, null);
	}

	@Given("^I filled Andyabcandy@gmail\\.com(\\d+)$")
	public void i_filled_Andyabcandy_gmail_com(int arg1) throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Andy"+concatTempString);
		UserData.setLastName("abc"+concatTempString);
		UserData.setPassword("1234"+concatTempString);
		UserData.setEmail(random.nextInt()+"Andyabcandy@gmail.com");
		UserData.setMobile("8095182141_"+concatTempString);

		//result = registerProcess.registerUser(UserData);

		Assert.assertNotEquals(result, "SUCCESS");
	}

	@Given("^User is not filled First Name$")
	public void user_is_not_filled_First_Name() throws Throwable {
		UserData = new UserData();
		UserData.setFirstName(null);
		UserData.setLastName("abc"+concatTempString);
		UserData.setEmail(random.nextInt()+"dfdsfffgandy@gmail.com");
		UserData.setMobile("8095182141_"+concatTempString);
	}

	@When("^User clicked on Submit button$")
	public void user_clicked_on_Submit_button() throws Throwable {
		result = registerProcess.registerUser(UserData);
	}

	@Then("^User should see First Name is mandatory to create account message$")
	public void user_should_see_First_Name_is_mandatory_to_create_account_message()
			throws Throwable {
		Assert.assertEquals(result, "First Name is mandatory");
	}

	@Given("^User is not filled Last Name$")
	public void user_is_not_filled_Last_Name() throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Validate_"+concatTempString);
		UserData.setLastName(null);
		UserData.setEmail("fdgfdgfdandy@gmail.com");
		UserData.setMobile("8095182141");
		
		result = registerProcess.registerUser(UserData);
	}

	@Then("^User should see Last Name is mandatory to create account message$")
	public void user_should_see_Last_Name_is_mandatory_to_create_account_message()
			throws Throwable {
		Assert.assertEquals(result, "Last Name is mandatory");
	}

	@Given("^User is not filled password$")
	public void user_is_not_filled_password() throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Validate_"+concatTempString);
		UserData.setLastName("Validate_"+concatTempString);		
		UserData.setPassword(null);
		UserData.setLastName("abc"+concatTempString);
		UserData.setEmail(random.nextInt()+"fdgfhfgfdfandy@gmail.com");
		UserData.setMobile("8095182141"+concatTempString);
		
		result = registerProcess.registerUser(UserData);
	}

	@Then("^User should see password is mandatory to create account message$")
	public void user_should_see_password_is_mandatory_to_create_account_message()
			throws Throwable {
		Assert.assertEquals(result, "Password is mandatory");
	}

	@Given("^User is not filled email$")
	public void user_is_not_filled_email() throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Validate_"+concatTempString);
		UserData.setLastName("Validate_"+concatTempString);		
		UserData.setPassword("Validate_"+concatTempString);		
		UserData.setEmail(null);
		UserData.setMobile("8095182141"+concatTempString);
		result = registerProcess.registerUser(UserData);
	}

	@Then("^User should see email is mandatory to create account message$")
	public void user_should_see_email_is_mandatory_to_create_account_message()
			throws Throwable {
		Assert.assertEquals(result, "Email is mandatory");
	}

	@Given("^User is not filled mobileno$")
	public void user_is_not_filled_mobileno() throws Throwable {
		UserData = new UserData();
		UserData.setFirstName("Validate_"+concatTempString);
		UserData.setLastName("Validate_"+concatTempString);		
		UserData.setPassword("Validate_"+concatTempString);		
		UserData.setEmail("Validate_"+concatTempString);		
		UserData.setMobile(null);
		result = registerProcess.registerUser(UserData);
	}

	@Then("^User should see mobileno is mandatory to create account message$")
	public void user_should_see_mobileno_is_mandatory_to_create_account_message()
			throws Throwable {
		Assert.assertEquals(result, "Mobile Number is mandatory");
	}

}
