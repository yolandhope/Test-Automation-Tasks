package pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;

public class ResultedPage {

	WebDriver driver;

	// locators

	// constructor
	public ResultedPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPagelink() {

		return driver.getCurrentUrl();

	}

}
