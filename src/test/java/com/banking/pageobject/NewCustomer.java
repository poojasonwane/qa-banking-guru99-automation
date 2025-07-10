package com.banking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.utility.readData_configfile;

public class NewCustomer 
{
	WebDriver rdriver;
	
	public NewCustomer(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement click_newcustomer;
	
	public void newCustomer()
	{
		//Gtpl Bank New Customer Entry Page
		click_newcustomer.click();
	}
	
	@CacheLookup
	@FindBy(name="name")
	WebElement Custname;
	
	@CacheLookup
	@FindBy(xpath="//input[@name=\"name\"]/following::input[2]")
	WebElement choose_Gender;
	
	readData_configfile read = new readData_configfile();
	
	public void setCustname()
	{
		Custname.click();
		Custname.sendKeys(read.custname());
	}
	
	public void selectgender()
	{
		choose_Gender.click();
	}
	
	@CacheLookup
	@FindBy(name="dob")
	WebElement Datepicker_icon;
	
	public void select_date()
	{
		Datepicker_icon.click();
		Datepicker_icon.sendKeys(read.dob());
	}

	@CacheLookup
	@FindBy(name="addr")
	WebElement Address;
	
	public void set_Address()
	{
		Address.click();
		Address.sendKeys(read.address());
	}
	
	@CacheLookup
	@FindBy(name="city")
	WebElement city_ele;
	
	public void set_cityname()
	{
		city_ele.click();
		city_ele.sendKeys(read.city());
	}
	
	@CacheLookup
	@FindBy(name="state")
	WebElement state_ele;
	
	public void set_statename()
	{
		state_ele.click();
		state_ele.sendKeys(read.state());
	}
	
	@CacheLookup
	@FindBy(name="pinno")
	WebElement pin_no;
	
	public void set_pincode()
	{
		pin_no.click();
		pin_no.sendKeys(read.pin());
	}
	
	@CacheLookup
	@FindBy(name="telephoneno")
	WebElement telephone_no;
	
	public void telephone()
	{
		telephone_no.click();
		telephone_no.sendKeys(read.mobileno());
	}
	
	@CacheLookup
	@FindBy(name="emailid")
	WebElement email;
	
	public void set_email()
	{
		email.click();
		email.sendKeys(read.emailid());
	}
	
	
}
