package ResMan.RegressionE2E;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ObjectsBoardRoom;
import pageObjects.ObjectsProspect;
import resources.BrowserInvocation;
import resources.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class CreateProspect extends BrowserInvocation {
	WebDriver driver;

	public static Logger log = LogManager .getLogger(BrowserInvocation.class.getName());

	@BeforeTest
	public void initialogin () throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialised");
		Login login = new Login();
		login.login(driver);
		log.info("Loggin in and closing the advisor");
	} 
	

	@Test
	public void newprospect() throws IOException, InterruptedException {
		int i =0;
		List <WebElement> menu = new ArrayList<WebElement>();

		Actions ac = new Actions(driver);
		ObjectsBoardRoom ob = new ObjectsBoardRoom(driver);
		ObjectsProspect op = new ObjectsProspect(driver);

		// Hovering the Account and clicking prospect
		ac.moveToElement(ob.account()).build().perform();
	    
		//Selecting all menu and clicking prospect
		menu = ob.mainmenu();
		for(i=0;i<menu.size()-1;i++)
		{
			String href = menu.get(i).getAttribute("href");
			if(href.contains("Prospects"))
			{
				menu.get(i).click();
				break;
			}}
		

		// Clicking New Prospect Link
		op.prospect().click();

		// Filling All text fields
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  	
		op.fname().sendKeys("auto" + randomInt);
		op.lname().sendKeys("lastname");
		op.MovingFrom().sendKeys("London");
		op.source().sendKeys("Test");
		
		// Selecting Source
		op.source().clear();
		op.source().sendKeys("Email");
		op.source().sendKeys(Keys.ARROW_DOWN);
		op.source().sendKeys(Keys.ENTER);
		
        //Contact Method
		op.ContactMeth().clear();
		op.ContactMeth().sendKeys("Email");
		Thread.sleep(1000);
		op.ContactMeth().sendKeys(Keys.ARROW_DOWN);
		op.ContactMeth().sendKeys(Keys.ENTER);
		
		op.SaveButton().click();
		log.info("Save button of prospect is successfully clicked");
		Assert.assertTrue(false);
		//To implement if correct detail page is shown

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("closing browser");
	}

}