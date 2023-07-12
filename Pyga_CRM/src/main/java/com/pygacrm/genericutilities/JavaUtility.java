package com.pygacrm.genericutilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.bytebuddy.utility.RandomString;
/**
 * This Class is used for different action of java utility
 * @author shiba
 *
 */
public class JavaUtility {

	Date dateObj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * This method used to generate 3character Random String
	 * @return
	 */
	public String getRandomstring () {
		String str=RandomString.make(3);
		return str;
	}
	
	/**
	 * used to get the system current date in "yyyy-MM-dd " format
	 * 
	 * @return
	 */
	public String getDate() {

		String date = sim.format(dateObj);
		return date;
	}
	/**
	 * used to get the required date in "yyyy-MM-dd " 
	 * format requiredDateCount is positive number , it provides upcoming date based numeric count
	 * if requiredDateCount is negative number , it provides previous date based numeric count
	 * @return rdate
	 * @param requiredDateCount
	 */
	public String getDate(int requiredDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDateCount);
		Date date = cal.getTime();
		String rdate = sim.format(date);
		return rdate;
	}
}
