package com.excelOpertion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	String filePath ;

	/**
	 * This is parameterized constructor which takes 
	 * filePath as a parameter and assigns it to 
	 * the excel file path.  
	 * 
	 * @param filePath
	 */
	public ExcelLibrary(String filePath) {
		this.filePath = filePath;
	}


	/**
	 * getRowCount function provides rowCount of provided
	 * excel sheetName.
	 * This function is takes a single parameter
	 * sheetName and returns the rowCount.
	 * 
	 * @param sheetName
	 * @return
	 */
	public  int getRowCount(String sheetName){
		int rowCount = -1;

		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);

			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);

			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);

			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}
			//get last row number as row count
			rowCount = sh.getLastRowNum();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowCount;

	}


	/**
	 * 
	 * getCellData function is tailored to get data in 
	 * a particular cell from a sheet. 
	 * This function takes 3 parameters sheetName,
	 * rowNum,cellNum and finds the data and returns
	 * the data found in the form of Object.
	 * 
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public Object getCellData(String sheetName,int rowNum,int cellNum){
		Object data = null;
		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);

			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);

			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);

			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}

			//get Into Row
			Row r = sh.getRow(rowNum);
			//get into cell
			Cell c = r.getCell(cellNum);

			if(c == null || c.getCellType() == Cell.CELL_TYPE_BLANK)
			{
				data = "";
			}
			else
			{
				switch(c.getCellType()){

				case Cell.CELL_TYPE_STRING: //get String cell value
					data = c.getStringCellValue();

					break;
				case Cell.CELL_TYPE_NUMERIC:data = c.getNumericCellValue();
				break;

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}


	/**
	 * writeToCell function writes the data into
	 * specified cell of an excel sheet.
	 * It takes 4 parameters sheetName,rowNum,
	 * cellNum and data.It returns nothing.
	 * 
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 */
	public void writeToCell(String sheetName,int rowNum,int cellNum,String data){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);

			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);

			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);

			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}

			//get Into Row
			Row r = sh.getRow(rowNum);

			//create cell 
			Cell c = r.createCell(cellNum);
			c.setCellValue(data);
			//open file in write mode
			fos = new FileOutputStream(filePath);
			//write data to file
			wb.write(fos);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * getColumnCount function gives the number of columns in a particular row in an excel sheet.
	 * It takes 2 parameters sheetName,rowNum and returns column count.
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */

	public int getColumnCount(String sheetName,int rowNum)
	{
		int colCount = -1;

		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);
			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);
			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);

			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}
			//get last row number as row count
			if(sh.getRow(rowNum)!=null)
			colCount =  sh.getRow(rowNum).getLastCellNum();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return colCount;
	}

	/**
	 * getSheetDataAsArray function gives complete sheet data in the form of two dimensional array.
	 * It takes 2 parameters sheetName,noOfCols and returns object array.
	 * @param sheetName
	 * @param noOfCols
	 * @return
	 */

	public Object[][] getSheetDataAsArray(String sheetName,int noOfCols){
		Object[][] data = null;
		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);
			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);
			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);

			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}
			int rowCount = sh.getLastRowNum();
			data = new Object[rowCount][noOfCols]; 
			for(int i = 1;i<=rowCount;i++){
				for (int j = 0; j < noOfCols; j++) {
					Cell c = sh.getRow(i).getCell(j);
					switch (c.getCellType()) {
					case Cell.CELL_TYPE_STRING: // get String cell value
						data[i - 1][j] = c.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						data[i - 1][j] = c.getNumericCellValue();
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}

	/**
	 * getRowData function provides a complete
	 * row data of specified row from a sheet.
	 * It takes 2 parameters sheetName and rowNum
	 * and returns data in array of String. 
	 * 
	 * 
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */

	public String[] getRowData(String sheetName,int rowNum)
	{

		ExcelLibrary e  = new ExcelLibrary(System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx");



		int colCount = e.getColumnCount("Scenarios", rowNum);



		String data[]=new String[colCount]; 

		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx");

			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);

			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);

			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}


			for (int j = 0; j < colCount; j++) {
				Cell c = sh.getRow(rowNum).getCell(j);
				if(c !=null)
				{
					switch (c.getCellType()) {
					case Cell.CELL_TYPE_STRING: // get String cell value
						data[j] = c.getStringCellValue();

						break;
					case Cell.CELL_TYPE_NUMERIC:
						data[j] =String.valueOf(c.getNumericCellValue());
						break;

					}
				}
			}


		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (InvalidFormatException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		finally {
			try {
				fis.close();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}




		return data;

	}

}
