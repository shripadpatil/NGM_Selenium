package com.ibm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NG_Metering_App_Login_POM {
	private WebDriver driver; 
	
	public NG_Metering_App_Login_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="_58_login")
	private WebElement username;
	@FindBy(name="_58_password")
	private WebElement password;
	@FindBy(className="login100-form-btn")
	private WebElement loginBtn; 
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/div/div/div/section/div/div/div/div[1]/h3")
	private WebElement welcome_page;

	public void sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
	}
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public String welcome_page() throws InterruptedException {
		Thread.sleep(10000L);
		return this.welcome_page.getText();
	}
}
