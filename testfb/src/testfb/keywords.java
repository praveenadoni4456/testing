package testfb;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class keywords {
	static FileInputStream fis;
	static Properties prop;
	static FirefoxDriver driver;
	static {
		try {
			fis = new FileInputStream(
					"C:\\Users\\prave\\eclipse-workspace\\testfb\\src\\testfb\\objectreprositry.properties");
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void openbrowser() throws Exception {

		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void input(String objectname, String testdata) throws Exception{
		
		driver.findElement(By.xpath(prop.getProperty(objectname))).sendKeys(testdata);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	

	public void navigate(String testdata) throws Exception{
		
		driver.get(testdata);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}



	public void click(String objectname) throws Exception{
		
		driver.findElement(By.xpath(prop.getProperty(objectname))).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	

	public String verifypageTitle() {
		String acutalValue = driver.getTitle();
		return acutalValue;
	}
	

	public void selectList(String objectname, String testdata) {
		Select select= new Select(driver.findElement(By.xpath(prop.getProperty(objectname))));
		select.selectByValue(testdata);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public void quit(String objectname) {
		driver.quit();
		
	}

}
