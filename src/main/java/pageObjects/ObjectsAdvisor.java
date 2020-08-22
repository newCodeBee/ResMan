package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsAdvisor {
public WebDriver driver;
	
	public  ObjectsAdvisor(WebDriver driver)
	{
		this.driver = driver;
	}

	
	//To close Boardroom 
	By closeButton = By.cssSelector("#CloseAdvisor");
	
	
	public WebElement getClose()
	{
		return driver.findElement(closeButton);
		
	}
	
	
}
