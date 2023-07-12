package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

	@FindBy(xpath = "//img[@title='Create Invoice...']")
	private WebElement createInvoice_btn;
	
	@FindBy(name = "search_text")
	private WebElement search_Invoice_txt_box;
	
	@FindBy(id="bas_searchfield")
	private WebElement search_in_option ;
	
	@FindBy(name = "submit")
	private WebElement search_btn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement delete_btn;
	
	
	public InvoicePage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}


	public WebElement getCreateInvoice_btn() {
		return createInvoice_btn;
	}


	public WebElement getSearch_Invoice_txt_box() {
		return search_Invoice_txt_box;
	}


	public WebElement getSearch_in_option() {
		return search_in_option;
	}


	public WebElement getSearch_btn() {
		return search_btn;
	}


	public WebElement getDelete_btn() {
		return delete_btn;
	}
}
