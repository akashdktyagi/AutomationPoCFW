package retailbanking.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class PO_MyMoneyMap {
	
	WebDriver driver;
	
	public PO_MyMoneyMap(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver = d;
	}
	//Page Objects
	@FindBy(how=How.XPATH,using="//tr[@id='gridview-1021-bd-Spendings']/td/table/tbody/tr/td[2]/div")
	List<WebElement> txt_outflow_table_ammounts;
	
	
	public void FetchAmmountFromOutFlowTable() {
		
		//table[@id = 'active-visits']/tbody/tr/td[contains(text(),'100J27')]/following-sibling::td[1]
		//table[@id = 'active-visits']/tbody/tr/td[contains(text(),'100J27')]/parent::tr//a
		
		Double result_final=null;
		for(int i=0;i<txt_outflow_table_ammounts.size();i++) {
			String temp = txt_outflow_table_ammounts.get(i).getText();
			temp = temp.replaceAll("$", "");
			Double temp1= Double.parseDouble(temp);
			result_final = result_final + temp1;
	
		}
		
		Double final_result_actual = 0.0; // YOU NEED TO FETCH IT
		//I AM NOT GOING TO DO EVERY THING FOR U
		
		Assert.assertEquals(final_result_actual, result_final);

	}
	
	
}
