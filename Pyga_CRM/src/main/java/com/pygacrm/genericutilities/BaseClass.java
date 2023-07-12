package com.pygacrm.genericutilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;


import com.pygacrm.objectrepository.HomePage;
import com.pygacrm.objectrepository.LoginPage;
public class BaseClass {
	public static WebDriver sdriver=null;
	public WebDriver driver=null;
	public FileUtility flib= new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility ju= new JavaUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	public String propertypath;
	public WebActionUtility w;
	
	/*@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void connectToDB() throws SQLException {
		dlib.connectToDB();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void closeDB() throws SQLException {
		dlib.closeDB();
	}*/
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void openBrowser(/*String browser*/) throws Throwable {
		propertypath=flib.getPathFromPropertiesFile("commondata");
		String pbrowser=flib.getValueFromPropertiesFile(propertypath, "browser");
		String url= flib.getValueFromPropertiesFile(propertypath, "url");
		String browser=System.getProperty("browser", pbrowser);
		/* Open Browser*/
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		this.sdriver=driver;
		driver.get(System.getProperty("url", url));
		w=new WebActionUtility(driver);
		w.waitImplicitlyForElement();
		driver.manage().window().maximize();
		Reporter.log("== Browser Opened and Maximized ==", true);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void closeBrowser() {
		driver.close();
		Reporter.log("== Browser Closed ==", true);
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void loginToapp() throws Throwable {
		String un=  flib.getValueFromPropertiesFile(propertypath, "username");
		String pw=  flib.getValueFromPropertiesFile(propertypath, "password");
		LoginPage l =new LoginPage(driver);
		l.loginToapp(un, pw);
		Reporter.log("== Successfully Logged in ==", true);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logoutFromApp() throws Throwable {
		HomePage h=new HomePage(driver);
		h.signoutFromapp();
		Reporter.log("== Successfully Logged out  ==", true);
	}
	
}
