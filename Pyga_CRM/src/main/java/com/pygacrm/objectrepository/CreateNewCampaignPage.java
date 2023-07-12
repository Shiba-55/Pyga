package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {

	@FindBy(name = "campaignname")
	private WebElement campaignname;
	
	@FindBy(name = "campaigntype")
	private WebElement campaigntype_listbox;
	
	@FindBy(xpath = "//td[normalize-space()='Product']/..//img")
	private WebElement productname_add_btn;
	
	@FindBy(name = "closingdate")
	private WebElement closingdate;
	
	@FindBy(name = "targetaudience")
	private WebElement targetaudience;
	
	@FindBy(name = "numsent")
	private WebElement numsent;
	
	@FindBy(id = "targetsize")
	private WebElement targetsize;
	

	@FindBy(id = "sponsor")
	private WebElement sponsor;
	
	@FindBy(name = "budgetcost")
	private WebElement budgetcost;
	
	@FindBy(name = "expectedresponse")
	private WebElement expectedresponse_listbox;
	
	@FindBy(id = "expectedsalescount")
	private WebElement expectedsalescount;
	
	@FindBy(id = "expectedresponsecount")
	private WebElement expectedresponsecount;
	
	@FindBy(name = "actualcost")
	private WebElement actualcost;
	
	@FindBy(name = "expectedrevenue")
	private WebElement expectedrevenue;

	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_btn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancel_btn;

	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getCampaigntype_listbox() {
		return campaigntype_listbox;
	}

	public WebElement getProductname_add_btn() {
		return productname_add_btn;
	}

	public WebElement getClosingdate() {
		return closingdate;
	}

	public WebElement getTargetaudience() {
		return targetaudience;
	}

	public WebElement getNumsent() {
		return numsent;
	}

	public WebElement getTargetsize() {
		return targetsize;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}
	
	public WebElement getSponsor() {
		return sponsor;
	}

	public WebElement getBudgetcost() {
		return budgetcost;
	}

	public WebElement getExpectedresponse_listbox() {
		return expectedresponse_listbox;
	}

	public WebElement getExpectedsalescount() {
		return expectedsalescount;
	}

	public WebElement getExpectedresponsecount() {
		return expectedresponsecount;
	}

	public WebElement getActualcost() {
		return actualcost;
	}

	public WebElement getExpectedrevenue() {
		return expectedrevenue;
	}

	public WebElement getDescription() {
		return description;
	}
	
	
}
