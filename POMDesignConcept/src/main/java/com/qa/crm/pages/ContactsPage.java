package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//*[@value='New Contact']")
	WebElement newContact;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contactlebel;
	@FindBy(xpath="//*[@name='title']")
	WebElement dropdown;
	
	@FindBy(xpath="//*[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@name='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]  ")
	WebElement saveBtn;
	
	
	
	
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
	
	public void createNewContact(String title, String ftname, String ltname, String com ) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(com);
		//Actions action = new Actions(driver);
		//action.moveToElement(saveBtn).click().build().perform();
		//driver.switchTo().frame("mainpanel");
		saveBtn.click();
		
		
	}
   
}
