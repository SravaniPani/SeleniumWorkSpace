package io.stepdefinitions;

import java.io.IOException;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.InitialSetUp;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;
import io.cucumber.java.en.Given;

public class StepDefinitionImplementation extends InitialSetUp {

	public LoginPageLocators loginPage;

	@Given("I landed on Eccomerce page")
	public void I_landed_onEcommercePage() throws IOException {
		// code
		loginPage = launchApplication();

	}

	// (.+) is used to denote regular experssion, cause it should be generic.
	// should start with ^ and ends with $
	@Given("^Login in to the Application with username (.+) and password (.+)$")
	public void logged_intto_application_with_and_password() {
		LoginPageLocators ll = new LoginPageLocators(driver);
		ll.goToLogin();
		ll.loggingIn("sravanipani1234@gmail.com", "Sravani@123");

	}

}
