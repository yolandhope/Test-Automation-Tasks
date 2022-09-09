package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HerokuaPage {
	WebDriver driver;
//	String url ="https://the-internet.herokuapp.com/checkboxes";
	 By checkboxes = By.xpath("//form//input");
	
	
	public HerokuaPage(WebDriver driver){
        this.driver = driver;
    }
	
//public void navigate() {
//		
//		driver.navigate().to(url);
//	}
	
	//Task6
	/**
	* @param index starts at 1
	*/
	public void checkbox_check(int index){
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkboxes))
		.get(index - 1).click();
		
//		driver.findElements(checkboxes).get(index - 1).click();
		
	}
	public boolean checkbox_is_checked(int index){
		
		return new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkboxes))
		.get(index - 1).isSelected();
		
//		return driver.findElements(checkboxes).get(index - 1).isSelected();
		
	}

}
