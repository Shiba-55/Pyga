package com.pyga.systemtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pygacrm.objectrepository.ContactInformationPage;
import com.pygacrm.objectrepository.ContactPage;
import com.pygacrm.objectrepository.ContactPopupPage;
import com.pygacrm.objectrepository.CreateNewContactpage;
import com.pygacrm.objectrepository.CreateNewOpportunityPage;
import com.pygacrm.objectrepository.CreateNewOrganization;
import com.pygacrm.objectrepository.HomePage;
import com.pygacrm.objectrepository.LoginPage;
import com.pygacrm.objectrepository.OpportunityInformationpage;
import com.pygacrm.objectrepository.OppotunityPage;
import com.pygacrm.objectrepository.OrganizationInformationPage;
import com.pygacrm.objectrepository.OrganizationPage;
import com.pygacrm.objectrepository.OrganizationPopupPage;

import com.pygacrm.genericutilities.*;
/*
import genericutilities.ExcelUtility;
import genericutilities.FileUtility;
import genericutilities.JavaUtility;
import genericutilities.WebActionUtility;
import net.bytebuddy.utility.RandomString;*/
//@Listeners(com.pygacrm.genericutilities.ListnerImplementation.class)
public class OpportunitySystemTest extends BaseClass {
	
	@Test(groups= {"smokeTest","regressionTest"} )
	//@Test(retryAnalyzer = com.pygacrm.genericutilities.RetryImplementation.class)
	public void oppotunitySystem() throws Throwable {
		Reporter.log("OpportunitySystemTest", true);
		
		String excelpath=flib.getPathFromPropertiesFile("testScript");
		String org=elib.getExcelDataById(excelpath, "System", "tc_03", "Organization");
		String lna=elib.getExcelDataById(excelpath, "System", "tc_03", "Contact LastName");
		String oppo=elib.getExcelDataById(excelpath, "System", "tc_03", "Opportunity name");
		/* organization data */
		String website=elib.getExcelDataById(excelpath, "System", "tc_03", "website");
		String bill_street=elib.getExcelDataById(excelpath, "System", "tc_03", "bill_street");
		String phone=elib.getExcelDataById(excelpath, "System", "tc_03", "phone");
		String employees=elib.getExcelDataById(excelpath, "System", "tc_03", "employees");
		String email=elib.getExcelDataById(excelpath, "System", "tc_03", "email");
		String bill_pobox=elib.getExcelDataById(excelpath, "System", "tc_03", "bill_pobox");
		String bill_city=elib.getExcelDataById(excelpath, "System", "tc_03", "bill_city");
		String bill_state=elib.getExcelDataById(excelpath, "System", "tc_03", "bill_state");
		String bill_postalcode=elib.getExcelDataById(excelpath, "System", "tc_03", "bill_postalcode");
		String bill_country=elib.getExcelDataById(excelpath, "System", "tc_03", "bill_country");
		String annualrevenue=elib.getExcelDataById(excelpath, "System", "tc_03", "annual_revenue");
		
		String str=ju.getRandomstring();
		
				/* POM object */
				HomePage h= new HomePage(driver);
				OrganizationPage org_page= new OrganizationPage(driver);
				CreateNewOrganization co= new CreateNewOrganization(driver);
				OrganizationInformationPage oi= new OrganizationInformationPage(driver);
				ContactPage contact=new ContactPage(driver);
				CreateNewContactpage ccon= new CreateNewContactpage(driver);
				ContactInformationPage coni= new ContactInformationPage(driver);
				OrganizationPopupPage op=new OrganizationPopupPage(driver);
				OppotunityPage oppo_page=new OppotunityPage(driver);
				CreateNewOpportunityPage coppo=new CreateNewOpportunityPage(driver);
				OpportunityInformationpage oppoi=new OpportunityInformationpage(driver);
				ContactPopupPage conpop=new ContactPopupPage(driver);
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
				Assert.assertEquals(aorg, org_name,"Organization is not created **");
				Reporter.log("Organization is created and verified", true);
			/*	if(aorg.equals(org_name)) {
					System.out.println("Organization is created");
				}
				else {
					System.out.println("Organization is not created");
				}*/

		//create a contact
		h.getContacts_link().click();
		contact.getCreateContact_btn().click();
		String lname=lna+str;
		ccon.getLastname().sendKeys(lname);
		ccon.getAdd_Organization_Name().click();
		String pwh = driver.getWindowHandle();
		w.swithToWindowBasedOnURL("module=Accounts");
		op.getSearchbox().sendKeys(org_name);
		w.select(op.getSearch_listbox(), "Organization Name");
		op.getSearch_btn().click();
		op.getSearchedOrgName(driver, org_name);
		driver.switchTo().window(pwh);
		ccon.getSave_btn().click();
		String check = coni.getContactname().getText().trim();
		Assert.assertEquals(check, lname,"Contact is not created **");
		Reporter.log("Contact is created and verified", true);
		/*if(check.getText().trim().equals(lname)) {
			System.out.println("Contact is created");
		}
		else {
			System.out.println("Contact is not created");
		}*/

		//create opportunity
		h.getOpportunities_link().click();
		oppo_page.getCreateOppotunity_btn().click();
		String opp=oppo+str;
		coppo.getOpportunityname().sendKeys(opp);
		w.select("Contacts", coppo.getRelated_to_type_listbox());
		w.waitForElement(coppo.getAdd_relatedTo());
		coppo.getAdd_relatedTo().click();
		w.swithToWindowBasedOnURL("module=Contacts");
		//Thread.sleep(2000);
		w.waitForPageByUrl("Contacts");
		w.waitForElement(conpop.getSearchbox());
		w.waitAndType(conpop.getSearchbox(), lname);
		/*conpop.getSearchbox().sendKeys(lname);*/
		w.select(conpop.getSearch_field_listbox(), "Last Name");
		//w.select("lastname", conpop.getSearch_field_listbox());
		w.waitAndClick(conpop.getSearch_btn());
		//conpop.getSearch_btn().click();
		w.waitAndClick(conpop.getSearchedcontact(driver, lname));
		//conpop.getSearchedcontact(driver, lname).click();
		driver.switchTo().window(pwh);
		String date = ju.getDate(60);
		coppo.getClosingdate().sendKeys(date);
		w.select("Needs Analysis", coppo.getSales_stage_listbox());
		coppo.getSave_btn().click();
		 String check1 = oppoi.getOpportunityname().getText().trim();
		 Assert.assertEquals(check1, opp,"Opportunity is not created **");
			Reporter.log("Opportunity is created and verified", true);
		/*if(check1.getText().trim().equals(opp)) {
			System.out.println("Opportunity is created");
		}
		else {
			System.out.println("Opportunity is not created");
		}*/
		//System.out.println("Opportunity Completed");
			Reporter.log("Campaign TestScript is successfully Completed", true);
		elib.setdataToExcel(excelpath, "System", "tc_03", "Status", "pass");

	}

}
