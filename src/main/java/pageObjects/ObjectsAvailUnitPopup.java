package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsAvailUnitPopup {
	public WebDriver driver;

	public ObjectsAvailUnitPopup(WebDriver driver) {
		this.driver = driver;
	}

	By AvailableUnitsVacant = By.cssSelector("#AvailableUnitsVacant");
	By AvailableUnitsHoldingList = By.cssSelector("#AvailableUnitsHoldingList");
	By firstUnitavail = By.xpath("//*[@class='unit-row']/td[1]");

	public List<WebElement> AvailableUnitsVacant() {
		return driver.findElements(AvailableUnitsVacant);
	}

	public List<WebElement> AvailableUnitsHoldingList() {
		return driver.findElements(AvailableUnitsVacant);
	}

	public List<WebElement> firstUnitavail() {
		return driver.findElements(firstUnitavail);
	}

}
