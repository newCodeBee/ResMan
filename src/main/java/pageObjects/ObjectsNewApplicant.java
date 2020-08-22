package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsNewApplicant {
	public WebDriver driver;

	public ObjectsNewApplicant(WebDriver driver) {
		this.driver = driver;
	}
	
	

	By checkavailableunit = By.xpath("//a[@id='CheckAvailableUnitsLink']");
	By savebtn =  By.cssSelector("#Save");
	By houseHoldStatus = By.xpath("//input[@id='Person_HouseholdStatusIDInput']");
	By leasingagent = By.xpath("//input[@id='Lease_LeasingAgentPersonIDInput']");
	//input[@id='Lease_LeasingAgentPersonIDInput']

	public WebElement checkavailableunit() {
		return driver.findElement(checkavailableunit);
	}
	public WebElement savebtn() {
		return driver.findElement(savebtn);
	}
	
	public WebElement houseHoldStatus() {
		return driver.findElement(houseHoldStatus);
	}
	
	public WebElement leasingagent() {
		return driver.findElement(leasingagent);
	}
	
}
