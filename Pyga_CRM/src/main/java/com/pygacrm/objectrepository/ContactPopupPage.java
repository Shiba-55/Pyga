package com.pygacrm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPopupPage {

	@FindBy(id = "search_txt")
	private WebElement searchbox;
	
	@FindBy(name = "search_field")
	private WebElement search_listbox;
	
	@FindBy(name = "search")
	private WebElement search_btn;

	@FindBy(name = "search_field")
	private WebElement search_field_listbox;
	
	public ContactPopupPage(WebDriver driver) {
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
	
	
	public WebElement getSearch_field_listbox() {
		return search_field_listbox;
	}

	/* Business flow */
	/**
	 * This method gives the searched Contact name in the record
	 * @param Contactname 
	 * @param Contactname
	 * @return Contact_in_list
	 */
	public WebElement getSearchedcontact(WebDriver driver, String Contactname) {
		WebElement Contact_in_list = driver.findElement(By.xpath("//a[normalize-space()='"+Contactname.trim()+"']"));
		return Contact_in_list;
	}
}
