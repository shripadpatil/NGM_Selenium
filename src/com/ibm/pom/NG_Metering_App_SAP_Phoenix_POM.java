package com.ibm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ibm.generics.GenericMethods;

public class NG_Metering_App_SAP_Phoenix_POM {
	private WebDriver driver; 
	private GenericMethods genericMethods = new GenericMethods(driver);
	
	public NG_Metering_App_SAP_Phoenix_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="_58_login")
	private WebElement username;
	@FindBy(name="_58_password")
	private WebElement password;
	@FindBy(className="login100-form-btn")
	private WebElement loginBtn; 
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[4]/a/span[1]")
	private WebElement commercial;
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[4]/ul/li[3]/a")
	private WebElement workrequest;
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/ul/li[4]/ul/li[3]/ul/li[1]/a")
	private WebElement createnew;
	@FindBy(xpath="/html/body/div[6]/div[3]/div/button[1]")
	private WebElement alert;
	@FindBy(xpath="//*[@id='_inccreateworkrequest_WAR_InCCreateWorkRequest100_supplierShortCodeSearch']")
	private WebElement suppliercode;  
	@FindBy(xpath="//*[@id='_inccreateworkrequest_WAR_InCCreateWorkRequest100_mprnSearch']")
	private WebElement entermprn;
	@FindBy(xpath="//*[@id='_inccreateworkrequest_WAR_InCCreateWorkRequest100_mprnSearchSubmit']")
	private WebElement search;
	@FindBy(css="#_inccreateworkrequest_WAR_InCCreateWorkRequest100_manufacturerSn")  
	private WebElement mfgserialno;
	
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
		this.commercial.click(); 
	}
	public void clickworkrequest() throws InterruptedException {
		Thread.sleep(2000);
		this.workrequest.click(); 
	}
	public void clickcreatenew() throws InterruptedException {
		Thread.sleep(2000);
		this.createnew.click(); 
	}
	public void clickalert() throws InterruptedException{
		Thread.sleep(3000);
		this.alert.click();
	}
	public void selectsuppliercode(String supplier_code) {
		genericMethods.selectdropdownbyvisibletext(suppliercode, supplier_code);
	}
	public void entermprn(String mprn) {
		this.entermprn.sendKeys(mprn);
	}
	public void clicksearch() throws InterruptedException{
		this.search.click(); 
		Thread.sleep(4000);
	}
	public String mfgserialnocheck() throws InterruptedException{
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.doubleClick(mfgserialno).perform();
		mfgserialno.click();
		entermprn.click();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		mfgserialno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".customInputText.clsTextbox.success-field"))); //customInputText clsTextbox success-field
		return mfgserialno.getAttribute("class");
	}	
}
