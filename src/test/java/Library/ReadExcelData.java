package Library;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ReadExcelData(String excelpath)
	{
		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
			
		}  catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetnumber,int row,int col)
	{
		sheet1=wb.getSheetAt(sheetnumber);
		String data=sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int getrowCount(int sheetnumber)
	{
		int row=wb.getSheetAt(sheetnumber).getLastRowNum();
		row=row+1;
		return row;
	}

}
