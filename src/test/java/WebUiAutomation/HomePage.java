package WebUiAutomation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.ForgotPassword;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();

	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get("http://qaclickacademy.com");
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();

		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("abcd@xyz.com");
		fp.sendMeInstructions().click();

	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];

		data[0][0] = "nonrestricted@xyz.com";
		data[0][1] = "nonrestrictedpass";

		data[1][0] = "restricted@xyz.com";
		data[1][1] = "restrictedpass";

		return data;
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
