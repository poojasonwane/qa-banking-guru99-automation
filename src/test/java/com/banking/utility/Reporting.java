package com.banking.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		
		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		htmlReport =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Host Name", "local host");
		extent.setSystemInfo("Envioement", "QA");
		extent.setSystemInfo("User Name", "Pooja");
		htmlReport.config().setDocumentTitle("Internet Banking Test Project");
		htmlReport.config().setReportName("Functional Test Report");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReport.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotpath = System.getProperty("user.dir")+"/screenshot/"+tr.getName()+".jpg";
		File f = new File(screenshotpath);
		if(f.exists())
		{
			try {
				
				logger.fail("Screenshot is below :"+logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
		
	}
	
	
	public void onFinish(ITestContext testContext)
	{
		
		extent.flush();
	}
}
