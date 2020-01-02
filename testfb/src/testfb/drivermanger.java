package testfb;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import junit.framework.Assert;

public class drivermanger extends keywords {

	static keywords key;
	static ArrayList data;
	static FileInputStream f;
	static XSSFWorkbook b;
	static XSSFSheet s;

	@Test
	public void test() throws Exception{
		
	
		keywords key = new keywords();
		ArrayList data = new ArrayList();
		FileInputStream f = new FileInputStream("D://fbtestcase.xlsx");
		XSSFWorkbook b = new XSSFWorkbook(f);
		XSSFSheet s = b.getSheet("Test");
		Iterator row = s.iterator();

		while (row.hasNext()) {
			Row rowitr = (Row) row.next();
			Iterator cell = rowitr.cellIterator();

			while (cell.hasNext()) {
				Cell cellitr = (Cell) cell.next();

				if (cellitr.getCellTypeEnum() == CellType.STRING) {
					data.add(cellitr.getStringCellValue());
				}
				if (cellitr.getCellTypeEnum() == CellType.NUMERIC) {
					data.add(cellitr.getNumericCellValue());
				}
				if (cellitr.getCellTypeEnum() == CellType.BOOLEAN) {
					data.add(cellitr.getBooleanCellValue());
				}
			}
		}

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals("openbrowser")) {
				String keywords = (String) data.get(i);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords);
				if (runmode.equals("yes")) {
					key.openbrowser();
				}
			}

			if (data.get(i).equals("navigate")) {
				String keywords = (String) data.get(i);
				String testdata = (String) data.get(i + 1);
				String objectname = (String) data.get(i + 2);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords + " " + testdata + " " + runmode);
				if (runmode.equals("yes")) {
					key.navigate(testdata);
				}
			}

			

			if (data.get(i).equals("input")) {
				String keywords = (String) data.get(i);
				String testdata = (String) data.get(i + 1);
				String objectname = (String) data.get(i + 2);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords + " " + testdata + " " + runmode);
				if (runmode.equals("yes")) {
					key.input(objectname, testdata);

				}
			}
			
			if (data.get(i).equals("selectList")) {
				String keywords = (String) data.get(i);
				String testdata = (String) data.get(i + 1);
				String objectname = (String) data.get(i + 2);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords + " " + testdata + " " + runmode);
				if (runmode.equals("yes")) {
					key.selectList(objectname, testdata);

				}
			}

			
			if (data.get(i).equals("verifyTitle")) {
				String keywords = (String) data.get(i);
				String testdata = (String) data.get(i + 1);
				String objectname = (String) data.get(i + 2);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords + " " + testdata + " " + objectname + " " + runmode);

				if (runmode.equals("yes")) {
					String actualValue = key.verifypageTitle();
					Assert.assertEquals(testdata, actualValue);

				}
			}

			if (data.get(i).equals("click")) {
				String keywords = (String) data.get(i);
				String testdata = (String) data.get(i + 1);
				String objectname = (String) data.get(i + 2);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords + " " + testdata + " " + runmode);
				if (runmode.equals("yes")) {
					key.click(objectname);

				}
			}
			
			if (data.get(i).equals("quit")) {
				String keywords = (String) data.get(i);
				String testdata = (String) data.get(i + 1);
				String objectname = (String) data.get(i + 2);
				String runmode = (String) data.get(i + 3);
				System.out.println(keywords + " " + testdata + " " + runmode);
				if (runmode.equals("yes")) {
					key.quit(objectname);

				}
			}


		}

	}
}
