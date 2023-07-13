package com.pyga.systemtest;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pygacrm.objectrepository.CampaignInformation;
import com.pygacrm.objectrepository.CampaignPage;
import com.pygacrm.objectrepository.CreateNewCampaignPage;
import com.pygacrm.objectrepository.CreateNewInvoicePage;
import com.pygacrm.objectrepository.CreateNewOrganization;
import com.pygacrm.objectrepository.CreateNewProductPage;
import com.pygacrm.objectrepository.CreateNewQuote;
import com.pygacrm.objectrepository.CreateNewSales_OrderPage;
import com.pygacrm.objectrepository.CreateNewVendorPage;
import com.pygacrm.objectrepository.HomePage;
import com.pygacrm.objectrepository.InvoiceInformationpage;
import com.pygacrm.objectrepository.InvoicePage;
import com.pygacrm.objectrepository.OpportunityPopupPage;
import com.pygacrm.objectrepository.OrganizationInformationPage;
import com.pygacrm.objectrepository.OrganizationPage;
import com.pygacrm.objectrepository.OrganizationPopupPage;
import com.pygacrm.objectrepository.ProductInformationPage;
import com.pygacrm.objectrepository.Product_Popup_Page;
import com.pygacrm.objectrepository.ProductsPage;
import com.pygacrm.objectrepository.QuoteInformationPage;
import com.pygacrm.objectrepository.QuotePage;
import com.pygacrm.objectrepository.QuotePopuuPage;
import com.pygacrm.objectrepository.SalesOrderInformationPage;
import com.pygacrm.objectrepository.SalesOrderPage;
import com.pygacrm.objectrepository.SalesOrderPopupPage;
import com.pygacrm.objectrepository.VendorInformationPage;
import com.pygacrm.objectrepository.VendorPage;
import com.pygacrm.objectrepository.VendorPopupPage;

import com.pygacrm.genericutilities.*;
/*
import genericutilities.ExcelUtility;
import genericutilities.FileUtility;
import genericutilities.JavaUtility;
import genericutilities.WebActionUtility;*/
//@Listeners(com.pygacrm.genericutilities.ListnerImplementation.class)
public class Invoice_234Test extends BaseClass {
	//@Test(retryAnalyzer = com.pygacrm.genericutilities.RetryImplementation.class)
	@Test(groups= {"regressionTest"})
	public void createInvoiceFromVendor() throws Throwable {
	
		String excelpath=flib.getPathFromPropertiesFile("testScript");
		String prod=elib.getExcelDataById(excelpath, "System", "tc_02", "Product Name");
		String camp=elib.getExcelDataById(excelpath, "System", "tc_02", "Campaign name");
		String org=elib.getExcelDataById(excelpath, "System", "tc_02", "Organization");
		/* Product data */
		String productcode=elib.getExcelDataById(excelpath, "System", "tc_02", "productcode");
		String vendor_part_no=elib.getExcelDataById(excelpath, "System", "tc_02", "vendor_part_no");
		String unit_price=elib.getExcelDataById(excelpath, "System", "tc_02", "unit_price");
		String qtyinstock=elib.getExcelDataById(excelpath, "System", "tc_02", "qtyinstock");
		String qtyindemand=elib.getExcelDataById(excelpath, "System", "tc_02", "qtyindemand");
		//String vedorname=elib.getExcelDataById(excelpath, "System", "tc_02", "Vedor name");
		/* campaign data */
		String targetaudience=elib.getExcelDataById(excelpath, "System", "tc_02", "targetaudience");
		String sponsor=elib.getExcelDataById(excelpath, "System", "tc_02", "sponsor");
		String numsent=elib.getExcelDataById(excelpath, "System", "tc_02", "numsent");
		String targetsize=elib.getExcelDataById(excelpath, "System", "tc_02", "targetsize");
		String budgetcost=elib.getExcelDataById(excelpath, "System", "tc_02", "budgetcost");
		String expectedsalescount=elib.getExcelDataById(excelpath, "System", "tc_02", "expectedsalescount");
		String expectedresponsecount=elib.getExcelDataById(excelpath, "System", "tc_02", "expectedresponsecount");
		String actualcost=elib.getExcelDataById(excelpath, "System", "tc_02", "actualcost");
		String expectedrevenue=elib.getExcelDataById(excelpath, "System", "tc_02", "expectedrevenue");
		String description=elib.getExcelDataById(excelpath, "System", "tc_02", "description");
		/* organization data */
		String website=elib.getExcelDataById(excelpath, "System", "tc_02", "website");
		String bill_street=elib.getExcelDataById(excelpath, "System", "tc_02", "bill_street");
		String phone=elib.getExcelDataById(excelpath, "System", "tc_02", "phone");
		String employees=elib.getExcelDataById(excelpath, "System", "tc_02", "employees");
		String email=elib.getExcelDataById(excelpath, "System", "tc_02", "email");
		String bill_pobox=elib.getExcelDataById(excelpath, "System", "tc_02", "bill_pobox");
		String bill_city=elib.getExcelDataById(excelpath, "System", "tc_02", "bill_city");
		String bill_state=elib.getExcelDataById(excelpath, "System", "tc_02", "bill_state");
		String bill_postalcode=elib.getExcelDataById(excelpath, "System", "tc_02", "bill_postalcode");
		String bill_country=elib.getExcelDataById(excelpath, "System", "tc_02", "bill_country");
		String annualrevenue=elib.getExcelDataById(excelpath, "System", "tc_02", "annualrevenue");
		String Opportunityname=elib.getExcelDataById(excelpath, "System", "tc_02", "Opportunityname");
		String qty=elib.getExcelDataById(excelpath, "System", "tc_02", "qty");
		
		String vend=elib.getExcelDataById(excelpath, "System", "tc_04", "Vedor name");
		
		String str=ju.getRandomstring();

		SoftAssert soft_assert= new SoftAssert();
		/* POM object */
		HomePage h= new HomePage(driver);
		ProductsPage product_page= new ProductsPage(driver);
		CreateNewProductPage cp= new CreateNewProductPage(driver);
		VendorPopupPage vp= new VendorPopupPage(driver);
		ProductInformationPage pi= new ProductInformationPage(driver);
		CampaignPage camp_page= new CampaignPage(driver);
		CreateNewCampaignPage cc= new CreateNewCampaignPage(driver);
		CampaignInformation ci= new CampaignInformation(driver);
		Product_Popup_Page pp= new Product_Popup_Page(driver);
		OrganizationPage org_page= new OrganizationPage(driver);
		CreateNewOrganization co=new CreateNewOrganization(driver);
		OrganizationInformationPage oi= new OrganizationInformationPage(driver);
		QuotePage q= new QuotePage(driver);
		CreateNewQuote cq= new CreateNewQuote(driver);
		QuoteInformationPage qi= new QuoteInformationPage(driver);
		OrganizationPopupPage op=new OrganizationPopupPage(driver);
		OpportunityPopupPage oppo= new OpportunityPopupPage(driver);
		SalesOrderPage sales= new SalesOrderPage(driver);
		CreateNewSales_OrderPage cs= new CreateNewSales_OrderPage(driver);
		SalesOrderInformationPage si= new SalesOrderInformationPage(driver);
		QuotePopuuPage qp= new QuotePopuuPage(driver);
		InvoicePage inv = new InvoicePage(driver);
		CreateNewInvoicePage cinv= new CreateNewInvoicePage(driver);
		InvoiceInformationpage ii= new InvoiceInformationpage(driver);
		SalesOrderPopupPage sp = new SalesOrderPopupPage(driver);
		VendorPage v= new VendorPage(driver);
		CreateNewVendorPage cv= new CreateNewVendorPage(driver);
		VendorInformationPage vi= new VendorInformationPage(driver);
		
		//Click on Vendor and create a vendor
		h.getVendors_link().click();
//click on create vendor
v.getCreateVendor_btn().click();
//Give Vendor name:
String vendorname=vend+str;
cv.getVendorname_txtbox().sendKeys(vendorname);
cv.getSave_btn().click();
String confirmvendor=vi.getVendor_name().getText().trim();
assertEquals(confirmvendor, vendorname,"Vendor is not created **");
Reporter.log("Vendor is created and verified", true);
		//Click on Product and create a product by adding vendor
		w.waitAndClick(h.getProducts_link());
		//h.getProducts_link().click();
		//click on create product
		product_page.getCreateProduct_btn().click();
		//Give Product name
		String product=prod+str;
		cp.getProductname_txtbox().sendKeys(product);
		//click on productactive check box
		WebElement checkbox = cp.getProduct_active_chkbox(); 
		soft_assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected");
		if (checkbox.isSelected()) {

		}
		else
			checkbox.click();
		//part number: 101
		cp.getPart_no().sendKeys(productcode);
		//Sale starts date & support start date
		String date = ju.getDate(15);
		cp.getSales_start_date().sendKeys(date);
		cp.getSupport_start_date().sendKeys(ju.getDate(30));
		//Add vendor
		String pwh = driver.getWindowHandle();
		cp.getVendorname_add_btn().click();
		w.swithToWindowBasedOnURL("module=Vendors");
		vp.getSearchbox().sendKeys(vendorname);
		WebElement in = vp.getSearch_listbox();
		w.select("vendorname", in);
		vp.getSearch_btn().click();
		vp.getSearchedVendor(driver, vendorname).click();
		driver.switchTo().window(pwh);
		//Select Manufacturer:		AltvetPet Inc.
		WebElement manufacturer = cp.getManufacturer_listbox();
		w.select("AltvetPet Inc.", manufacturer);
		//select product category : Hardware
		WebElement productcategory= cp.getProductcategory_listbox();
		w.select("Hardware", productcategory);
		//give vendor part number:403
		cp.getVendor_part_no().sendKeys(vendor_part_no);
		//give unit price: 10
		cp.getUnit_price().sendKeys(unit_price);
		//give qty in stock:100
		cp.getQtyinstock().sendKeys(qtyinstock);
		//give qty on demand:20
		cp.getQtyindemand().sendKeys(qtyindemand);
		//click on savebutton
		cp.getSave_btn().click();
		//verify if product is created
		w.waitForElement(pi.getProductname());
		String actprod = pi.getProductname().getText().trim();
		Assert.assertEquals(actprod, product, "Product is not created **");
		Reporter.log("Product is created and verified", true);
		/*if(actprod.equals(product)) {
		//	System.out.println("Product is created");
			
		}
		else {
			//System.out.println("Product is not created");
			Reporter.log("Product is not created **", true);
		}*/
		//create a campaign
		h.getCampaigns_link().click();
		w.waitForElement(camp_page.getCreateCampaign_btn());
		camp_page.getCreateCampaign_btn().click();
		//campaign name
		String Campaign_name =camp+str;
		w.waitForElement(cc.getCampaignname());
		cc.getCampaignname().sendKeys(Campaign_name);
		//campaign type
		WebElement type = cc.getCampaigntype_listbox();
		w.select("Advertisement", type);
		//target audience
		cc.getTargetaudience().sendKeys(targetaudience);
		//sponsor
		cc.getSponsor().sendKeys(sponsor);
		//num sent
		cc.getNumsent().sendKeys(numsent);
		//add product
		cc.getProductname_add_btn().click();
		String pwh1 = driver.getWindowHandle();
		w.swithToWindowBasedOnURL("module=Products");
		pp.getSearchbox().sendKeys(product);
		WebElement in1=pp.getSearch_listbox();
		w.select("productname", in1);
		pp.getSearch_btn().click();
		pp.getSearchedProduct(driver, product).click();
		//back to parent window
		driver.switchTo().window(pwh1);
		cc.getTargetsize().sendKeys(targetsize);
		//budget cost
		cc.getBudgetcost().sendKeys(budgetcost);
		//expected response
		WebElement res= cc.getExpectedresponse_listbox();
		w.select("Good", res);
		//expected sales count
		cc.getExpectedsalescount().sendKeys(expectedsalescount);
		//Expected Response Count
		cc.getExpectedresponsecount().sendKeys(expectedresponsecount);
		//actual cost
		cc.getActualcost().sendKeys(actualcost);
		//expected revenue
		cc.getExpectedrevenue().sendKeys(expectedrevenue);
		//description
		cc.getDescription().sendKeys(description);
		//save
		cc.getSave_btn().click();
		//verify campaign is created
		String text=ci.getcampaignname().getText().trim();
		Assert.assertEquals(text, Campaign_name, "Campaign is not created **");
		Reporter.log("Campaign is created and verified", true);
		/*if(text.contains(Campaign_name)) {
			
			//System.out.println("Campaign is created and verified: PASS");
		}
		else {
			Reporter.log("Campaign is not created **", true);
			//System.out.println("Campaign is not created: FAIL");
		}*/

		//Create Organization
		//click on organization tab
		h.getOrganizations_link().click();
		//click on create
		org_page.getCreateOrganization_btn().click();
		//give organization name
		String org_name = org+str;
		co.getOrganization_Name().sendKeys(org_name);
		//website"
		co.getWebsite().sendKeys(website);
		//Annual Revenue
		co.getPhone().sendKeys(phone);
		co.getEmployees().sendKeys(employees);
		co.getEmail().sendKeys(email);
		w.select("Engineering"	, co.getIndustry_listbox());
		w.select("Active", co.getRating_listbox());
		w.select("Customer", co.getType_listbox());
		co.getAnnual_revenue().sendKeys(annualrevenue);
		//biiling address
		co.getBill_street().sendKeys(bill_street);
		//po box
		co.getBill_pobox().sendKeys(bill_pobox);
		//billing city
		co.getBill_city().sendKeys(bill_city);
		//billing state
		co.getBill_state().sendKeys(bill_state);
		//billing pin
		co.getBill_postalcode().sendKeys(bill_postalcode);
		//billing country
		co.getBill_country().sendKeys(bill_country);
		//click on copy biiling address
		co.getCopy_biiling_addrs().click();
		//click on savebutton
		co.getSave_btn().click();
		//verify organization is created
		w.waitForElement(oi.getOrganizationname());
		String aorg =oi.getOrganizationname().getText().trim(); 
		Assert.assertEquals(aorg, org_name, "Organization is not created **");
		Reporter.log("Organization is created and verified", true);
		/*if(aorg.equals(org_name)) {
			
			//System.out.println("Organization is created");
		}
		else {
			Reporter.log("Organization is not created **", true);
			//System.out.println("Organization is not created");
		}*/

		//Create a quote
		//Click on Qoute 
		w.waitForElement(h.getQuotes_link());
		h.getQuotes_link().click();
		// click on create button
		q.getCreateQuote_btn().click();
		//give subject
		String quotename = product+" quote";
		cq.getQuote_subject().sendKeys(quotename);
		//give valid till date
		String vdate = ju.getDate(30);
		cq.getValidtill().sendKeys(vdate);
		//select the organization:
		String pwh2 = driver.getWindowHandle();
		cq.getAdd_Organization_Name().click();
		w.swithToWindowBasedOnURL("module=Accounts");
		op.getSearchbox().sendKeys(org_name);
		w.waitForElement(op.getSearch_listbox());
		w.select(op.getSearch_listbox(), "Organization Name");
		w.waitAndClick(op.getSearch_btn());
		//op.getSearch_btn().click();
		op.getSearchedOrgName(driver, org_name).click();
		w.swithToAlertWindowAndAccpect();
		driver.switchTo().window(pwh2);
		//give opportunity name
		cq.getAdd_Opportunity_Name().click();
		w.swithToWindowBasedOnURL("module=Potentials");
		oppo.getSearchbox().sendKeys(Opportunityname);
		w.select(oppo.getSearch_listbox(), "Opportunity");
		oppo.getSearch_btn().click();
		driver.switchTo().window(pwh2);
		cq.getCopy_biiling_addrs().click();
		//click on add product
		cq.getProduct_search_icon().click();
		w.swithToWindowBasedOnURL("module=Products");
		Thread.sleep(2000);
		pp.getSearchbox().sendKeys(product);
		w.select(pp.getSearch_listbox(), "Product Name");
		pp.getSearch_btn().click();
		pp.getSearchedProduct(driver, product).click();
		driver.switchTo().window(pwh2);
		//Give qty: 10
		cq.getQty().sendKeys(qty);
		//copy billing address
		cq.getCopy_biiling_addrs().click();
		//click on savebutton
		cq.getSave_btn().click();
		//Confirmation Quote created
		String confirmquote=qi.getquotename().getText().trim();
		Assert.assertEquals(confirmquote, quotename, "Quote is not created **");
		Reporter.log("Quote is created and verified", true);
		/*if (confirmquote.contains(quotename)) {
			//System.out.println("Created The Quote");
			
		}
		else
			Reporter.log("Quote is not created **", true);
			//System.out.println("Failed to create a Quote");*/

		//Create a Sales order
		//Click on sales order
		h.getSalesorder_link().click();
		//click on create button
		sales.getcreateSalesOrder_btn().click();
		//give subject:
		String salesordersub = product+"salesorder";
		System.out.println(salesordersub);
		w.waitForElement(cs.getSo_subject());
		cs.getSo_subject().sendKeys(salesordersub);
		//click on quote and select
		w.waitForElement(cs.getAdd_quote_name_btn());
		cs.getAdd_quote_name_btn().click();
		w.swithToWindowBasedOnURL("module=Quotes");
		Thread.sleep(2000);
		qp.getSearchbox().sendKeys(quotename);
		w.select(qp.getSearch_listbox(), "Subject");
		qp.getSearch_btn().click();
		qp.getSearchedProduct(driver, quotename).click();
		driver.switchTo().window(pwh2);
		//click on add organization and select
		cs.getAdd_Organization_Name().click();
		w.swithToWindowBasedOnURL("module=Accounts");
		op.getSearchbox().sendKeys(org_name);
		op.getSearch_btn().click();
		op.getSearchedOrgName(driver, org_name).click();
		w.swithToAlertWindowAndAccpect();
		driver.switchTo().window(pwh2);
		//copy billing address
		cs.getCopy_biiling_addrs().click();
		//click on savebutton
		w.waitForElement(cs.getSave_btn());
		cs.getSave_btn().click();
		//Confirmation Sales order created
		String confirmso=si.getSalesOrdername().getText().trim();
		Assert.assertEquals(confirmso, salesordersub, "Sales Order is not created **");
		Reporter.log("Sales Order is created and verified", true);
/*		if (confirmso.contains(salesordersub)) {
			//System.out.println("Created The Sales Order");
			
		}
		else
			Reporter.log("Sales Order is not created **", true);
			//System.out.println("Failed to create a Sales order");
*/
		//Create Invoice
		h.getInvoice_link().click();
		//click on create button
		inv.getCreateInvoice_btn().click();
		//give subject of invoice
		String inv_sub = "Invoice for "+product;
		cinv.getInv_subject().sendKeys(inv_sub);
		//select sales order
		w.waitForElement(cinv.getAdd_SO_btn());
		cinv.getAdd_SO_btn().click();
		//String pwh7 = driver.getWindowHandle();
		w.swithToWindowBasedOnURL("module=SalesOrder");
		sp.getSearchbox().sendKeys(salesordersub);
		w.select(sp.getSearch_listbox(), "Subject");
		sp.getSearch_btn().click();
		sp.getSearchedSO(driver, salesordersub).click();
		driver.switchTo().window(pwh2);
		//Select Organization name
		cinv.getAdd_Organization_Name().click();
		//String pwh6 = driver.getWindowHandle();
		w.swithToWindowBasedOnURL("module=Accounts");
		op.getSearchbox().sendKeys(org_name);
		op.getSearch_btn().click();
		op.getSearchedOrgName(driver, org_name).click();
		w.swithToAlertWindowAndAccpect();
		driver.switchTo().window(pwh2);
		//copy billing address
		cinv.getCopy_biiling_addrs().click();
		//click on savebutton
		cinv.getSave_btn().click();
		//Confirmation Invoice created
		String confirminv = ii.getinvoice_name().getText().trim();
		Assert.assertEquals(confirminv, inv_sub,"Invoice is not created **");
		Reporter.log("Invoice is created and verified", true);
		/*if (confirminv.contains(inv_sub)) {
			
			//System.out.println("Created The Invoice");
		}
		else
			//System.out.println("Failed to create invoice");
			Reporter.log("Invoice is not created **", true);*/
		
		Reporter.log("Invoice TestScript is successfully Completed", true);
		//System.out.println("Invoice Completed");
		elib.setdataToExcel(excelpath, "System", "tc_02", "Status", "pass");
		soft_assert.assertAll();
	}
}
