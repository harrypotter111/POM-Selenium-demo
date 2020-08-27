package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;

public class HomePageTest extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homepage;
	public ContactsPage contactspage;

	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePagetest() throws InterruptedException {
		String username = homepage.verifyHomePage();
		Assert.assertEquals(username, "Sounak Ghosh");
	}
	
	@Test(priority=2)
	public void clickContact() throws InterruptedException {
		contactspage = homepage.clickContact();
		Thread.sleep(3000);
	}
	
	
	
	@AfterMethod
	public void teardown() {
		close();
	}
	
	
}
