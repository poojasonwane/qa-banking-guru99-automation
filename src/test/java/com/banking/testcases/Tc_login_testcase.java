package com.banking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobject.LoginPage;
import com.banking.pageobject.NewCustomer;

public class Tc_login_testcase extends BaseClass
{
	
	@Test(priority=1)
	public void loginTestCase()
	{
		driver.get(url);
		logger.info("url open");
		LoginPage login = new LoginPage(driver);
		
		login.setUsername(name);
		logger.info("Set Username and Password");
		
		login.setPassword(password);
		
		login.clickButton();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			Assert.assertFalse(false);
			logger.info("Test Case Failed");
		}
		
		logger.info("Open Home Page");
	}

	@Test(priority=2)
	public void newcustomertestcase()
	{
		NewCustomer newcust = new NewCustomer(driver);
		
		newcust.newCustomer();
		logger.info("Open add new customer page");
		
		
		if(driver.getTitle().equals("Gtpl Bank New Customer Entry Page"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			Assert.assertFalse(false);
			logger.info("Test Case Failed");
		}
		
		newcust.setCustname();
		newcust.selectgender();
		newcust.select_date();
		newcust.set_Address();
		newcust.set_cityname();
		newcust.set_statename();
		newcust.set_pincode();
		newcust.telephone();
		newcust.set_email();
		
		logger.info("Enter all Details sucessfully");
	}
}
