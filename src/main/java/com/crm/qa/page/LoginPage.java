package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public static LoginPage loginPage;

	@FindBy(css="input[name='email']")
	WebElement email;
	
	@FindBy(css="input[name='password']")
	WebElement password;
	
	@FindBy(css="div.ui.fluid.large.blue.submit.button")
	WebElement loginbtn;

	
	// initialise the page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// login page functionality
	
	public String validateLoginPage() {
		String title = driver.getTitle();
		return title;
	}
	
	public HomePage login(String eml, String pass) {
		email.sendKeys(eml);
		password.sendKeys(pass);
		loginbtn.click();
		return new HomePage();
	}

}
