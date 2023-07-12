package com.pygacrm.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Reporter;

import com.mysql.jdbc.Driver;

/**
 * This class is used to perform all the Database Action
 * @author shiba
 *
 */
public class DataBaseUtility {
	
	FileUtility f= new FileUtility();
	
	String url,username,password;
	Driver driver;
	 Connection connection;
	 ResultSet result;
	
	public DataBaseUtility() {
		String filepath;
		try {
			filepath = f.getPathFromPropertiesFile("Databasecredential");
		url=f.getValueFromPropertiesFile(filepath, "url");
		username=f.getValueFromPropertiesFile(filepath, "username");
		password=f.getValueFromPropertiesFile(filepath, "passwords");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Used to establish the connection
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		driver= new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection(url, username, password);
		Reporter.log("** Successfully Connected to DataBase **", true);
	}
	/**
	 * used to close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		connection.close();
		Reporter.log("** Successfully closed DataBase **", true);
	}
	/**
	 *  This method will execute the Query
	 * @param query
	 * @return value
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		ResultSet res = connection.createStatement().executeQuery(query);
		Reporter.log("** Successfully executed query **", true);
		return res;
	}
	/**
	 * Used to update a query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String query) throws SQLException {
		int res = connection.createStatement().executeUpdate(query);
		Reporter.log("** Successfully updated query **", true);
		return res;
	}
	/**
	 * This method will execute querry based on querry and it will verify the data. 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		result=connection.createStatement().executeQuery(querry);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
         
	}

	
}
