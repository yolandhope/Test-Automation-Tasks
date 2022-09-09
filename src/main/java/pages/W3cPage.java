package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3cPage {
	
	WebDriver driver;
	//url
//	String url ="https://www.w3schools.com/html/html_tables.asp";
	//locator
	 By country = By.xpath("//table[@id='customers']//td[3]");
	 
	 
	 
	 public W3cPage(WebDriver driver){
	        this.driver = driver;
	    }
	 
	 
//	 public void navigate() {
//			
//			driver.navigate().to(url);
//		}
	 
	 public String getCountryCompany(int index) {
			
			
			return new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.presenceOfAllElementsLocatedBy(country)).get(index-1)
			.getText();				
			
			

		}

}
