package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name")
	private WebElement username_txtbox;
	
	@FindBy(name="user_password")
	private WebElement password_txtbox;
	
	@FindBy(id="submitButton")
	private WebElement login_btn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername_txtbox() {
		return username_txtbox;
	}

	public WebElement getPassword_txtbox() {
		return password_txtbox;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}
	
	/* Business Lib */
	public void loginToapp(String un, String pw) {
		username_txtbox.sendKeys(System.getProperty("username", un));
		password_txtbox.sendKeys(System.getProperty("password",pw));
		login_btn.click();
	}
	
	
}
