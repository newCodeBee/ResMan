package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsResidentDetails {
	public WebDriver driver;

	public ObjectsResidentDetails(WebDriver driver) {
		this.driver = driver;
	}

	By newTransactionLink = By.xpath("//*[@id='NewTransactionLink']");
	By accountingLink = By.xpath("//h4[contains(text(),'Accounting')]");
	By pagebody = By.cssSelector("#page");
	By generalInfoLink = By.xpath("//h4[contains(text(),'General Information')]");
	

	public WebElement newTransactionLink() {
		return driver.findElement(newTransactionLink);
	}
	public WebElement accountingLink() {
		return driver.findElement(accountingLink);
		
	}
	public WebElement pagebody() {
		return driver.findElement(pagebody);
		
	}
	public WebElement generalInfoLink() {
		return driver.findElement(generalInfoLink);
		
	}
}

