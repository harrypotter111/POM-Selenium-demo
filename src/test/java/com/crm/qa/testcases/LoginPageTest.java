package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;
	HomePage HomePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		LoginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.warn("***** Validating login page *****");
		String title = LoginPage.validateLoginPage();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginCheck() {
		HomePage=LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		close();
	}
}
