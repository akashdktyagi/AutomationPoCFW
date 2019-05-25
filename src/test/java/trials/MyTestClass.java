package trials;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

@Listeners(ExtentITestListenerClassAdapter.class)
public class MyTestClass {
	
	@Test
	public void t_test1() {
		ExtentTestManager.getTest().fail("Step Failed");
		ExtentTestManager.getTest().log(Status.FAIL, "Step Passed");
		Assert.assertFalse(true);
	}
	
	@Test
	public void t_test2() {
		ExtentTestManager.getTest().pass("Step Passed");
		Assert.assertFalse(false);
	}
}
