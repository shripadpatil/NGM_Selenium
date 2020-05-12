package com.ibm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ibm.generics.GenericMethods;

public class NG_Metering_App_VIEW_ALL_POM {
	private WebDriver driver; 
	private GenericMethods genericMethods = new GenericMethods(driver);
	
	public NG_Metering_App_VIEW_ALL_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="_58_login")
	private WebElement username;
	@FindBy(name="_58_password")
	private WebElement password;
	@FindBy(className="login100-form-btn")
	private WebElement loginBtn; 
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/a/span[2]")
	private WebElement resedential;
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/ul/li[3]/a")
	private WebElement workrequest;
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[3]/ul/li[3]/ul/li[3]/a")
	private WebElement viewall;
	@FindBy(xpath="//*[@id='jobType']")
	private WebElement jobtype;  
	@FindBy(xpath="//*[@id='yui_patched_v3_11_0_1_1588191618847_460']")
	private WebElement installselect;
	@FindBy(id="go")
	private WebElement go;
	@FindBy(xpath="//*[@id='exportBtn']")	
	private WebElement mprn;

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
	public void clickresedential() throws InterruptedException {
		Thread.sleep(2000);
		this.resedential.click(); 
	}
	public void clickworkrequest() throws InterruptedException {
		Thread.sleep(2000);
		this.workrequest.click(); 
	}
	public void clickviewall() throws InterruptedException {
		Thread.sleep(2000);
		this.viewall.click(); 
	}
	public void selectjobtypeInstall() {
		genericMethods.selectdropdownbyvisibletext(jobtype, "Install");
	}
	public void clickgo(){
		this.go.click(); 
	}
	public void viewallcheck() throws InterruptedException {
		Thread.sleep(10000);
		this.mprn.click(); 
	}
	public String viewallmprntext() throws InterruptedException {
		Thread.sleep(10000);
		return this.mprn.getText(); 
	}
}
