package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewInvoicePage {

	@FindBy(name = "subject")
	private WebElement inv_subject;
	@FindBy(name = "invoicedate")
	private WebElement invoicedate;
	@FindBy(xpath = "//td[text()='Sales Order 			']/..//img")
	private WebElement add_SO_btn;
	@FindBy(xpath = "//td[normalize-space()='Contact Name']/..//img[@title='Select']")
	private WebElement add_contact_name_btn;
	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img")
	private WebElement add_Organization_Name;
	@FindBy(xpath = "//b[normalize-space()='Copy Billing address']/..//input")
	private WebElement copy_biiling_addrs;
	@FindBy(name = "description")
	private WebElement description;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;
	
	
	public CreateNewInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getInv_subject() {
		return inv_subject;
	}


	public WebElement getInvoicedate() {
		return invoicedate;
	}


	public WebElement getAdd_SO_btn() {
		return add_SO_btn;
	}


	public WebElement getAdd_contact_name_btn() {
		return add_contact_name_btn;
	}


	public WebElement getAdd_Organization_Name() {
		return add_Organization_Name;
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
	
	
	
}
