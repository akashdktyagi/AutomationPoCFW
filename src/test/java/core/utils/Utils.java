package core.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.service.ExtentTestManager;

public class Utils {

	public static WebDriver InvokeBrowser(String browserType, String url) {
		try {
			WebDriver driver=null;
			//Browser Configured and Invoked
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","E:\\\\_AkashStuff\\\\Automation\\\\dependencies\\\\chromedriver\\\\chromedriver.exe");
				driver=new ChromeDriver();
			}else if (browserType.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver","E:\\\\_AkashStuff\\\\Automation\\\\dependencies\\\\chromedriver\\\\chromedriver.exe");
				//driver=new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
			driver.get(url);
			Utils.WriteLogs("pass","Browser Chrome Invoked with URL as : " + url);
			return driver;
		}catch(Exception e) {
			Utils.WriteLogs("fail","Unable to Invoke Browser. Type:" + browserType + " URL:" + url);
			return null;
		}



	}

	public static void WriteLogs(String logType,String msg) {
		Reporter.log(logType + "-" + msg + "<br>", true);

		switch(logType.toLowerCase()) {
		case "pass":
			ExtentTestManager.getTest().pass(msg);
			Assert.assertTrue(true);
			break;
		case "fail":
			ExtentTestManager.getTest().fail(msg);
			Assert.assertTrue(false);
			break;
		case "info":
			ExtentTestManager.getTest().info(msg);
			break;
		case "fatal":
			ExtentTestManager.getTest().fatal(msg);
			break;
		}

	}
}
