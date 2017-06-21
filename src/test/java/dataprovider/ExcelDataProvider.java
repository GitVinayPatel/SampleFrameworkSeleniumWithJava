package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
		File src=new File("./testdata/Wagewatcher_test_data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
		
	}

	
	public String getdata(String sheetname,int row,int column)
	{
		
		String data =wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		return data;
		
	}

	public String getdata(int sheetnum ,int row,int column)
	{
		
		String data =wb.getSheetAt(sheetnum).getRow(row).getCell(column).getStringCellValue();
		
		return data;
		
	}
	
	public int rowcount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	
}
