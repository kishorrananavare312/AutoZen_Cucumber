package com.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement lnkmyaccount;
    
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register;
	
    
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement linklogin;
  
	
	//action
	public void account()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lnkmyaccount)).click();
	}
	
	public void registeration()
	{
	 register.click();
	}
	
	public void login()
	{
	 linklogin.click();
	}
	
}
