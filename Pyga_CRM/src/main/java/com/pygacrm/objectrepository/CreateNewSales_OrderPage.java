package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewSales_OrderPage {

	@FindBy(name = "subject")
	private WebElement so_subject;
	@FindBy(name = "customerno")
	private WebElement customerno;
	@FindBy(xpath = "//td[normalize-space()='Opportunity Name']/..//img")
	private WebElement add_opporyunity_name_btn;
	@FindBy(xpath = "//td[normalize-space()='Quote Name']/..//img")
	private WebElement add_quote_name_btn;
	@FindBy(xpath = "//td[normalize-space()='Contact Name']/..//img[@title='Select']")
	private WebElement add_contact_name_btn;
	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img")
	private WebElement add_Organization_Name;
	@FindBy(name = "duedate")
	private WebElement duedate;
	@FindBy(xpath = "//b[normalize-space()='Copy Billing address']/..//input")
	private WebElement copy_biiling_addrs;
	@FindBy(name = "description")
	private WebElement description;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;
	
	@FindBy(id = "searchIcon1")
	private WebElement searchIcon_product;
	public CreateNewSales_OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSo_subject() {
		return so_subject;
	}
	public WebElement getCustomerno() {
		return customerno;
	}
	public WebElement getAdd_opporyunity_name_btn() {
		return add_opporyunity_name_btn;
	}
	public WebElement getAdd_quote_name_btn() {
		return add_quote_name_btn;
	}
	public WebElement getAdd_contact_name_btn() {
		return add_contact_name_btn;
	}
	public WebElement getAdd_Organization_Name() {
		return add_Organization_Name;
	}
	public WebElement getDuedate() {
		return duedate;
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
	public WebElement getSearchIcon_product() {
		return searchIcon_product;
	}
	
	
	
}
