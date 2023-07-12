package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	
	@FindBy(name = "vendorname")
	private WebElement vendorname_txtbox;
	
	@FindBy(id = "email")
	private WebElement email_txtbox;;
	
	@FindBy(id = "phone")
	private WebElement phone_txtbox;
	
	@FindBy(name = "website")
	private WebElement website_txtbox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;
	
	@FindBy(id = "category")
	private WebElement category;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@name='website']")
	private WebElement website;
	
	@FindBy(xpath = "//textarea[@name='street']")
	private WebElement streetadd;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "postalcode")
	private WebElement postalcode;
	
	@FindBy(id = "pobox")
	private WebElement pobox;
	
	@FindBy(id = "state")
	private WebElement state;
	
	@FindBy(id = "country")
	private WebElement country;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;

	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorname_txtbox() {
		return vendorname_txtbox;
	}

	public WebElement getEmail_txtbox() {
		return email_txtbox;
	}

	public WebElement getPhone_txtbox() {
		return phone_txtbox;
	}

	public WebElement getWebsite_txtbox() {
		return website_txtbox;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getStreetadd() {
		return streetadd;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostalcode() {
		return postalcode;
	}

	public WebElement getPobox() {
		return pobox;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getDescription() {
		return description;
	}
	
	
	
	
	
}
