package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;


public class LoginPage extends TestBase {
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
	WebElement crmLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
		
	}
	
	public SignUpPage clickOnsignUpBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(signUpBtn).build().perform();
		action.click();
		return new SignUpPage();
	}
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		//handle element not clickable exception.
		Actions action = new Actions(driver);
		action.moveToElement(loginBtn).click().build().perform();
		
		return new HomePage();
		
	}
	

}
