package com.pyga.systemtest;

import static org.testng.Assert.*;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pygacrm.objectrepository.CreateNewOrganization;
import com.pygacrm.objectrepository.CreateNewProductPage;
import com.pygacrm.objectrepository.CreateNewQuote;
import com.pygacrm.objectrepository.CreateNewSales_OrderPage;
import com.pygacrm.objectrepository.CreateNewVendorPage;
import com.pygacrm.objectrepository.HomePage;
import com.pygacrm.objectrepository.LoginPage;
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
import com.pygacrm.objectrepository.VendorInformationPage;
import com.pygacrm.objectrepository.VendorPage;
import com.pygacrm.objectrepository.VendorPopupPage;

import com.pygacrm.genericutilities.BaseClass;
/*
import genericutilities.ExcelUtility;
import genericutilities.FileUtility;
import genericutilities.JavaUtility;
import genericutilities.WebActionUtility;
import net.bytebuddy.utility.RandomString;*/
//@Listeners(com.pygacrm.genericutilities.ListnerImplementation.class)
public class SalesOrderTest extends BaseClass {
	//@Test(retryAnalyzer = com.pygacrm.genericutilities.RetryImplementation.class)
	@Test(groups= {"smokeTest","regressionTest"})
	public void salesorderFromVendor() throws Throwable {
		Reporter.log("****SalesOrderTest****", true);
		String excelpath=flib.getPathFromPropertiesFile("testScript");
		String vend=elib.getExcelDataById(excelpath, "System", "tc_04", "Vedor name");
		String prod=elib.getExcelDataById(excelpath, "System", "tc_04", "Product Name");
		String org=elib.getExcelDataById(excelpath, "System", "tc_04", "org_name");
		/* Vendor data */
		String street=elib.getExcelDataById(excelpath, "System", "tc_04", "street");
		String city=elib.getExcelDataById(excelpath, "System", "tc_04", "city");
		String postalcode=elib.getExcelDataById(excelpath, "System", "tc_04", "postalcode");
		String pobox=elib.getExcelDataById(excelpath, "System", "tc_04", "pobox");
		String state=elib.getExcelDataById(excelpath, "System", "tc_04", "state");
		String country=elib.getExcelDataById(excelpath, "System", "tc_04", "country");
		/* prpduct data*/
		String productcode=elib.getExcelDataById(excelpath, "System", "tc_04", "productcode");
		String vendor_part_no=elib.getExcelDataById(excelpath, "System", "tc_04", "vendor_part_no");
		String unit_price=elib.getExcelDataById(excelpath, "System", "tc_04", "unit_price");
		String qtyinstock=elib.getExcelDataById(excelpath, "System", "tc_04", "qtyinstock");
		String qtyindemand=elib.getExcelDataById(excelpath, "System", "tc_04", "qtyindemand");
		String qty=elib.getExcelDataById(excelpath, "System", "tc_04", "qty");
		
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
		String qty1=elib.getExcelDataById(excelpath, "System", "tc_02", "qty");
		
		String str=ju.getRandomstring();
		
				/* POM object */
				HomePage h =new HomePage(driver);
				VendorPage v= new VendorPage(driver);
				CreateNewVendorPage cv= new CreateNewVendorPage(driver);
				VendorInformationPage vi= new VendorInformationPage(driver);
				ProductsPage product_page=new ProductsPage(driver);
				CreateNewProductPage cp= new CreateNewProductPage(driver);
				ProductInformationPage pi= new ProductInformationPage(driver);
				VendorPopupPage vp= new VendorPopupPage(driver);
				QuotePage q = new QuotePage(driver);
				CreateNewQuote cq= new CreateNewQuote(driver);
				QuoteInformationPage qi= new QuoteInformationPage(driver);
				Product_Popup_Page pp= new Product_Popup_Page(driver);
				OrganizationPopupPage op= new OrganizationPopupPage(driver);
				SalesOrderPage sales= new SalesOrderPage(driver);
				CreateNewSales_OrderPage cs= new CreateNewSales_OrderPage(driver);
				SalesOrderInformationPage si= new SalesOrderInformationPage(driver);
				QuotePopuuPage qp= new QuotePopuuPage(driver);
				
				OrganizationPage org_page= new OrganizationPage(driver);
				CreateNewOrganization co=new CreateNewOrganization(driver);
				OrganizationInformationPage oi= new OrganizationInformationPage(driver);
				
		//Click on Vendor and create a vendor
				h.getVendors_link().click();
		//click on create vendor
		v.getCreateVendor_btn().click();
		//Give Vendor name:
		String vendorname=vend+str;
		cv.getVendorname_txtbox().sendKeys(vendorname);
		//address
		//Street: 342 Balasore
		cv.getStreetadd().sendKeys(street);
		//city: Balasore
		cv.getCity().sendKeys(city);
		//Postal code: 756040
		cv.getPostalcode().sendKeys(postalcode);
		//po box: Dhobasila
		cv.getPobox().sendKeys(pobox);
		// state: Odisha
		cv.getState().sendKeys(state);
		//country: India
		cv.getCountry().sendKeys(country);
		//click on save button
		cv.getSave_btn().click();
		//Confirmation Vendor created
		String confirmvendor=vi.getVendor_name().getText().trim();
		assertEquals(confirmvendor, vendorname,"Vendor is not created **");
		Reporter.log("Vendor is created and verified", true);
		/*if (confirmvendor.equals(vendorname)) {
			System.out.println("Created a Vendor");
		}
		else
			System.out.println("Failed to create a Vendor");*/
		
				//create Product
				h.getProducts_link().click();
				//click on create product
				product_page.getCreateProduct_btn().click();
				//Give Product name
				String product=prod+str;
				cp.getProductname_txtbox().sendKeys(product);
				//click on productactive check box
				WebElement checkbox = cp.getProduct_active_chkbox(); 
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
				assertEquals(actprod, product,"Product is not created **");
				Reporter.log("Product is created and verified", true);
				/*if(actprod.equals(product)) {
					System.out.println("Product is created");
				}
				else {
					System.out.println("Product is not created");
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
				cq.getAdd_Organization_Name().click();
				String pwh2 = driver.getWindowHandle();
				w.swithToWindowBasedOnURL("module=Account");
				op.getSearchbox().sendKeys(org_name);
				w.waitForElement(op.getSearch_listbox());
				w.select(op.getSearch_listbox(), "Organization Name");
				op.getSearch_btn().click();
				op.getSearchedOrgName(driver, org_name).click();
				w.swithToAlertWindowAndAccpect();
				driver.switchTo().window(pwh2);
				cq.getCopy_biiling_addrs().click();
				//click on add product
				cq.getProduct_search_icon().click();
				
				w.swithToWindowBasedOnURL("module=Products&action=Popup");
				w.waitForPageByUrl("module=Products&action=Popup");
				//w.waitAndType(pp.getSearchbox(), product);
				Thread.sleep(3000);
				//w.waitForElement(pp.getSearchbox());
				//pp.getSearchbox().sendKeys(product);
				w.waitForElement(pp.getSearchbox());
				w.waitAndType(pp.getSearchbox(), product);
				//w.waitAndType(pp.getSearchbox(), product);
				//w.select(pp.getSearch_listbox(), "Product Name");
				w.waitAndClick(pp.getSearch_btn());
				//w.waitForElement(pp.getSearch_btn());
			//	pp.getSearch_btn().click();
				w.waitAndClick(pp.getSearchedProduct(driver, product));
				//w.waitForElement(pp.getSearchedProduct(driver, product));
				//pp.getSearchedProduct(driver, product).click();
				driver.switchTo().window(pwh2);
				//Give qty: 10
				cq.getQty().sendKeys(qty1);
				//copy billing address
				cq.getCopy_biiling_addrs().click();
				//click on savebutton
				cq.getSave_btn().click();
				//Confirmation Quote created
				String confirmquote=qi.getquotename().getText().trim();
				assertEquals(confirmquote, quotename,"Quote is not created **");
				Reporter.log("Quote is created and verified", true);
				/*if (confirmquote.contains(quotename)) {
					System.out.println("Created The Quote");
				}
				else
					System.out.println("Failed to create a Quote");*/

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
				qp.getSearchbox().sendKeys(quotename);
				w.select(qp.getSearch_listbox(), "Subject");
				qp.getSearch_btn().click();
				qp.getSearchedProduct(driver, quotename).click();
				driver.switchTo().window(pwh2);
				//click on add organization and select
				cs.getAdd_Organization_Name().click();
				//String pwh4 = driver.getWindowHandle();
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
				assertEquals(confirmso, salesordersub,"Sales Order is not created **");
				Reporter.log("Sales Order is created and verified", true);
				
			/*	if (confirmso.contains(salesordersub)) {
					System.out.println("Created The Sales Order");
				}
				else
					System.out.println("Failed to create a Sales order");*/
				Reporter.log("Sales Order TestScript is successfully Completed", true);
		//System.out.println("Sales Order Completed");
		elib.setdataToExcel(excelpath, "System", "tc_04", "Status", "pass");
	
	}
}
