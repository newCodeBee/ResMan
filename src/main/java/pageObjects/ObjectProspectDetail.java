package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectProspectDetail {
	public WebDriver driver;
	public  ObjectProspectDetail(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Table Rows Xpath
	
	By convertapplicant= By.cssSelector("[class='action-li initial no-roommates'] a");		
	
	
	
	
	
	public WebElement convertapplicant()
	{
		return driver.findElement(convertapplicant);
		
	}
	
}
