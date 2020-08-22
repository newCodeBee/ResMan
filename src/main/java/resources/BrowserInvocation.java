package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class BrowserInvocation {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream inputstream = new FileInputStream(
				"C:\\Users\\Thinksysuser\\Desktop\\Personal\\Personal Workspace\\RegressionE2E\\src\\main\\java\\resources\\data.properties");
		prop.load(inputstream);
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Thinksysuser\\Desktop\\Personal\\All downloada\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		// the path mentioned is incorrect for now
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Thinksysuser\\Desktop\\Personal\\All downloada\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		// All test cases will have the wait of mentioned time below
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver; }
	
	
	//Taking SS 
	
	public void getScreenshotPath(String testcasename, WebDriver driver) throws IOException
	 {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testcasename + ".png";
		 FileUtils.copyFile(source,new File(destinationFile));
	 }
	
	}
	
	

