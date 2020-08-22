package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsNewTransactions {
	
		public WebDriver driver;

		public ObjectsNewTransactions(WebDriver driver) {
			this.driver = driver;
		}
		
		

		By trxtype =  By.cssSelector("#TransactionType");
		By category =  By.cssSelector("#LedgerItemType");
		By description =  By.cssSelector("#Description");
		By amount =  By.cssSelector("#Amount");
		By savebtn =  By.cssSelector("#Save");
		
		public WebElement trxtype() {
			return driver.findElement(trxtype);
		}
		
		public WebElement category() {
			return driver.findElement(category);
		}
		
		public WebElement description() {
			return driver.findElement(description);
		}
		
		public WebElement amount() {
			return driver.findElement(amount);
		}
		public WebElement savebtn() {
			return driver.findElement(savebtn);
		}
		
}
