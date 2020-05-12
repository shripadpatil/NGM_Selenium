package com.ibm.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ibm.generics.ScreenShot;
import com.ibm.pom.NG_Metering_App_URL_POM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class NG_Metering_App_URL_Test {
	
	private WebDriver driver; 
	private String baseUrl; 
	private NG_Metering_App_URL_POM application_url_check_POM; 
	private static Properties properties; 
	private ScreenShot screenShot; 

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		//FileInputStream inStream = new FileInputStream("./resources/others.properties");
		FileInputStream inStream = new FileInputStream("C:\\NG_Metering_Application_Sanity_Test\\others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		application_url_check_POM = new NG_Metering_App_URL_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void NGMeteringApp_URL_Test() throws InterruptedException {
    	try {
			Assert.assertEquals(application_url_check_POM.username_field(), ""); // validating 
			screenShot.captureScreenShot("URL_Up_Screenshot"); //URL is up, screenshot captured
			System.out.println("***URL is UP && Running****");
		} catch (java.lang.AssertionError e) {
			System.out.println("***URL is Down****");
			screenShot.captureScreenShot("URL_down_Screenshot");//if any error,  screenshot captured
			e.printStackTrace();
			Assert.assertTrue(false);
		}	
	}	
}
