package com.pygacrm.genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer{
	int count=0;
	int retrylimit=4;
	@Override
	public boolean retry(ITestResult result) {
		if (retrylimit>count) {
			count++;
			return true;
		}
		return false;
	}
	

}
