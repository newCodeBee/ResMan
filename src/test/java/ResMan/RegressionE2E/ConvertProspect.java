package ResMan.RegressionE2E;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ObjectProspectDetail;
import pageObjects.ObjectsApplicantDetail;
import pageObjects.ObjectsAvailUnitPopup;
import pageObjects.ObjectsBoardRoom;
import pageObjects.ObjectsNewApplicant;
import pageObjects.ObjectsProspectList;
import resources.BrowserInvocation;
import resources.Login;



public class ConvertProspect extends BrowserInvocation {
	public static Logger log = LogManager .getLogger(BrowserInvocation.class.getName());
     WebDriver driver;
	@BeforeTest
	public void initialogin() throws IOException {
		
		driver = initializeDriver();
		Login login = new Login();
		login.login(driver);
		log.info("Loggin in and closing the advisor");
		Actions ac = new Actions(driver);
		ObjectsBoardRoom ob = new ObjectsBoardRoom(driver);

		// Hovering the Account and clicking prospect
		ac.moveToElement(ob.account()).build().perform();
		ob.prospect().click();
		log.info("Prospect is clicked");
	}

	@Test
	public void conversionprospect() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ObjectsProspectList opl = new ObjectsProspectList(driver);
		ObjectProspectDetail opd = new ObjectProspectDetail(driver);
		ObjectsAvailUnitPopup oaup = new ObjectsAvailUnitPopup(driver);
		ObjectsNewApplicant ona = new ObjectsNewApplicant(driver);
		ObjectsApplicantDetail oad = new ObjectsApplicantDetail(driver); 
		
		opl.row().click();
		opd.convertapplicant().click();
		ona.checkavailableunit().click();

		// Checking if any unit is present
		Boolean isPresent = oaup.firstUnitavail().size() > 0;

		if (isPresent) {
			
			oaup.firstUnitavail().get(0).click();			
			ona.houseHoldStatus().sendKeys("H");
			ona.houseHoldStatus().sendKeys(Keys.ARROW_DOWN);
			ona.houseHoldStatus().sendKeys(Keys.ENTER);
			ona.leasingagent().sendKeys("b");
			ona.leasingagent().sendKeys(Keys.ARROW_DOWN);
			ona.leasingagent().sendKeys(Keys.ENTER);
			ona.savebtn().click();
			
			
			
			//Checking if converted
			
			Boolean isconvert= oad.approveLink().size() > 0;			
			Assert.assertTrue(isconvert);
			log.info("Prospect is converted to applicant");
			}
		

		else {
			System.out.print("Sorry create a unit, no unit available!!");
			Assert.assertEquals(false, true);
			driver.close();
		}

	}
	
	 @AfterTest
	public void tearDown()
	{
		driver.close();
	} 

}
