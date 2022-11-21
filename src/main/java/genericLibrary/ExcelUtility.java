package genericLibrary;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericLibrary.IpathConstants.IPathConstants;


public class ExcelUtility {
	/**
	 * This method are used to read and write data using Excel
	 * @author kavya
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */
	

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	
	{
		FileInputStream fi = new FileInputStream("./src/test/resources/Data/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
	}
	
	public String writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo,String Date)  throws Throwable
	{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	Row ro=sh.getRow(RowNo);
    Cell cell = ro.createCell(ColumnNo);
    cell.setCellValue(Date);
    FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
     wb.write(fos);	
     return Date;
}
	
	/**This is used to get last row count
	 * @author kavya
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getLastRowNum(String sheetName) throws Throwable{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);	
		int count =sh.getLastRowNum();
		return count;
	}

	
	public Map<String, String> getList(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);	
		int count =sh.getLastRowNum();
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0; i<=count; i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key,value);
		if(key.equals("docemail"))
		{
		value=value+"_"+getRanDomNumber();
		}
	
  
		
	}
		return map;
	}

	private String getRanDomNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[][] readMultileData(String sheetName)throws Throwable
{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(sheetName);	
	int lastRow =sh.getLastRowNum()+1;
	short lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastRow][lastCell];
	for(int i=0; i<lastRow; i++)
	{
	for(int j=0; j<lastCell; j++)
	obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	}
	return obj;
}



}

