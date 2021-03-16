package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream
				("D:\\Eclipse workspace-20200724T163020Z-001\\WebUiAutomation\\src\\main\\java\\com\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String chrome_driver_path = prop.getProperty("chrome_driver_path");
		String firefox_driver_path = prop.getProperty("firefox_driver_path");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("driver.chrome.driver", chrome_driver_path);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("driver.gecko.driver", firefox_driver_path);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("Incorrect browser please check");
		}
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot scrshot = (TakesScreenshot)driver;
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;
	}

}
