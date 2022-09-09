package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragPage {
	
	
	WebDriver driver;
	
	//URL
//	String url ="https://jqueryui.com/resources/demos/droppable/default.html";
	
	//locator
	By dragMeBox =By.id("draggable");
	
	By dropHereBox =By.id("droppable");
	
	//constructor
	
	public DragPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	public void navigate() {
//		
//		driver.navigate().to(url);
//	}
	
	public void dragbox()
	{
		new Actions(driver)
        .dragAndDrop(driver.findElement(dragMeBox),driver.findElement(dropHereBox))
        .perform();
		
	}
	
	public String getTextdropHerebox()
	{
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(dropHereBox))
				.getText();
	}

}
