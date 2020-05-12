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
import com.ibm.pom.NG_Metering_App_Login_POM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class NG_Metering_App_LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private NG_Metering_App_Login_POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("C:\\NG_Metering_Application_Sanity_Test\\others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new NG_Metering_App_Login_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);// open the browser 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void NGMeteringApp_Login_Test() {
		try{
			loginPOM.sendUserName(username);
			loginPOM.sendPassword(password);
			loginPOM.clickLoginBtn(); 
			Assert.assertEquals(loginPOM.welcome_page(), "Welcome HC!"); // validating 
			System.out.println("***You have logged in successfully****");
			screenShot.captureScreenShot("URL_Login_Success");	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***Your login functionality failed****");
			screenShot.captureScreenShot("URL_login_Failed");
			Assert.assertTrue(false);
		}
	}
}
