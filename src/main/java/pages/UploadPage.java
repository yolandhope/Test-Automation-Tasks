package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadPage {
	
	WebDriver driver;
	
	//URL
//	String url ="https://the-internet.herokuapp.com/upload";
	
	//locator
	By button =By.id("file-submit");
	
	By fileUpload =By.id("file-upload");
	
	By uploadedFile =By.id("uploaded-files");
	
	//constructor
	public UploadPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	public void navigate() {
//		
//		driver.navigate().to(url);
//	}
//	
	public void uploadfile(String pathToFile)
	{
		driver.findElement(fileUpload).sendKeys(pathToFile);
		
		driver.findElement(button).click();
	}
	
	public String getNameofUplaodeFIle() {
		
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(uploadedFile))
				.getText();
	}
	

}
