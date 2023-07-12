package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunityPage {

	@FindBy(name = "potentialname")
	private WebElement opportunityname;
	@FindBy(id = "related_to_type")
	private WebElement related_to_type_listbox;
	@FindBy(xpath = "//input[@id='related_to_display']/../img")
	private WebElement add_relatedTo;
	@FindBy(name = "closingdate")
	private WebElement closingdate;
	
	@FindBy(name = "sales_stage")
	private WebElement sales_stage_listbox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;
	
	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityname() {
		return opportunityname;
	}

	public WebElement getRelated_to_type_listbox() {
		return related_to_type_listbox;
	}

	public WebElement getAdd_relatedTo() {
		return add_relatedTo;
	}

	public WebElement getClosingdate() {
		return closingdate;
	}

	public WebElement getSales_stage_listbox() {
		return sales_stage_listbox;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}
	
	
	
	
	
	
}
