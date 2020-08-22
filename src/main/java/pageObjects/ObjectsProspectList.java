package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsProspectList {
public WebDriver driver;
	
	public  ObjectsProspectList(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Table Rows Xpath
	By rows = By.xpath("//div[@id='ProspectList']/table/tbody/tr[1]/td[1]");
	
	
	
	
	
	
	
	
	public  WebElement row()
	{
		return driver.findElement(rows);
		
	}
	
	
	
	
}

