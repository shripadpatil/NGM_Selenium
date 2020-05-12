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

//import com.ibm.generics.GenericMethods;
import com.ibm.generics.ScreenShot;
import com.ibm.pom.NG_Metering_App_VIEW_ALL_POM;
//import com.ibm.pom.NG_Metering_App_Login_POM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class NG_Metering_App_DB_Connectivity_Test {

	private WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private NG_Metering_App_VIEW_ALL_POM hC_VIew_All_POM;
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
		hC_VIew_All_POM = new NG_Metering_App_VIEW_ALL_POM(driver); 
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
	public void NG_Metering_App_DBConnectivity_Test() {
		try{
			hC_VIew_All_POM.sendUserName(username);
			hC_VIew_All_POM.sendPassword(password);
			hC_VIew_All_POM.clickLoginBtn(); 
			hC_VIew_All_POM.clickresedential();
			hC_VIew_All_POM.clickworkrequest();
			hC_VIew_All_POM.clickviewall();
			hC_VIew_All_POM.selectjobtypeInstall();
			hC_VIew_All_POM.clickgo();
			Assert.assertEquals(hC_VIew_All_POM.viewallmprntext(), "Export");
			System.out.println("******DB Connectivity is working as expected*******");
			screenShot.captureScreenShot("DB_Connection_Success");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***DB Connectivity is NOT working as expected****");
			screenShot.captureScreenShot("DB_Connection_Failed");
			Assert.assertTrue(false);
		}
	}
}
