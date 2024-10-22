
package dayy;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TC_Edit_Salesforce extends ProjectSpecification {
	
	@DataProvider(name="fetchData")
	public String[][] setValue() throws IOException{
		
		//call excel program -static keyword inside call
				//ClassName.methodName();
		
		String[][] readValue = ReadfromExcel2.readValue();
		return readValue;
		
	
	
	}
	
	
	@Test(dataProvider="fetchData")
	public  void EditSalesForce(String Name,String Description) throws InterruptedException {
		

		Thread.sleep(2000);
		//Click on the toggle menu button in the left corner 
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		
		//Click on "View All" and select "Sales" from the App Launcher 
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on the "Opportunity" tab
		WebElement dd=driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", dd);
     
		
		//Search for the Opportunity 'Salesforce Automation by Your Name'
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		search.sendKeys(Name , Keys.ENTER);
		Thread.sleep(3000);
		
		//Click on the Dropdown icon and select 'Edit'		
		WebElement clickdropdown = driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		driver.executeScript("arguments[0].click();", clickdropdown);
		 
		WebElement clickEdit = driver.findElement(By.xpath("//li[@class='uiMenuItem']//a"));
		driver.executeScript("arguments[0].click();", clickEdit);
	
	//Choose the close date as Tomorrow's date 
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='slds-day' and text()='10']")).click();
		
		
//Select 'Stage' as 'Perception Analysis'
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-value='Needs Analysis']")).click();	
		
	driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
	
	//Select 'Delivery/Installation Status' as 'In Progress'
	WebElement Deliverystatus = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value'])[4]"));
	driver.executeScript("arguments[0].click();", Deliverystatus);
	
	driver.findElement(By.xpath("//span[text()='In progress']")).click();
	
		 //Enter Description as 'SalesForce'
	driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(Description);
		
    //Click on 'Save' and verify the Stage as 'Perception Analysis'
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();	
		
	String per=driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
	//System.out.println(per);
	
if(per.contains("Perception Analysis"))
{ 	System.out.println("Stage Name Verified Successfully");
	}
else
	System.out.println("Stage Name Not Found");
		
}
}