package healthcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_Login {
	
	WebDriver driver;
	
	public PO_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	//Page Objects
	@FindBy(how = How.ID,using = "username")
	WebElement txtb_user_name;
	
	public void AkashMethod() {
		//Body added as per commnets from sarang
		
	}
	
	
	
	
	
}
