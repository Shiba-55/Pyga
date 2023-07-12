package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {

	@FindBy(name = "accountname")
	private WebElement organization_Name;
	@FindBy(name = "website")
	private WebElement website;
	@FindBy(name = "phone")
	private WebElement phone;
	@FindBy(id = "employees")
	private WebElement employees;
	@FindBy(id = "email1")
	private WebElement email;
	@FindBy(name = "industry")
	private WebElement industry_listbox;
	@FindBy(name = "rating")
	private WebElement rating_listbox;
	@FindBy(name = "accounttype")
	private WebElement type_listbox;
	@FindBy(name = "bill_street")
	private WebElement bill_street;
	@FindBy(name = "bill_pobox")
	private WebElement bill_pobox;
	@FindBy(name = "bill_city")
	private WebElement bill_city;
	@FindBy(name = "bill_state")
	private WebElement bill_state;
	@FindBy(name = "bill_code")
	private WebElement bill_postalcode;
	@FindBy(name = "bill_country")
	private WebElement bill_country;
	@FindBy(xpath = "//b[normalize-space()='Copy Billing address']/..//input")
	private WebElement copy_biiling_addrs;
	@FindBy(name = "description")
	private WebElement description;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;
	
	@FindBy(name = "annual_revenue")
	private WebElement annual_revenue;
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver	, this);
	}

	public WebElement getOrganization_Name() {
		return organization_Name;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmployees() {
		return employees;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getIndustry_listbox() {
		return industry_listbox;
	}

	public WebElement getRating_listbox() {
		return rating_listbox;
	}

	public WebElement getType_listbox() {
		return type_listbox;
	}

	public WebElement getBill_street() {
		return bill_street;
	}

	public WebElement getBill_pobox() {
		return bill_pobox;
	}

	public WebElement getBill_city() {
		return bill_city;
	}

	public WebElement getBill_state() {
		return bill_state;
	}

	public WebElement getBill_postalcode() {
		return bill_postalcode;
	}

	public WebElement getBill_country() {
		return bill_country;
	}

	public WebElement getCopy_biiling_addrs() {
		return copy_biiling_addrs;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}

	public WebElement getAnnual_revenue() {
		return annual_revenue;
	}
	
	
	
}
