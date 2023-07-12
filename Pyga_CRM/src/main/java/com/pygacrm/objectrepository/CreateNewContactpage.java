package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactpage {

	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img")
	private WebElement add_Organization_Name;
	
	@FindBy(name = "support_start_date")
	private WebElement support_start_date;
	@FindBy(name = "mailingstreet")
	private WebElement mailingstreet;
	@FindBy(name = "mailingpobox")
	private WebElement mailingpobox;
	@FindBy(name = "mailingcity")
	private WebElement mailingcity;
	@FindBy(name = "mailingstate")
	private WebElement mailingstate;
	@FindBy(name = "mailingzip")
	private WebElement mailingzip;
	@FindBy(name = "mailingcountry")
	private WebElement mailingcountry;
	@FindBy(xpath = "//b[normalize-space()='Copy Mailing Address']/..//input")
	private WebElement copy_mailing_addrs;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;
	
	public CreateNewContactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAdd_Organization_Name() {
		return add_Organization_Name;
	}

	public WebElement getSupport_start_date() {
		return support_start_date;
	}

	public WebElement getMailingstreet() {
		return mailingstreet;
	}

	public WebElement getMailingpobox() {
		return mailingpobox;
	}

	public WebElement getMailingcity() {
		return mailingcity;
	}

	public WebElement getMailingstate() {
		return mailingstate;
	}

	public WebElement getMailingzip() {
		return mailingzip;
	}

	public WebElement getMailingcountry() {
		return mailingcountry;
	}

	public WebElement getCopy_mailing_addrs() {
		return copy_mailing_addrs;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}
	
	
	
}
