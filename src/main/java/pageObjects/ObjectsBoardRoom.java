package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsBoardRoom {

	public WebDriver driver;

	public ObjectsBoardRoom(WebDriver driver) {
		this.driver = driver;
	}

	// Account tab ID

	By acc = By.xpath("//*[@id='MainMenu']/div/ul/li[3]");
	By prospectElement = By.xpath("//a[contains(text(),'Prospects')]");
	By mainmenuID = By.xpath("//*[@menuname='Accounts']/ul //a[@class='ajax']");
	
	public WebElement account() {
		return driver.findElement(acc);

	}
	
	//Prospect in Account Dropdown
	
	
	public WebElement prospect() {
		return driver.findElement(prospectElement);

	}
	
	//Resident in Account Dropdown
	
	public List<WebElement> mainmenu()
	{
		return driver.findElements(mainmenuID);
	}
	
	
	

}
