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

public class CRMContact extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealspage;
	TestUtil testUtil;
	
	public CRMContact() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		contactpage = new ContactsPage();
		testUtil = new TestUtil();//obj of testUtil class
	    loginpage = new LoginPage();//obj of loginpage
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    testUtil.switchToFrame();//move to frame
	    contactpage = homepage.clickOnContacts();//call clickonContact method.
	    
		}
	
	
	@Test(priority=3)
	public void verifycontactLebelTest() {
		Assert.assertTrue(contactpage.verifyContactlebel());
		
	}
	
	@Test(priority=2)
	public void verifyNewContactTest() {
		boolean con=contactpage.verifyNewContact();
		Assert.assertTrue(con);
	}
	
	@Test(priority=1)
	public void clickOncontactTest() {
		contactpage.clickOnContact();
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
