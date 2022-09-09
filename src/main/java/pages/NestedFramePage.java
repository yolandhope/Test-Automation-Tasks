package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage {

	WebDriver driver;

	// URL
//	String url = "https://the-internet.herokuapp.com/nested_frames";
	// locator
	String topFrame = "frame-top";

	String bottomFrame = "frame-bottom";

	String leftFrame = "frame-left";

	By body = By.tagName("body");
	// constructor

	public NestedFramePage(WebDriver driver) {
		this.driver = driver;
	}

//	public void navigate() {
//
//		driver.navigate().to(url);
//	}

	public String getTextBottomFrame() {

		driver.switchTo().frame(bottomFrame);

		String text = driver.findElement(body).getText();

		driver.switchTo().parentFrame();
		return text;
	}

	public String getTextLeftFrame() {
		driver.switchTo().frame(topFrame);

		driver.switchTo().frame(leftFrame);
		String text = driver.findElement(body).getText();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		return text;
	}



}
