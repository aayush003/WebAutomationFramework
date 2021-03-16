package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	By email = By.cssSelector("input[id='user_email']");
	By send_me_instruction = By.cssSelector("[type='submit']");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public void forgotPassword()
	{
		this.driver = driver;
	}
	public WebElement sendMeInstructions()
	{
		return driver.findElement(send_me_instruction);
	}
	
}
