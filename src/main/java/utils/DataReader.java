package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	static int row;
	static int column;
	
	public static String[][] dataExcelReader(String sheetName) throws IOException {
		
		
		String basePath = System.getProperty("user.dir");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(basePath+"/src/test/resources/TestDatas.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		row = rowCount;
		int columnCount = sheet.getRow(0).getLastCellNum();
		column = columnCount;
		String[][] tesData = new String[rowCount][columnCount];
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		for(int i=1 ; i <= rowCount ; i++) {
			XSSFRow r = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell c = r.getCell(j);
				tesData[i-1][j] = cellData(c);
				System.out.println(c);
				
			}
		}
		return tesData;
	}
	
	public String getDataValue(String key) throws IOException {
		String data = null;
		String[][] testdata = new String[row][column];
		testdata = dataExcelReader("TestSheet");
			for(int j = 0 ; j< column ; j++) {
				if(testdata[0][j].equalsIgnoreCase(key)) {
					data = testdata[1][j];
					break;
				}
			}
			return data;
	}
	public static void main(String[] args) throws IOException {
		
		dataExcelReader("DummySheet");
	}
		
	public static String cellData(XSSFCell cell){
		String cellValue = null;
		if (cell.getCellType() == CellType.STRING) {
			cellValue = cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			cellValue = String.valueOf((int)cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			cellValue = String.valueOf(cell.getBooleanCellValue());
		} 
		return cellValue;
	}
}
