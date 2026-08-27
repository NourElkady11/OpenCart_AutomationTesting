package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public static WebDriver driver;
	public static WebDriverWait waitDriver;
	public Logger logger; //lof4j
	public Properties p;
	//We are using alwaysRun=true because when we specify groups and run from the XML file we are now depends on TEST NG execution 
	//Rather than java execution and inheritance 
	@BeforeClass(alwaysRun = true)
	@Parameters({"os","browser"})
	public void setUp(String os, String browser) throws IOException
	{
		
		FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		
        String runId = java.time.LocalDateTime.now()
                .format(
                    java.time.format.DateTimeFormatter
                        .ofPattern("yyyy_MM_dd_HH_mm_ss")
                );

        System.setProperty("runId", runId);
        
		logger=LogManager.getLogger(this.getClass());
		//This logger varible will get its configurations from the log4j.xml file to this varible
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
		    DesiredCapabilities capabilities = new DesiredCapabilities();

		    // os
		    if(os.equalsIgnoreCase("windows"))
		    {
		        capabilities.setPlatform(Platform.WIN11);
		    }
		    if(os.equalsIgnoreCase("linux"))
		    {
		        capabilities.setPlatform(Platform.LINUX);
		    }
		    else if(os.equalsIgnoreCase("mac"))
		    {
		        capabilities.setPlatform(Platform.MAC);
		    }
		    else
		    {
		        System.out.println("No matching os");
		        return;
		    }

		    // browser
		    switch(browser.toLowerCase())
		    {
		        case "chrome": capabilities.setBrowserName("chrome"); break;
		        case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
		        case "firefox": capabilities.setBrowserName("firefox"); break;
		        default: System.out.println("No matching browser"); return;
		    }

		    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}


		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		    switch(browser.toLowerCase())
		    {
		        case "chrome": driver = new ChromeDriver();  break;
		        case "edge":  driver = new EdgeDriver();  break;
		        case "firefox":   driver = new FirefoxDriver();  break;
		        default:  System.out.println("Invalid browser name..");  return;
		    }
		}
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		//better to have this methods
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));//Reading from Properties values
		driver.manage().window().maximize();
		waitDriver=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    String targetFilePath =".\\screenshots\\" + tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDowm() {
		driver.quit();
		
	}

}
