package com.pygacrm.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		TakesScreenshot takesscreenshot = (TakesScreenshot) BaseClass.sdriver;
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		String datetime=LocalDateTime.now().toString().replaceAll(" ", "_").replaceAll(":", "_");
		File dest= new File("./Screenshots/"+methodname+"_"+datetime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
