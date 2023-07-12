package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewQuote {

	@FindBy(name = "subject")
	private WebElement quote_subject;
	
	@FindBy(xpath = "//td[normalize-space()='Opportunity Name']/..//img")
	private WebElement add_Opportunity_Name;
	
	@FindBy(name = "quotestage")
	private WebElement quotestage_listbox;
	
	@FindBy(xpath = "//td[normalize-space()='Contact Name']/..//img[@alt='Select']")
	private WebElement add_Contact_name;
	
	@FindBy(name = "validtill")
	private WebElement validtill;
	
	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img")
	private WebElement add_Organization_Name;
	
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
	
	@FindBy(id = "searchIcon1")
	private WebElement product_search_icon;
	
	@FindBy(id = "qty1")
	private WebElement qty;

	public CreateNewQuote(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuote_subject() {
		return quote_subject;
	}

	public WebElement getAdd_Opportunity_Name() {
		return add_Opportunity_Name;
	}

	public WebElement getQuotestage_listbox() {
		return quotestage_listbox;
	}

	public WebElement getAdd_Contact_name() {
		return add_Contact_name;
	}

	public WebElement getValidtill() {
		return validtill;
	}

	public WebElement getAdd_Organization_Name() {
		return add_Organization_Name;
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

	public WebElement getProduct_search_icon() {
		return product_search_icon;
	}

	public WebElement getQty() {
		return qty;
	}
	
	
	
	
	
	
}
