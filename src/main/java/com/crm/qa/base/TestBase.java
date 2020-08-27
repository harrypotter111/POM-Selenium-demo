package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		log = Logger.getLogger(TestBase.class);

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void initialisation() {
		
		int IMPLICIT_WAIT_TIMEOUT = Integer.parseInt(prop.getProperty("IMPLICIT_WAIT_TIMEOUT"));
		int PAGE_LOAD_TIMEOUT = Integer.parseInt(prop.getProperty("PAGE_LOAD_TIMEOUT"));
		
		prop.getProperty("PAGE_LOAD_TIMEOUT");
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\FreeCRMTest\\lib\\chromedriver.exe");
			log.warn("***** Launching chrome driver *****");
			driver = new ChromeDriver();
			
			e_driver = new EventFiringWebDriver(driver);			
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			
			driver = e_driver;
			
			
			log.warn("***** Opening application URL *****");
			driver.get(prop.getProperty("url"));
			driver.manage().deleteAllCookies();
			log.warn("***** Maximising window *****");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		}

	}

	public static void close() {
		log.warn("***** Closing browser instance *****");
		driver.close();
		driver.quit();
	}

}
