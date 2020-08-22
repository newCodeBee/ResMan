package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsProspect {
public WebDriver driver;
	
	public  ObjectsProspect(WebDriver driver)
	{
		this.driver = driver;
	}
    
	By newProspect = By.xpath("//a[@id='SMNewProspect']");
	By firstName = By.id("Person_FirstName");
	By LastName = By.id("Person_LastName") ;
	By Source = By.xpath("//input[@id='Prospect_PropertyProspectSourceIDInput']");
	By MovingFrom = By.id("Prospect_MovingFrom");	
	By ContactMethod = By.id("ProspectInteraction_ContactTypeInput");
	By Communication = By.id("ProspectInteraction_InteractionTypeInput");
	By Save = By.xpath("//span[contains(text(),'Save')]");
	
	
	
	public WebElement  prospect() {
		return driver.findElement(newProspect);
	}
	
	public WebElement  fname() {
		return driver.findElement(firstName);
	}
	
	public WebElement  lname() {
		return driver.findElement(LastName);
	}
	
	public WebElement  source() {
		return driver.findElement(Source);
	}
	
	public WebElement  MovingFrom() {
		return driver.findElement(MovingFrom);
	}
	
	public WebElement  ContactMeth() {
		return driver.findElement(ContactMethod);
	}
	
	public WebElement  Communication() {
		return driver.findElement(Communication);
	}
	
	public WebElement  SaveButton() {
		return driver.findElement(Save);
	}
	
}
