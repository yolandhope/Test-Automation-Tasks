package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {

	WebDriver driver;

	// locators
	By first_result=By.xpath("//div[@class='tF2Cxc']//h3[@class='LC20lb MBeuO DKV0Md']");
	By fourth_result=By.xpath("//div[@class='kvH3mc BToiNc UK95Uc']//h3[@class='LC20lb MBeuO DKV0Md']");
	By second_result=By.xpath("//div[@class='kvH3mc BToiNc UK95Uc']//h3[@class='LC20lb MBeuO DKV0Md']");
	// constructor
	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//get first result by index
	
	/**
	* @param index starts at 1
	*/
	public String get_first_result(int index) {
		
		
		return new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(first_result)).get(index-1)
		.getText();				
		
		

	}
	
	public String get_fourth_result(int index) {
		
		
		return new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fourth_result)).get(index-1)
		.getText();				
		
		}
	
	public void clickOnSecondLink(int index){
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(second_result))
		.get(index-1).click();
	}
	

}
