package com.pygacrm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopupPage {

	@FindBy(id = "search_txt")
	private WebElement searchbox;
	
	@FindBy(name = "search_field")
	private WebElement search_listbox;
	
	@FindBy(name = "search")
	private WebElement search_btn;

	public OrganizationPopupPage(WebDriver driver) {
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
	 * This method gives the searched Organization name in the record
	 * @param orgname 
	 * @param Organizationname
	 * @return Organization_in_list
	 */
	public WebElement getSearchedOrgName(WebDriver driver, String orgname) {
		WebElement organization_in_list = driver.findElement(By.xpath("//a[.='"+orgname+"']"));
		return organization_in_list;
	}
}
