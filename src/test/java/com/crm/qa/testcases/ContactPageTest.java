package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homepage ;
	ContactsPage contactPage;
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage= new LoginPage();
		homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		homepage.clickContact();
		contactPage = new ContactsPage();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		String sheetName = prop.getProperty("test_data_contacts_sheet_name");
		log.warn("***** Trying to fetch data from excel sheet *****");
		Object data[][] = TestUtil.getTestData(sheetName);		// take data from sheet in excel named as contacts
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void addContact(String fname, String lname, String email, String address, String status ) throws InterruptedException {
		//contactPage.inputDetails("Sounak", "Ghosh", "abc@g.com", "Ranchi Jharkhand", "Active");
		log.warn("***** Trying to add a new contact *****");
		contactPage.inputDetails(fname,lname,email,address,status);	
		Thread.sleep(3000);
	}
	
	
	@AfterMethod()
	public void tearDown() throws IOException {
		close();
	}

}
