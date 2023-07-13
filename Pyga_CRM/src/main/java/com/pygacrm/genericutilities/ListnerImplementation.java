package com.pygacrm.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		Random random = new Random();
		int randNum=random.nextInt(1000);
		ExtentSparkReporter spark= new ExtentSparkReporter("ExtentReport/Report.html"+randNum);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("Shiba Shankar");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "Windows 10");
		report.setSystemInfo("Executed By", "Shiba shankar");
		report.setSystemInfo("Reviewed By", "Litan");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String screenshot=WebActionUtility.takescreenshot(BaseClass.sdriver,result.getMethod().getMethodName() );
		test.addScreenCaptureFromPath(screenshot);
		/*String methodname = result.getMethod().getMethodName();
		TakesScreenshot takesscreenshot = (TakesScreenshot) BaseClass.sdriver;
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		String datetime=LocalDateTime.now().toString().replaceAll(" ", "_").replaceAll(":", "_");
		File dest= new File("./Screenshots/"+methodname+"_"+datetime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
