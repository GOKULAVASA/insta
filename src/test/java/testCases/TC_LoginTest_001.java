package testCases;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass{
	@Test
public void loginTest() throws Exception {
	
	logger.info("url is launched");
	Loginpage lp=new Loginpage(driver);
	lp.enterUserEmail(userEmail);
	logger.info(" entered user email");
	lp.enterPassword(userPassword);
	logger.info(" entered user password");
	lp.clickLoginBtn();
	logger.info(" login button clicked ");
	lp.clickProfileIcon();
	logger.info("profile icon clicked ");
	Thread.sleep(3000);
	System.out.println(driver.getTitle());
	
	if(driver.getTitle().equals("java (@javamtf) • nstagram photos and videos"))
	{
		Assert.assertTrue(true);
		logger.info(" user verified");
	}else 
	{
		CaptureScreenShot( driver,"login test") ;
		Assert.assertTrue(false);
	
	}
	}
}

