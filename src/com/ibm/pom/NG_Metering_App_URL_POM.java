package com.ibm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NG_Metering_App_URL_POM {
	
	private WebDriver driver;   
	public NG_Metering_App_URL_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="_58_login")
	private WebElement username;
	
	public String username_field() throws InterruptedException {
		Thread.sleep(10000L);
		return this.username.getText();
	}
}
