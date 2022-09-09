package utils;

import org.openqa.selenium.WebDriver;

public class WindowManger {
	
	
	WebDriver driver;
	
	public WindowManger(WebDriver driver) {
		this.driver = driver;
	}
	
	
public void navigateto(String url) {
		
		driver.navigate().to(url);
	}

}
