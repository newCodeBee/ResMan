package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageObjects.ObjectsAdvisor;
import pageObjects.ObjectsLogin;

public class Login extends BrowserInvocation {
	public Properties prop;
	
	public void login(WebDriver driver) throws IOException  {
		//driver = initializeDriver();
		prop = new Properties();
		FileInputStream inputstream = new FileInputStream(
				"C:\\Users\\Thinksysuser\\Desktop\\Personal\\Personal Workspace\\RegressionE2E\\src\\main\\java\\resources\\data.properties");
		prop.load(inputstream);
		String url = prop.getProperty("url");
		String uid = prop.getProperty("username");
		String pswd = prop.getProperty("password");
		
		//Fetching objects from objectRepo
		driver.get(url);
		
		ObjectsLogin ob = new ObjectsLogin(driver);
		ObjectsAdvisor obAdvisor = new ObjectsAdvisor(driver);
		
		
		
		ob.getUsername().sendKeys(uid);
		ob.getPassword().sendKeys(pswd);
		ob.getSignin().click();
		obAdvisor.getClose().click();
			
		
		}
	
		
	
}