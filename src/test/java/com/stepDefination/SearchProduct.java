package com.stepDefination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.PageObject.HomePage;
import com.PageObject.ProductPage;
import com.PageObject.SearchProductPage;
import com.testBase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct extends TestBase{
	
	HomePage hp;
	SearchProductPage sp;
	ProductPage pp;
	private static final Logger logger = LogManager.getLogger();
	
	
	@Given("User is on the homepagee")
	public void user_is_on_the_homepagee() throws IOException {
		
		logger.info("*********Starting SearchProductPage testcase**********");
		
	    setup();
		hp=new HomePage(driver);	
	}
	
	@When("User enters iMac procuctname")
	public void user_enter_iMac_Product() {
		
		sp=new SearchProductPage(driver);
		logger.info("Enter Product Name");
		sp.seacrhproductname("iMac");	
	}

	@And("clicks on the Search button")
	public void clicks_on_the_Search_button() {
		sp=new SearchProductPage(driver);
		logger.info("Search Product");
		sp.searchbtn();
	}
	
	@Then("iMac product should be displayed")
	public void product_should_be_displayed() {
		try {
	    pp=new ProductPage(driver);
	    logger.info("Valadating correct product");
	    String confirmproduct=pp.Productimac();
	    Assert.assertEquals("iMac",confirmproduct);
		 logger.info("product match");
		}
	    catch (AssertionError ae) {
		    logger.error("Exception occurred during confirm product name: " + ae.getMessage());
		    String screenshotPath = CaptureScreen("productunmatch");
		    logger.info("Screenshot taken: " + screenshotPath);
		    Assert.fail("Assertion Failed: " + ae.getMessage());
		    teardown();
	}
		logger.info("product match test Finished");
		teardown();
}
}
