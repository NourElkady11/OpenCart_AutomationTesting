package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseTest;

public class ExtentReportManger implements ITestListener {
	
	
	 public ExtentSparkReporter sparkReporter; //UI of the Report
	 public ExtentReports extent; //Populate coman info on the report 
	 public ExtentTest test; //creating test case entries and update their status 
	 
	 String repName;
	 
	  public void onStart(ITestContext testContext) {

		  	String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		  	repName = "Test-Report_" + timeStamp + ".html";
		  

		  	sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
	        sparkReporter.config().setDocumentTitle("Automation Report");
	        sparkReporter.config().setReportName("E-Commerce Testing");
	        sparkReporter.config().setTheme(Theme.DARK);
	        
	        ///////////////////////////////
	        
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        
	        extent.setSystemInfo("Application Name", "OpenCart");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Tester Name", "Nour Elkady");
	
	        
	        
	        String os = testContext.getCurrentXmlTest().getParameter("os");
	        extent.setSystemInfo("Operating System", os);

	        String browser = testContext.getCurrentXmlTest().getParameter("browser");
	        extent.setSystemInfo("Browser", browser);

	        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();

	        if (!includedGroups.isEmpty()) {
	            extent.setSystemInfo("Groups", includedGroups.toString());
	        }
	        ////////////////////////////////////
	    }
	  

	  public void onTestSuccess(ITestResult result) {

	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups()); //to Display Group name in the report 
	        
	        test.log(Status.PASS,"Test case: "+result.getName()+" Passed");
	    }
	  
	  
	  public void onTestFailure(ITestResult result) {

		  test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups()); //to Display Group name in the report 
	        test.log(Status.FAIL,"Test case: "+result.getName()+" Failed");
	        test.log(Status.FAIL,"Test case Failed because :" + result.getThrowable());
	        
	        
	        try {
	            String imgPath = new BaseTest().captureScreen(result.getName());
	            
	            test.addScreenCaptureFromPath("."+imgPath);
	            // THE . to render the image from its correct folder cause we need to get out from the current folder that contains the report Then enter the secound folder

	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        
	    }
	  
	  public void onTestSkipped(ITestResult result) {

		  test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups()); //to Display Group name in the report 
	        test.log(Status.SKIP,"Test case: "+result.getName()+" Skipped");
	        test.log(Status.SKIP,"Test case Skipped because : " + result.getThrowable());
	    }

	    public void onFinish(ITestContext context) {

	        extent.flush(); //Writes test information from the started reporters to their output view
	        
	        //Here to open the report directly automatically after the test finished
//	        String pathOfExtentReport = System.getProperty("user.dir")
//	                + "\\reports\\" + repName;
	        
	        String pathOfExtentReport =".\\reports\\" + repName;

	        File extentReport = new File(pathOfExtentReport);

	        try {
	            Desktop.getDesktop().open(extentReport);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	        
	        
	        //Sending Emails
	        
	        
//	        try {
//	            URL url = new URL(
//	                    "file:///" + System.getProperty("user.dir")
//	                    + "\\reports\\" + repName
//	            );
//
//	            // Create the email message
//	            ImageHtmlEmail email = new ImageHtmlEmail();
//
//	            email.setDataSourceResolver(new DataSourceUrlResolver(url));
//
//	            email.setHostName("smtp.googlemail.com");
//	            email.setSmtpPort(465);
//
//	            email.setAuthenticator(
//	                    new DefaultAuthenticator(
//	                            "pavanoltraining@gmail.com",
//	                            "password"
//	                    )
//	            );
//
//	            email.setSSLOnConnect(true);
//	            email.setFrom("Nourrtraining@gmail.com"); // Sender
//
//	            email.setSubject("Test Results");
//	            email.setMsg("Please find Attached Report....");
//
//	            email.addTo("Elkadyyy.busyqa@gmail.com"); // Receiver
//
//	            email.attach(
//	                    url,
//	                    "extent report",
//	                    "please check report..."
//	            );
//
//	            email.send(); // Send the email
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        
	          
	    }

}

