package com.pygacrm.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.Reporter;
/**
 * This class is used to get data from external file like properties file
 * @author shiba
 *
 */
public class FileUtility {

	/**
	 * This method is used to get "value" according to "key" from Properties file 
	 * @param path
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getValueFromPropertiesFile(String path,String key) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		//Reporter.log("$$ Successfully Fetched Value from PropertyFile $$", true);
		return value;
	}
	/**
	 * This method is used to get path of different file from "/src/main/resources/filepath.properties"
	 * @param key
	 * @return path
	 * @throws Throwable
	 */
	public String getPathFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/main/resources/filepath.properties");
		Properties p= new Properties();
		p.load(fis);
		String path = p.getProperty(key);
		//Reporter.log("$$ Successfully Fetched path of "+key+" from PropertyFile $$", true);
		return path;
	}
}
