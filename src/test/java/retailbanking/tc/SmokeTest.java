package retailbanking.tc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import retailbanking.po.PO_Common;
import retailbanking.po.PO_Login;
import retailbanking.po.PO_TransferFunds;
import core.utils.*;

@Listeners(ExtentITestListenerClassAdapter.class)
public class SmokeTest {
	
	@Parameters({"url","browser"})
	@Test
	public void t_01_check_login(String url,String browserType) {
		try {
			//String url = "http://zero.webappsecurity.com/login.html";
			WebDriver driver = Utils.InvokeBrowser(browserType, url);
			
			//Init Page Object
			PO_Login PO_Login = PageFactory.initElements(driver, PO_Login.class);
			PO_Login.KW_LoginInToApplication("username", "password");
			
			Utils.WriteLogs("pass","Test Case completed");
		}catch(Exception e) {
			Utils.WriteLogs("fail","Test failed");
			Assert.assertFalse(false);
		}

	}
	
	@Parameters({"url","browser"})
	@Test
	public void t_02_check_transfer_funds(String url,String browserType)  {
		WebDriver driver = Utils.InvokeBrowser(browserType, url);
		//Init Page Object
		PO_Login PO_Login = PageFactory.initElements(driver, PO_Login.class);
		PO_Login.KW_LoginInToApplication("username", "password");
		
		//Click on Transfer Funds
		PO_Common PO_Common = PageFactory.initElements(driver, PO_Common.class);
		PO_Common.ClickOnTransferFunds();
		
		//Transfer Funds
		PO_TransferFunds PO_TransferFunds = PageFactory.initElements(driver, PO_TransferFunds.class);
		String from = "1";
		String to = "2";
		String ammount = "10";
		String descp = "test";
		
		PO_TransferFunds.KW_FillTransferFundsPageAndSubmit(from, to, ammount, descp);
		Utils.WriteLogs("pass","Test Case completed");
		
	}
	
	//<parameter name="url_parabank" value="http://parabank.parasoft.com/parabank/index.htm" />/
	//@Parameters({"url_icici"})
	//@Test(groups="smoke",description="Smoke Test For Search funtionality",enabled=true)
}
