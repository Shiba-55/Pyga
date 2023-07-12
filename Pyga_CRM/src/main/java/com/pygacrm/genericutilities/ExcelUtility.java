package com.pygacrm.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
/**
 * This class is used to get data from Excel File
 * @author shiba
 *
 */
public class ExcelUtility {

	/**
	 * This method gives data from cell value
	 * @param path
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public String getExcelDataByRow(String path,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fin= new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.toString();
		wb.close();
		//Reporter.log("## Successfully Fetched data from excel ##", true);
		return value;
	}
	/**
	 * This Method gives data based on testId and Columnheader
	 * @param path
	 * @param sheetName
	 * @param testid
	 * @param columnHeader
	 * @return data
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getExcelDataById(String path,String sheetName, String testid,String columnHeader) throws Throwable, IOException {
		FileInputStream fin= new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int testrowno = 0;
		for (int i = 0; i <= rowCount; i++) {
			String acttestId = sheet.getRow(i).getCell(0).toString();
			if (acttestId.equalsIgnoreCase(testid)) {
				break;
			}
			testrowno++;
		}
		int cellCount=sheet.getRow(testrowno-1).getLastCellNum();
		int testcolno=0;
		for (int i = 0; i <cellCount ; i++) {
			String actcolHeader = sheet.getRow(testrowno-1).getCell(i).toString();
			if (actcolHeader.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testcolno++;
		}
		
		String data = sheet.getRow(testrowno).getCell(testcolno).toString();
		wb.close();
		//Reporter.log("## Successfully Fetched data from excel ##", true);
		return data;	
	}
	
	/**
	 * used to get the maximum used row count in required Sheet 
	 * @param filePath
	 * @param sheetName
	 * @return rowcount
	 * @throws Throwable
	 */
	public int  getRowCount(String filePath, String sheetName) throws Throwable {
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		//Reporter.log("## Successfully Fetched Row Count from excel ##", true);
		return rowCount;
	}
	
	/**
	 * This Method helps to write data into excel file by column header
	 * @param path
	 * @param sheetName
	 * @param testId
	 * @param columnHeader
	 * @param data
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 */
	public void setdataToExcel(String path, String sheetName , String testId, String columnHeader , String data) throws EncryptedDocumentException, Throwable{
		FileInputStream fin= new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int testrowno = 0;
		for (int i = 0; i <= rowCount; i++) {
			String acttestId = sheet.getRow(i).getCell(0).toString();
			if (acttestId.equalsIgnoreCase(testId)) {
				break;
			}
			testrowno++;
		}
		int cellCount=sheet.getRow(testrowno-1).getLastCellNum();
		int testcolno=0;
		for (int i = 0; i <cellCount ; i++) {
			String actcolHeader = sheet.getRow(testrowno-1).getCell(i).toString();
			if (actcolHeader.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testcolno++;
		}
		
		sheet.getRow(testrowno).getCell(testcolno).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(path);
		wb.write(fout);
		wb.close();
		Reporter.log("## Successfully written data into excel ##", true);
	}
}
