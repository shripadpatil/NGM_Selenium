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
import com.ibm.pom.NG_Metering_App_SAP_Rainbow_POM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class NG_Metering_App_SAP_Rainbow_Test {

	private WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private String mprn_rainbow;
	private String supplier_code;
	private NG_Metering_App_SAP_Rainbow_POM hC_SAP_Rainbow_POM;
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
		hC_SAP_Rainbow_POM = new NG_Metering_App_SAP_Rainbow_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		mprn_rainbow = properties.getProperty("mprn_rainbow");
		supplier_code = properties.getProperty("supplier_code_rainbow");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);// open the browser 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void NGMeteringApp_SAPRainbow_Test() {
		try{
			hC_SAP_Rainbow_POM.sendUserName(username);
			hC_SAP_Rainbow_POM.sendPassword(password);
			hC_SAP_Rainbow_POM.clickLoginBtn(); 
			hC_SAP_Rainbow_POM.clickresedential();
			hC_SAP_Rainbow_POM.clickworkrequest();
			hC_SAP_Rainbow_POM.clickcreatenew();
			hC_SAP_Rainbow_POM.clickalert();
			hC_SAP_Rainbow_POM.selectsuppliercode(supplier_code);
			hC_SAP_Rainbow_POM.entermprn(mprn_rainbow);
			hC_SAP_Rainbow_POM.clicksearch();		
			Assert.assertEquals(hC_SAP_Rainbow_POM.mfgserialnocheck(), "customInputText clsTextbox success-field");
			screenShot.captureScreenShot("SAP_Rainbow_Connection_Success");
			System.out.println("*******SUCCESS - SAP Ranbow works*******");	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***SAP Rainbow is NOT responding as expected****");
			screenShot.captureScreenShot("SAP_Rainbow_Connection_Failed");
			Assert.assertTrue(false);
		}
	}
}
