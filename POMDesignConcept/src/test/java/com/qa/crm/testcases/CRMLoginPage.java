package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.SignUpPage;


public class CRMLoginPage extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	SignUpPage signUpPage;
	public CRMLoginPage() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginpage = new LoginPage();
		 
		}
	
	@Test(priority=3)
	public void verifyLoginTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void verifycrmLogoTest() {
		boolean logo = loginpage.validatecrmLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=1)
	public void LoginIntoCrmTest() {
		 homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=4)
	public void clickOnSgnUpBtn() {
		signUpPage=loginpage.clickOnsignUpBtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	

}
