package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By sign_in = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//div/h2[contains(text(),'Featured')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(sign_in).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
}
