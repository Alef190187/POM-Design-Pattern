package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class CRMHomePage extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealspage;
	TestUtil testUtil;
	public CRMHomePage() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
	    loginpage = new LoginPage();
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	
	  @Test(priority =4)
	  public void verifyHomepageTitleTest() {
		 String title= homepage.verifyHomepageTitle(); 
		 Assert.assertEquals(title, "CRMPRO" , "homepagetitle does not match");
	  }
	  
	  @Test(priority =3)
	  public void verifyUserNameTest() {
		  testUtil.switchToFrame();
		boolean name =  homepage.verifyUsername();
		Assert.assertTrue(name);
		  
	  }
	
	  
	  @Test(priority =1)
	  public void contactsLinkTest() {
		  testUtil.switchToFrame();
		 contactpage = homepage.clickOnContacts(); 
	  }
	  
	  @Test(priority =2)
	  public void dealsLinkTest() {
		testUtil.switchToFrame();
	    dealspage = homepage.clickOnDeals(); 
	  }
	  	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
