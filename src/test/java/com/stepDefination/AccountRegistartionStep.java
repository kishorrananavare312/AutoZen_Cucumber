package com.stepDefination;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.PageObject.AccountRegistrationPage;
import com.PageObject.HomePage;
import com.testBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountRegistartionStep extends TestBase {
	
	AccountRegistrationPage acc;
	HomePage hp;
	private static final Logger logger = LogManager.getLogger();
	
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() throws IOException {
		
		logger.info("*********Starting Accountregitration testcase**********");
		
	    setup();
		hp=new HomePage(driver);
		
		logger.info("click on myaccount");
		hp.account();
		
	}

	@When("User clicks on My Account and selects Register option")
	public void user_clicks_on_my_account_and_selects_register_option() {
		
		logger.info("click on register");
		hp.registeration();
	}

	@And("User provides valid personal details")
	public void user_provides_valid_personal_details() {
		acc=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		acc.setfirstname(randomstring().toUpperCase());
		acc.setlastname(randomstring().toUpperCase());
		acc.setemail(randomstring()+"@gmail.com");
		acc.settelephoneno(randomnumber());
		String pwdd=alphanumeric();
		acc.setpassword(pwdd);
		acc.setconfirmpassword(pwdd);		
	}

	@And("User accepts the privacy policy and submits the form")
	public void user_accepts_the_privacy_policy_and_submits_the_form() throws InterruptedException {
		acc.policy();
		acc.continu();
		Thread.sleep(2000);
	}

	
	@Then("A confirmation message {string} should be displayed")
	public void a_confirmation_message_should_be_displayed(String expectedMessage) {

		AccountRegistrationPage acc = new AccountRegistrationPage(driver);
	    logger.info("Valaidating confirmation message");
	    String actualMessage = acc.confirmationmsg();
	    Assert.assertEquals(expectedMessage, actualMessage);
	    teardown();
	}
//	@Then("A confirmation message {string} should be displayed")
//	public void a_confirmation_message_should_be_displayed(String string) {
//		
//		logger.info("Valaidating confirmation message");
//    
//		String msg=acc.confirmationmsg();
//		
//		if(msg.equals("Your Account Has Been Created!"))
//				{
//					Assert.assertTrue(true);
//				}
//		else
//		{
//			logger.error("Test failed");
//			logger.debug("Debug logs");
//			Assert.assertTrue(false);
//		}
//		
//		logger.info("Account regstration test is finished");
//		teardown();
//	}
//    


}
