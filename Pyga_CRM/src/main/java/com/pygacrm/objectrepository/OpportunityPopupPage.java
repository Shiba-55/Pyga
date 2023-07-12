package com.pygacrm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPopupPage {

	@FindBy(id = "search_txt")
	private WebElement searchbox;
	
	@FindBy(name = "search_field")
	private WebElement search_listbox;
	
	@FindBy(name = "search")
	private WebElement search_btn;

	public OpportunityPopupPage(WebDriver driver) {
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
	 * This method gives the searched Opportunity name in the record
	 * @param orgname 
	 * @param Opportunityname
	 * @return product_in_list
	 */
	public WebElement getSearchedProduct(WebDriver driver, String Opportunityname) {
		WebElement Opportunity_in_list = driver.findElement(By.xpath("//a[.='"+Opportunityname+"']"));
		return Opportunity_in_list;
	}
}
