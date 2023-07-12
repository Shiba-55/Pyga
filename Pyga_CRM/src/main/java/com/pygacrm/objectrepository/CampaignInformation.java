package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformation {

	@FindBy(id = "mouseArea_Campaign Name")
	private WebElement campaignname;
	
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement edit_btn;
	
	@FindBy(xpath = "//input[@title='Duplicate [Alt+U]']")
	private WebElement duplicate_btn;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement delete_btn;

	public CampaignInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getcampaignname() {
		return campaignname;
	}

	public WebElement getEdit_btn() {
		return edit_btn;
	}

	public WebElement getDuplicate_btn() {
		return duplicate_btn;
	}

	public WebElement getDelete_btn() {
		return delete_btn;
	}
	
}
