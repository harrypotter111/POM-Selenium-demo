package com.crm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(css="span.user-display")
	WebElement username;
	
	@FindBy(css="a.item[href='/contacts']")
	WebElement contactPageLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePage() throws InterruptedException {
		Thread.sleep(5000);
		String uname = username.getText();
		return uname;
	}
	
	public ContactsPage clickContact() {
		contactPageLink.click();
		return new ContactsPage();
	}

}
