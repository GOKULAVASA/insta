package testCases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import testUtilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getWebApplicationUrl();
	public String userEmail=readconfig.getUserEmail();
	public String userPassword=readconfig.getUserPassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters ("browser")
	@BeforeClass
	public void setUp(String bwrs) {

		logger=LogManager.getLogger();
		
		if(bwrs.equals("chrome")) {
			driver=new ChromeDriver();
			logger.info("Chrome get launched ");
		}else if (bwrs.equals("firefox")) {
			driver=new FirefoxDriver();
			logger.info("firfox get launched ");
		} else if(bwrs.equals("msedge")) {
			driver=new EdgeDriver();
			logger.info("MsEdge get launched ");
		}
		// Set implicit wait after initializing the driver
	    if (driver != null) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(readconfig.implicitDurationcount()));
	        driver.get(baseUrl);
	    } else {
	        logger.error("WebDriver initialization failed. Check the browser parameter.");
	    }
	}




	@AfterClass
	public void teardown() {
		driver.quit();
		logger.info("quitting browser");
	}

	     public static void CaptureScreenShot(WebDriver driver,String tname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File SOURCE=ts.getScreenshotAs(OutputType.FILE);
			File TARGET =new File("./screenshots"+ tname  + ".png");
			FileUtils.copyFile(SOURCE, TARGET);
			System.out.println("Screenshot taken");
				
		}


	    
	
}
