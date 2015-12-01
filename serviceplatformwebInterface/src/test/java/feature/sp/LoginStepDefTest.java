package feature.sp;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.process.LoginProcess;
import com.impetus.process.dto.LoginData;
import com.impetus.serviceplatform.web.controller.LoginController;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefTest {
	
	LoginData loginData;
	LoginController loginController;
	@Autowired
	LoginProcess loginProcess;
	
	String statusMessage;
	
	
	@Given("^Existing user is on Login Page$")
	public void existing_user_is_on_Login_Page() throws Throwable {
		loginData = new LoginData();
		
	}

	@Given("^I enter username and password with valid data$")
	public void i_enter_username_and_password_with_valid_data() throws Throwable {
		loginData.setEmail("hari@gmail.com");
		loginData.setPassword("impetus");
	}


	@Then("^I should be able to access all access rights assigned$")
	public void i_should_be_able_to_access_all_access_rights_assigned() throws Throwable {
		loginProcess.loginUser(loginData);
	}

	@Given("^I enter username and password less than (\\d+) or more than (\\d+) alphanumeric value$")
	public void i_enter_username_and_password_less_than_or_more_than_alphanumeric_value(int arg1, int arg2) throws Throwable {
		loginData.setEmail("hari");
		loginData.setPassword("hari");
	}

	@Then("^I should see proper message$")
	public void i_should_see_proper_message() throws Throwable {
		statusMessage = loginProcess.loginUser(loginData);
		Assert.assertEquals(statusMessage, "Email and Password should be between 6 and 12.");
	}

	@When("^I enter password$")
	public void i_enter_password() throws Throwable {

	}

	@Then("^I should see in password in asterisks \\(\\*\\*\\*\\*\\*\\)$")
	public void i_should_see_in_password_in_asterisks() throws Throwable {

	}

	@When("^I click on forgot password link$")
	public void i_click_on_forgot_password_link() throws Throwable {

	}

	@Then("^I should be on reset-password page$")
	public void i_should_be_on_reset_password_page() throws Throwable {

	}

	@Given("^I enter valid username or email-id$")
	public void i_enter_valid_username_or_email_id() throws Throwable {

	}

	@When("^I press send email button$")
	public void i_press_send_email_button() throws Throwable {

	}

	@Then("^i proper should come up$")
	public void i_proper_should_come_up() throws Throwable {

	}

	@Given("^I clicked on login button$")
	public void i_clicked_on_login_button() throws Throwable {

	}

	@When("^I click on log out button$")
	public void i_click_on_log_out_button() throws Throwable {

	}

	@Then("^I should be redirected to Login Page$")
	public void i_should_be_redirected_to_Login_Page() throws Throwable {

	}



}
