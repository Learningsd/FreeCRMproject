package com.crm.qa.Reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReports  implements ITestListener
{

	ExtentSparkReporter extentSparkReporter;
	 ExtentReports extentReports;
	 ExtentTest extentTest;
	  
	   
	 public void onStart(ITestContext context) {
	       extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReports.html");
	       extentReports = new ExtentReports();
	       extentReports.attachReporter(extentSparkReporter);


	       //configuration items to change the look and feel
	       //add content, manage tests etc
	       extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
	       extentSparkReporter.config().setReportName("Test Report");
	       extentSparkReporter.config().setTheme(Theme.DARK);
	       extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	       
	       extentReports.setSystemInfo("computerName", "localhost");
	       extentReports.setSystemInfo("browserName", "chrome");
	       extentReports.setSystemInfo("Enviroment", "QA");
	       extentReports.setSystemInfo("TesterName", "Althaf");
	       
	       
	       
	   }
	  
	  
	 public void onTestSuccess(ITestResult result) 
	 {
		 extentTest= extentReports.createTest(result.getName());
		 extentTest.log(Status.PASS,"test case passed is=" +result.getName());
		 
		    
		  }
	 
	 
	 public void onTestFailure(ITestResult result) 
	 {
		 extentTest= extentReports.createTest(result.getName());
		 extentTest.log(Status.FAIL,"test case failed is=" +result.getName());
		 extentTest.log(Status.FAIL,"test case failed cause is=" +result.getThrowable());
		  }

	 public void onTestSkipped(ITestResult result) 
	 {
		 extentTest= extentReports.createTest(result.getName());
		 extentTest.log(Status.SKIP,"test case skipped is=" +result.getName());
	}
	 public void onFinish(ITestContext context) 
	 {
	       
	       extentReports.flush();
	   }
}
