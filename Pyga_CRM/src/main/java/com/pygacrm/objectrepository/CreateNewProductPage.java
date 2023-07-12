package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	@FindBy(name = "productname")
	private WebElement productname_txtbox;
	
	@FindBy(name = "sales_start_date")
	private WebElement sales_start_date;
	
	@FindBy(name = "manufacturer")
	private WebElement manufacturer_listbox;
	
	@FindBy(name = "productcategory")
	private WebElement productcategory_listbox;
	
	@FindBy(name = "start_date")
	private WebElement support_start_date;
	
	@FindBy(xpath = "//td[normalize-space()='Vendor Name']/..//img")
	private WebElement vendorname_add_btn;
	
	@FindBy(name = "productcode")
	private WebElement part_no;

	@FindBy(id = "unit_price")
	private WebElement unit_price;
	
	@FindBy(id = "qtyinstock")
	private WebElement qtyinstock;
	
	@FindBy(id = "qtyindemand")
	private WebElement qtyindemand;
	
	@FindBy(name = "discontinued")
	private WebElement product_active_chkbox;
	
	@FindBy(name = "vendor_part_no")
	private WebElement vendor_part_no;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;

	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public WebElement getProductname_txtbox() {
		return productname_txtbox;
	}

	public WebElement getSales_start_date() {
		return sales_start_date;
	}

	public WebElement getManufacturer_listbox() {
		return manufacturer_listbox;
	}

	public WebElement getProductcategory_listbox() {
		return productcategory_listbox;
	}

	public WebElement getSupport_start_date() {
		return support_start_date;
	}

	public WebElement getVendorname_add_btn() {
		return vendorname_add_btn;
	}

	public WebElement getPart_no() {
		return part_no;
	}

	public WebElement getUnit_price() {
		return unit_price;
	}

	public WebElement getQtyinstock() {
		return qtyinstock;
	}

	public WebElement getQtyindemand() {
		return qtyindemand;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}

	public WebElement getProduct_active_chkbox() {
		return product_active_chkbox;
	}

	public WebElement getVendor_part_no() {
		return vendor_part_no;
	}
	
	

}
