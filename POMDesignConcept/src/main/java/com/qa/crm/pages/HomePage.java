package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[contains(text(),' Alif Uddin ')]")
	WebElement currectUsername;
	
	@FindBy(xpath="//*[@title='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//*[@title='Deals']")
	WebElement deals;
	
	@FindBy(xpath="//*[@title='Tasks']")
	WebElement tasks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsername() {
		return currectUsername.isDisplayed();
	}
	
	public DealsPage clickOnDeals() {
		deals.click();
		return new DealsPage();
	}
	
	public ContactsPage clickOnContacts() {
		contacts.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasks() {
		tasks.click();
		return new TasksPage();
	}
	

}
