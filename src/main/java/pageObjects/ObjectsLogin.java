package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsLogin {
	public WebDriver driver;
	
	public  ObjectsLogin(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	By username = By.cssSelector("#Username");
	By password = By.cssSelector("#Password"); 
	By signin   = By.id("SignInButton");
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
		
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement getSignin()
	{
		return driver.findElement(signin);
		
	}
	
	
}
