package com.pyga.systemtest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pygacrm.genericutilities.BaseClass;
import com.pygacrm.objectrepository.*;
/*import com.pygacrm.objectrepository.CampaignPage;
import com.pygacrm.objectrepository.CreateNewCampaignPage;
import com.pygacrm.objectrepository.CreateNewProductPage;
import com.pygacrm.objectrepository.CreateNewVendorPage;
import com.pygacrm.objectrepository.HomePage;
import com.pygacrm.objectrepository.LoginPage;
import com.pygacrm.objectrepository.ProductInformationPage;
import com.pygacrm.objectrepository.Product_Popup_Page;
import com.pygacrm.objectrepository.ProductsPage;
import com.pygacrm.objectrepository.VendorInformationPage;
import com.pygacrm.objectrepository.VendorPage;
import com.pygacrm.objectrepository.VendorPopupPage;*/

import com.pygacrm.genericutilities.*;
/*import genericutilities.ExcelUtility;
import genericutilities.FileUtility;
import genericutilities.JavaUtility;
import genericutilities.WebActionUtility;
import net.bytebuddy.utility.RandomString;*/
//@Listeners(com.pygacrm.genericutilities.ListnerImplementation.class)
public class CampaignSystemTest extends BaseClass {
	//@Test(retryAnalyzer = com.pygacrm.genericutilities.RetryImplementation.class)
	@Test(groups= {"smokeTest","regressionTest"})
	public void createcCampaign() throws Throwable {
	// Changes done from git hub
		//git
		Reporter.log("****CampaignSystemTest****", true);
		String excelpath=flib.getPathFromPropertiesFile("testScript");
		String vend=elib.getExcelDataById(excelpath, "System", "tc_01", "Vedor name");
		String prod=elib.getExcelDataById(excelpath, "System", "tc_01", "Product Name");
		String camp=elib.getExcelDataById(excelpath, "System", "tc_01", "Campaign name");
		/* Vendor data */
		String email=elib.getExcelDataById(excelpath, "System", "tc_01", "Email");
		String category=elib.getExcelDataById(excelpath, "System", "tc_01", "category");
		String phone=elib.getExcelDataById(excelpath, "System", "tc_01", "phone");
		String website=elib.getExcelDataById(excelpath, "System", "tc_01", "website");
		String street=elib.getExcelDataById(excelpath, "System", "tc_01", "street");
		String city=elib.getExcelDataById(excelpath, "System", "tc_01", "city");
		String postalcode=elib.getExcelDataById(excelpath, "System", "tc_01", "postalcode");
		String pobox=elib.getExcelDataById(excelpath, "System", "tc_01", "pobox");
		String state=elib.getExcelDataById(excelpath, "System", "tc_01", "state");
		String country=elib.getExcelDataById(excelpath, "System", "tc_01", "country");
		String description=elib.getExcelDataById(excelpath, "System", "tc_01", "description");
		/* Campaign data */
		String targetaudience=elib.getExcelDataById(excelpath, "System", "tc_01", "targetaudience");
		String sponsor=elib.getExcelDataById(excelpath, "System", "tc_01", "sponsor");
		String numsent=elib.getExcelDataById(excelpath, "System", "tc_01", "numsent");
		String targetsize=elib.getExcelDataById(excelpath, "System", "tc_01", "targetsize");
		String budgetcost=elib.getExcelDataById(excelpath, "System", "tc_01", "budgetcost");
		String expectedsalescount=elib.getExcelDataById(excelpath, "System", "tc_01", "expectedsalescount");
		String expectedresponsecount=elib.getExcelDataById(excelpath, "System", "tc_01", "expectedresponsecount");
		String actualcost=elib.getExcelDataById(excelpath, "System", "tc_01", "actualcost");
		String expectedrevenue=elib.getExcelDataById(excelpath, "System", "tc_01", "expectedrevenue");
		
		String str=ju.getRandomstring();
		
		/* POM object */
		HomePage h= new HomePage(driver);
		VendorPage v= new VendorPage(driver);
		CreateNewVendorPage cv= new CreateNewVendorPage(driver); 
		VendorInformationPage vi= new VendorInformationPage(driver);
		ProductsPage pr= new ProductsPage(driver);
		CreateNewProductPage cp= new CreateNewProductPage(driver);
		ProductInformationPage pi= new ProductInformationPage(driver);
		VendorPopupPage vp= new VendorPopupPage(driver);
		CampaignPage camp_page=new CampaignPage(driver);
		CreateNewCampaignPage cc= new CreateNewCampaignPage(driver);
		CampaignInformation ci=new CampaignInformation(driver);
		Product_Popup_Page pp= new Product_Popup_Page(driver);
		
		//Click on vendors
		w.waitForElement(h.getVendors_link());
		h.getVendors_link().click();
		//create a vendor
		v.getCreateVendor_btn().click();
		//vendor name
		String ven=vend+str;
		cv.getVendorname_txtbox().sendKeys(ven);
		//vendor email
		cv.getEmail_txtbox().sendKeys(email);
		//category
		cv.getCategory().sendKeys(category);
		//phone
		cv.getPhone().sendKeys(phone);
		//website
		cv.getWebsite().sendKeys(website);
		//address information
		//street
		cv.getStreetadd().sendKeys(street);
		//city
		cv.getCity().sendKeys(city);
		//postal code
		cv.getPostalcode().sendKeys(postalcode);
		//PObox
		cv.getPobox().sendKeys(pobox);
		//state
		cv.getState().sendKeys(state);
		//country
		cv.getCountry().sendKeys(country);
		//description
		cv.getDescription().sendKeys(description);
		//click on save
		cv.getSave_btn().click();
		//Verify that Vendor is created
		String avname=vi.getVendor_name().getText().trim();
		Assert.assertEquals(avname, ven,"Vendor is not created **");
		Reporter.log("Vendor is created and verified", true);
		/*if(avname.equals(ven)) {
			
			//System.out.println("Vendor is created");
		}
		else {
			Reporter.log("Vendor is not created **", true);
			//System.out.println("Vendor is not created");
		}*/

		//create a product
		h.getProducts_link().click();
		pr.getCreateProduct_btn().click();
		String product=prod+str;
		cp.getProductname_txtbox().sendKeys(product);
		//sales start date
		String date = ju.getDate(15);
		cp.getSales_start_date().sendKeys(date);
		//product category
		WebElement prod1 = cp.getProductcategory_listbox();
		w.select("Hardware", prod1);
		//Support Start Date
		String supportdate=ju.getDate(30);
		cp.getSupport_start_date().sendKeys(supportdate);
		//Select vendor name
		String pwh = driver.getWindowHandle();
		cp.getVendorname_add_btn().click();
		w.swithToWindowBasedOnURL("module=Vendors");
		vp.getSearchbox().sendKeys(ven);
		WebElement in = vp.getSearch_listbox();
		w.select("vendorname", in);
		vp.getSearch_btn().click();
		vp.getSearchedVendor(driver, ven).click();
		driver.switchTo().window(pwh);
		//to save
		WebElement save =cp.getSave_btn(); 
		w.waitAndClick(save);
		//verify if product is created
		String actprod = pi.getProductname().getText().trim();
		Assert.assertEquals(actprod, product,"Product is not created **");
		Reporter.log("Product is created and verified", true);
		/*if(actprod.equals(product)) {
			
			//System.out.println("Product is created");
		}
		else {
			Reporter.log("Product is not created **", true);
			//System.out.println("Product is not created");
		}*/

		//create a campaign
		h.getCampaigns_link().click();
		camp_page.getCreateCampaign_btn().click();
		//campaign name
		String campname=camp+str;
		cc.getCampaignname().sendKeys(campname);
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
		String pwh1 = driver.getWindowHandle();
		cc.getProductname_add_btn().click();
		w.swithToWindowBasedOnURL("module=Products");
		pp.getSearchbox().sendKeys(product);
		WebElement in1 = pp.getSearch_listbox(); 
		w.select("productname", in1);
		w.waitAndClick(pp.getSearch_btn());
		//pp.getSearch_btn().click();
		pp.getSearchedProduct(driver, product).click();
		//back to parent window
		driver.switchTo().window(pwh1);
		cc.getTargetsize().sendKeys(targetsize);
		//budget cost
		cc.getBudgetcost().sendKeys(budgetcost);
		//expected response
		WebElement res=cc.getExpectedresponse_listbox();
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
		w.waitForElement(cc.getSave_btn());
		cc.getSave_btn().click();
		//verify campaign is created
		String text=ci.getcampaignname().getText().trim();
		Assert.assertEquals(text, campname,"Campaign is not created **");
		Reporter.log("Campaign is created and verified", true);
		/*if(text.contains(campname)) {
			
			//System.out.println("Campaign is created and verified: PASS");
		}
		else {
			Reporter.log("Campaign is not created **", true);
			//System.out.println("Campaign is not created: FAIL");
		}*/
		//System.out.println("Campaign Completed===>>>>Testscript passed");
		Reporter.log("Campaign TestScript is successfully Completed", true);
		elib.setdataToExcel(excelpath, "System", "tc_01", "Status", "pass");
	}
}
