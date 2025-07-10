package com.banking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readData_configfile 
{
	Properties prop;
	public readData_configfile()
	{
		
		try
		{
			File src = new File("./Configuration/config.properties");
			
			FileInputStream  file = new FileInputStream(src);
			prop = new Properties();
			prop.load(file);	
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e.getMessage());
	
		}
	}
	
	public String getUrl()
	{
		String url=prop.getProperty("url");
		return url;
	}

	
	public String getUsername()
	{
		String name=prop.getProperty("name");
		return name;
	}

	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}

	public String custname()
	{
		String cname = prop.getProperty("cname");
		return cname;
	}
	
	public String dob()
	{
		String dob = prop.getProperty("dob");
		return dob;
	}
	
	public String address()
	{
		String address = prop.getProperty("addr");
		return address;	
	}
	
	public String city()
	{
		String cityname = prop.getProperty("city");
		return cityname;
	}
	public String state()
	{
		String statename = prop.getProperty("state");
		return statename;
	}
	public String pin()
	{
		String pin = prop.getProperty("pin_no");
		return pin;
	}
	public String mobileno()
	{
		String telephone = prop.getProperty("telephn");
		return telephone;
		
	}
	public String emailid()
	{
		String email = prop.getProperty("email");
		return email;
	}
}
