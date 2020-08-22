package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectResidentList {

	
	public WebDriver driver;

	public ObjectResidentList(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By firstresident = By.cssSelector("[class=resident]");
	
	public WebElement firstresident()
	{
		return driver.findElement(firstresident);
	}
	
	
}

