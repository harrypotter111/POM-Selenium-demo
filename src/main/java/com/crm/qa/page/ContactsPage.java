package com.crm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(css="input[name*='first_']")
	WebElement firstName;
	
	@FindBy(css="input[name*='last_']")
	WebElement lastName;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newBtn;

	@FindBy(xpath="//input[@name='value' and @placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Street Address']")
	WebElement address;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void inputDetails(String fname, String lname, String mail, String addr,String status) {
		newBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(mail);
		address.sendKeys(addr);
		driver.findElement(By.xpath("//span[contains(text(),'"+status+"')]"));
		saveBtn.click();
		
	}
	
	
}
