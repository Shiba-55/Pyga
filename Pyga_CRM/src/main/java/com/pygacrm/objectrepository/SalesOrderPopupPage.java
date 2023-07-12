package com.pygacrm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPopupPage {

	@FindBy(id = "search_txt")
	private WebElement searchbox;
	
	@FindBy(name = "search_field")
	private WebElement search_listbox;
	
	@FindBy(name = "search")
	private WebElement search_btn;

	public SalesOrderPopupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearch_listbox() {
		return search_listbox;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}
	
	/* Business flow */
	/**
	 * This method gives the searched SalesOrder name in the record
	 * @param SalesOrdername 
	 * @param driver
	 * @return SalesOrder_in_list
	 */
	public WebElement getSearchedSO(WebDriver driver, String SalesOrdername) {
		WebElement SalesOrder_in_list = driver.findElement(By.xpath("//a[.='"+SalesOrdername+"']"));
		return SalesOrder_in_list;
	}
}
