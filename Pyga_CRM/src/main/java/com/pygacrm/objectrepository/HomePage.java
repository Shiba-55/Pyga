package com.pygacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pygacrm.genericutilities.WebActionUtility;



public class HomePage {
	WebActionUtility w;
	@FindBy(linkText = "Leads")
	private WebElement leads_link ;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizations_link ;
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts_link;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunities_link;
	
	@FindBy(linkText = "Products")
	private WebElement products_link;
	
	@FindBy(linkText = "Documents")
	private WebElement documents_link;
	
	@FindBy(linkText = "Email")
	private WebElement email_link;
	
	@FindBy(xpath = "//td[.='More']")
	private WebElement more_btn ;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator_btn ;
	
	@FindBy(name = "Invoice")
	private WebElement invoice_link;
	
	@FindBy(name = "Sales Order")
	private WebElement salesorder_link;
	
	@FindBy(name = "Quotes")
	private WebElement quotes_link;
	
	@FindBy(name = "Vendors")
	private WebElement vendors_link;
	
	@FindBy(name = "Campaigns")
	private WebElement campaigns_link;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signout_link;
	
	
	

	public HomePage(WebDriver driver) throws Throwable {
		PageFactory.initElements(driver, this);
		w= new WebActionUtility(driver);
	}

	public WebElement getLeads_link() {
		return leads_link;
	}

	public WebElement getOrganizations_link() {
		return organizations_link;
	}

	public WebElement getContacts_link() {
		return contacts_link;
	}

	public WebElement getOpportunities_link() {
		return opportunities_link;
	}

	public WebElement getProducts_link() {
		return products_link;
	}

	public WebElement getDocuments_link() {
		return documents_link;
	}

	public WebElement getEmail_link() {
		return email_link;
	}

	public WebElement getMore_btn() {
		return more_btn;
	}

	public WebElement getAdministrator_btn() {
		return administrator_btn;
	}
	
	/*Business flow*/
	public WebElement getInvoice_link() throws Throwable {
		w.mouseOverOnElement(more_btn);
		return invoice_link;
	}

	public WebElement getSalesorder_link() {
		w.mouseOverOnElement(more_btn);
		return salesorder_link;
	}

	public WebElement getQuotes_link() {
		w.mouseOverOnElement(more_btn);
		return quotes_link;
	}

	public WebElement getVendors_link() {
		w.mouseOverOnElement(more_btn);
		return vendors_link;
	}

	public WebElement getCampaigns_link() {
		w.mouseOverOnElement(more_btn);
		return campaigns_link;
	}

	public WebElement getSignout_link() {
		w.mouseOverOnElement(administrator_btn);
		return signout_link;
	}
	
	/* businesee flow */
	public void signoutFromapp() {
		w.mouseOverOnElement(administrator_btn);
		 signout_link.click();;
	}
	
	
}
