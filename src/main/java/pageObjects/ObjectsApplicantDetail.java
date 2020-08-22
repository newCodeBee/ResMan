package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsApplicantDetail {
	
	public WebDriver driver;

	public ObjectsApplicantDetail(WebDriver driver) {
		this.driver = driver;
	}

	By approveLink = By.cssSelector("a[id='ApproveLink']");
	
	
	public List<WebElement> approveLink() {
		return driver.findElements(approveLink);
	}
}
