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
import com.ibm.pom.NG_Metering_App_SAP_Phoenix_POM;
import com.ibm.utility.DriverFactory;
import com.ibm.utility.DriverNames;

public class NG_Metering_App_SAP_Phoenix_Test {

	private WebDriver driver;
	private String baseUrl;
	private String username;
	private String password;
	private String mprn_phoenix;
	private String supplier_code;
	private NG_Metering_App_SAP_Phoenix_POM hC_SAP_Phoenix_POM;
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
		hC_SAP_Phoenix_POM = new NG_Metering_App_SAP_Phoenix_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		mprn_phoenix = properties.getProperty("mprn_phoenix");
		supplier_code = properties.getProperty("supplier_code_pheonix");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);// open the browser 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void NGMeteringApp_SAPPhoenix_Test() {
		try{
			hC_SAP_Phoenix_POM.sendUserName(username);
			hC_SAP_Phoenix_POM.sendPassword(password);
			hC_SAP_Phoenix_POM.clickLoginBtn(); 
			hC_SAP_Phoenix_POM.clickresedential();
			hC_SAP_Phoenix_POM.clickworkrequest();
			hC_SAP_Phoenix_POM.clickcreatenew();
			hC_SAP_Phoenix_POM.clickalert();
			hC_SAP_Phoenix_POM.selectsuppliercode(supplier_code);
			hC_SAP_Phoenix_POM.entermprn(mprn_phoenix);
			hC_SAP_Phoenix_POM.clicksearch();
			Assert.assertEquals(hC_SAP_Phoenix_POM.mfgserialnocheck(), "customInputText clsTextbox success-field focus");
			System.out.println("*******SUCCESS - SAP Phoenix works******");
			screenShot.captureScreenShot("SAP_Phoenix_Connection_Success");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("***SAP Phoenix is NOT responding as expected****");
			screenShot.captureScreenShot("SAP_Phoenix_Connection_Failed");
			Assert.assertTrue(false);
		}
	}
}
