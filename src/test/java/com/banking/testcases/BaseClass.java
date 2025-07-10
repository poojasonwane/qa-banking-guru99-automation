package com.banking.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.banking.utility.readData_configfile;


public class BaseClass 
{
	readData_configfile read = new readData_configfile();
	 public String url =read.getUrl();
	 public String name=read.getUsername();
	 public String password=read.getPassword();
	 
	 public static WebDriver driver;
	 
	 public static Logger logger; 
	// public Logger logger;
	 
	
	 @BeforeClass
	 public void setup()
	 {
		 ChromeOptions options = new ChromeOptions();
		 
		 driver = new ChromeDriver(options);
		 
		 driver.manage().window().maximize();
		 
		 logger = LogManager.getLogger(Tc_login_testcase.class);
		 
		// logger = Logger.getLogger("Banking_project");
		 //PropertyConfigurator.configure();
		  
	 }
	 
//	 @AfterClass
//	 public void tearDown()
//	 {
//		 driver.close();
//	 }
}
