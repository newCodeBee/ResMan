package ResMan.RegressionE2E;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ObjectResidentList;
import pageObjects.ObjectsBoardRoom;
import pageObjects.ObjectsNewTransactions;
import pageObjects.ObjectsResidentDetails;
import resources.BrowserInvocation;
import resources.Login;
import resources.ReusableFunctions;

public class NewTransactionResident extends BrowserInvocation {
	WebDriver driver;

	public static Logger log = LogManager .getLogger(BrowserInvocation.class.getName());
	@BeforeTest
	public void initialogin() throws IOException {
		driver = initializeDriver();
		Login login = new Login();
		login.login(driver);
		log.info("Loggin in and closing the advisor");
	}

	@Test
	public void residentNewtransaction() throws IOException, InterruptedException {
		int i = 0;
		List<WebElement> menu = new ArrayList<WebElement>();
		Actions ac = new Actions(driver);
		ObjectsBoardRoom ob = new ObjectsBoardRoom(driver);
		ObjectsResidentDetails ord = new ObjectsResidentDetails(driver);
		ObjectsNewTransactions ont = new ObjectsNewTransactions(driver);
		ObjectResidentList orl = new ObjectResidentList(driver);

		// Hovering the Account and clicking resident
		ac.moveToElement(ob.account()).build().perform();
		log.info("Hovering the Account and clicking resident");
		// To fetch data from Properties File
		Properties prop2 = new Properties();
		FileInputStream inputstream = new FileInputStream(
				"C:\\Users\\Thinksysuser\\Desktop\\Personal\\Personal Workspace\\RegressionE2E\\src\\main\\java\\resources\\transactiondetails.properties");
		prop2.load(inputstream);

		// fetching all ID of main menu and selecting resident
		menu = ob.mainmenu();
		int size = menu.size();
		System.out.println(size);

		for (i = 0; i < size - 1; i++) {
			String href = menu.get(i).getAttribute("href");
			if (href.contains("Residents")) {
				menu.get(i).click();
				break;
			}
		}

		// navigate to resident detail page
		orl.firstresident().click();		
		driver.manage().window().maximize();
		log.info("Navigate to Resident detail page");
		
		
		//Clicking trx link
		ord.generalInfoLink().click();
		Thread.sleep(2000);
		ord.newTransactionLink().click();

		// Checking the trx type
		if (prop2.getProperty("type").equalsIgnoreCase("charge")) {
			Thread.sleep(3000);
			// Entering data
			ont.trxtype().sendKeys(prop2.getProperty("type"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// ont.trxtype().sendKeys(Keys.ARROW_DOWN);
			ont.trxtype().sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);

			ont.category().sendKeys(prop2.getProperty("category"));
			// ont.category().sendKeys(Keys.ARROW_DOWN);
			ont.category().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			ont.description().sendKeys(prop2.getProperty("description"));
			Thread.sleep(3000);
			String am = prop2.getProperty("amount");
			
			ont.amount().clear();
			Thread.sleep(3000);
			ont.amount().sendKeys(am);

			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			ont.savebtn().click();
			
			Thread.sleep(2000);
			log.info("transaction is made now checking if success");
			String sucessmsg = driver.findElement(By.id("MessageCenter")).getText();
            String temp[] = sucessmsg.split(" ");
            ReusableFunctions rf = new ReusableFunctions();
            String actualmsg = rf.validation(temp);
			//to check if message have success    
           Assert.assertTrue(actualmsg.equalsIgnoreCase("successfully!"));
           log.info("Transaction is success");
       

	}

	
	
}
	 @AfterTest
		public void tearDown()
		{
			driver.close();
		} 
}
