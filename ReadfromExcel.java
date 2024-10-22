package dayy;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfromExcel {

	//public static String[][] readValue() throws IOException 
	public static String[][] readValue2() throws IOException{
		
		XSSFWorkbook wbook = new XSSFWorkbook("./data/Salesforce.xlsx");
			XSSFSheet sheet = wbook.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();
			int cellcount = sheet.getRow(1).getLastCellNum();
		//System.out.println(rowcount);
			//System.out.println(cellcount);
			
			String[][] data = new String[rowcount][cellcount];
			for (int i = 1; i <=rowcount; i++) {
				for (int j = 0; j <cellcount; j++) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					//System.out.println(value);
				
					data[i-1][j]=value;
				
					
				}
				
			}
			 wbook.close();
			return data;

		}

	}
