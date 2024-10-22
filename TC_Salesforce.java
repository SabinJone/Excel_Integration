package dayy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_Salesforce extends ProjectSpecification{

	@DataProvider(name="fetchData")
	public String[][] setValue() throws IOException{
		
		//call excel program -static keyword inside call
				//ClassName.methodName();
		
		String[][] readValue = ReadfromExcel.readValue2();
		return readValue;
		
	}
	
	
	
@Test(dataProvider="fetchData")
		public void Salesforce(String name,String amount) {
			
		
			//6.Click on the toggle menu button in the left corner 
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//7.Click on "View All" and select "Sales" from the App Launcher 
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click(); 
			
	WebElement az=driver.findElement(By.xpath("//p[text()='Sales']"));
	driver.executeScript("arguments[0].click();", az);
			
			//8.Click on the "Opportunity" tab. 
			WebElement dd=driver.findElement(By.xpath("//span[text()='Opportunities']"));
			driver.executeScript("arguments[0].click();", dd);
			
			//9.Click on the "New" button. 
			driver.findElement(By.xpath("//div[@title='New']")).click();
			
			//10.Enter the Opportunity name as 'Salesforce Automation by Your Name
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
			
			//11.Enter Amount as 75,000 
			driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
			
			//Thread.sleep(2000);
			
			//12.Choose the close date as Today
			driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
			driver.findElement(By.xpath("//button[text()='Today']")).click();	
			
			//13.Select 'Stage' as 'Need Analysis'
			driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
			
			driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();	
			
			//14.Click on the 'Save' button and verify the Opportunity Name
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();	
			
	 String verify=driver.findElement(By.partialLinkText("Sabin Jone")).getText();
			if(verify.contains("Sabin Jone"))
			{
				System.out.println("Name verified successfully");
			}
			else
			{
				System.out.println("Name Not Found");
			}			

			
					}

}
