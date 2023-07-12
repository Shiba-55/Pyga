package com.pygacrm.genericutilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * contains all web browser related actions which includes mouse move , select , switchToWindow , wait etc
 * @author shiba 
 *
 */
public class WebActionUtility {
	FileUtility fLib = new FileUtility();
	int timeout;
	WebDriver driver;
	
	public WebActionUtility(WebDriver driver) throws Throwable {
		this.driver=driver;
		String filepath = fLib.getPathFromPropertiesFile("commondata");
		String stimeout = fLib.getValueFromPropertiesFile(filepath, "Timeout");
		 timeout = Integer.parseInt(stimeout);
	}

	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 * @throws Throwable 
	 */
	public void waitImplicitlyForElement() throws Throwable {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 * @throws Throwable 
	 */
	public void waitForPageByUrl(String partailPageURL) throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 * @throws Throwable 
	 */
	public void waitForElement(WebElement element) throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This is a Custom wait for waiting for element and click
	 * @param element
	 * @throws Throwable 
	 */
	   public void waitAndClick(WebElement element) throws Throwable
	   {

		   int count = 0;
	       while(count<timeout) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	       Reporter.log("++ Successfully Clicked on the element ++", true);
	   }
	   /**
	    * Custom wait for the element and type the data
	    * @param element
	    * @param data
	    * @throws InterruptedException
	    */
	   public void waitAndType(WebElement element, String data) throws InterruptedException
	   {
		   int count = 0;
	       while(count<timeout) {
		    	   try {
		    	       element.sendKeys(data);
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }
	
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(String partialWindowTitle) {
		
	        	Set<String> set = driver.getWindowHandles();
	          Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getTitle();
			          if(currentWindowTitle.contains(partialWindowTitle)) {
			        	  //System.out.println(partialWindowTitle + "Switch to Window is passed--!");
			        	  Reporter.log(partialWindowTitle + "   Switch to Window is passed--!", true);
			        	  break;
			          }
	          }
	}
	/**
	 *  used to Switch to Any Window based on partial Window URL
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindowBasedOnURL(String partialWindowURL) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getCurrentUrl();
			          if(currentWindowTitle.contains(partialWindowURL)) {
			        	 // System.out.println(partialWindowURL + "Switch to Window is passed--!");
			        	  Reporter.log(partialWindowURL + " Switch to Window is passed--!", true);
			        	  break;
			          }
		    	}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Reporter.log("++ Alert is Handled and clicked on ok ++", true);
	}
	
	
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel() {
		Alert alt = driver.switchTo().alert();
		 alt.dismiss();
		 Reporter.log("++ Alert is Handled and clicked on cancel ++", true);
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		Reporter.log(">> Selected by index no:"+index, true);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param text
	 */
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		Reporter.log(">> Selected by Visible text:"+text, true);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(String value,WebElement element  ) {
		Select sel = new Select(element);
		sel.selectByValue(value);
		Reporter.log(">> Selected by value:"+value, true);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
		Reporter.log("successfully mouseover to: "+elemnet.getText(), true);
	}
	
	/**
	 * 	 used to right click  on specified element
	 * @param driver
	 * @param elemnet
	 */
	
	public void rightClickOnElement(WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
		
	}
	
	/**
	 * This is used to execute the javascript
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(javaScript, null);
	}

	   

	    
	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey() {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 



	

}