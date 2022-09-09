//Task #1
//Task#2

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleHomePage {
	
	WebDriver driver;
	
	//locators
//	String url ="https://www.google.com/ncr";
	
	By googleLogoImage =By.xpath("//img[@alt='Google']");
	
	By first_result=By.cssSelector("div.M8OgIe span.hgKElc");
	By search_box=By.name("q");
	//private By search_button=By.name("btnK");
	
	//constructor
	public GoogleHomePage(WebDriver driver){
	    this.driver = driver;
	}
	
//	public void navigate() {
//		
//		driver.navigate().to(url);
//	}
	//Task #1
	public String pagetitle() {
		
		return driver.getTitle();
		
	}

	//Task#2
	public boolean logodisplay() {
		 
		return driver.findElement(googleLogoImage).isDisplayed();
	}
	


	public void searchForQuery(String query) {
		
		driver.findElement(search_box).sendKeys(query + Keys.ENTER);
	
		
	}
	
	
	

}
