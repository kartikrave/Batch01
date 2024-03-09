package fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel 
{

	FileInputStream path;
	Workbook wb;
	
	public Object[][] readMultipleData(String sheetName)
	{
		try
		{
			path=new FileInputStream("./src/test/resources/Book.xlsx");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			wb=WorkbookFactory.create(path);
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Sheet sheet=wb.getSheet(sheetName);
		int rowcount=sheet.getPhysicalNumberOfRows();
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] data=new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
		
		/*
		public void fetchSingleData()
		{
			try
			{
				path=new FileInputStream("./src/test/resources/Book.xlsx");
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				wb=WorkbookFactory.create(path);
			}
			catch(EncryptedDocumentException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Sheet sheet=wb.getSheet(sheetName);
		}
		*/
	}
	
}
