package com.stepDefination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.PageObject.HomePage;
import com.PageObject.LoginPage;
import com.PageObject.MyAccountPage;
import com.testBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginStep extends TestBase{
	
	HomePage hp;
    LoginPage lp;
    MyAccountPage acc;
	private static final Logger logger = LogManager.getLogger();
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws IOException {
		
		logger.info("*********Starting UserLogin testcase**********");
	    setup();
	    hp=new HomePage(driver);
	    
	    logger.info("click on myaccount");
		hp.account();
		
		logger.info("click on login");
		hp.login();
	}
	
	@When("User enters valid email and password")
	public void user_enters_valid_email_and_password() {
	   
		 lp=new LoginPage(driver); 
		 logger.info("Providing login details");
		 lp.username(p.getProperty("Username"));//property file
		 lp.password(p.getProperty("password"));
	}

	@And("clicks on the Login button")
	public void clicks_on_the_login_button() {
	    lp.loginbtn();
	}

	@Then("User should be navigated to My Account page")
	public void user_should_be_navigated_to_my_account_page() {
		try {
		logger.info("Valaidating confirmation message");
        acc=new MyAccountPage(driver);
	    boolean confirmationpage=acc.confirmmyaccount();
	    Assert.assertTrue(confirmationpage);
		}
		catch(AssertionError ae)
		{
			logger.error("Exception occurred during login test: " + ae.getMessage());
		    String screenshotPath = CaptureScreen("UserLoginFailure");
		    logger.info("Screenshot taken: " + screenshotPath);
		    Assert.fail("Assertion Failed: " + ae.getMessage());
		    teardown();
		}
		logger.info("login test is finished");
		teardown();
	}
}
