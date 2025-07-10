package com.banking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver rdriver;
	
	public LoginPage(WebDriver ldriver)
	{
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//Find xpath of username
	
	@CacheLookup
	@FindBy(name="uid")
	WebElement txtUsername;
	
	//Find xpath of password
	@CacheLookup
	@FindBy(name="password")
	WebElement txtPassword;
	
	//Find xpath of button
	@CacheLookup
	@FindBy(name="btnLogin")
	WebElement btnlogin;
	
	//to use for set username
	public void setUsername(String name)
	{
		txtUsername.sendKeys(name);
	}
	
	//to use for setpassword
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	//click on th login button
	public void clickButton()
	{
		btnlogin.click();
	}

}
