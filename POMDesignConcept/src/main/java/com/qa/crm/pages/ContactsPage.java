package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//*[@value='New Contact']")
	WebElement newContact;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contactlebel;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNewContact() {
		return newContact.isDisplayed();
	}
	
	public boolean verifyContactlebel() {
		return Contactlebel.isDisplayed();
	}
	
	public void clickOnContact() {
		driver.findElement(By.xpath("//input[@name='contact_id' and @value ='52714427']")).click();
	}
   
}
