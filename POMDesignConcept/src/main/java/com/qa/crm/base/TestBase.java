package com.qa.crm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.util.TestUtil;



public class TestBase {
	
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		 prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\alef1\\eclipse-workspace\\POMDesignConcept\\src\\main\\java\\com\\qa\\crm\\confiq\\Configaration.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\alef1\\Desktop\\A L I F\\Selenium Files\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\alef1\\Desktop\\A L I F\\Selenium Files\\WebDriver\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	 
	
	
	}


}
