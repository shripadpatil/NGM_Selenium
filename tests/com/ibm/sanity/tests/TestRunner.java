package com.ibm.sanity.tests;

import org.testng.TestNG;

import com.ibm.ExtentReportListener.ExtentReportListener;

public class TestRunner {
static TestNG testNg;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ExtentReportListener ext = new ExtentReportListener();
		
		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {NG_Metering_App_URL_Test.class, NG_Metering_App_LoginTest.class, NG_Metering_App_DB_Connectivity_Test.class, NG_Metering_App_SAP_Rainbow_Test.class, NG_Metering_App_SAP_Phoenix_Test.class });
		testNg.addListener(ext);
		testNg.run();
	}

}
