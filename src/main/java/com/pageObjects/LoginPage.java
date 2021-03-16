package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By login_button = By.cssSelector("input[value='Log In']");
	By forgot_password = By.xpath("//div/a[contains(text(),'Forgot')]");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login_button);
	}
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgot_password).click();
		return new ForgotPassword(driver);
	}
	
}
