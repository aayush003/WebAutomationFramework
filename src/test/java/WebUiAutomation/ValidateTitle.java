package WebUiAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.LandingPage;
import com.resources.Base;

public class ValidateTitle extends Base{
	
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		
		driver = initializeDriver();
		Log.info("Driver is initialized");
		driver.get("http://qaclickacademy.com");
		Log.info("Navigated to home page");
	}
	@Test
	public void ShowTitle() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals( l.getTitle().getText(), "FEATURED COURSES123" );
		Log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
