
//Task 1,2

package testSuites;

//import base.BaseTestGoogle;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHomePage;
//import pages.HerokuaPage;
import pages.ResultedPage;
import pages.SearchResults;

//import static org.testng.Assert.assertEquals;

//import pages.GoogleHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WindowManger;

public class TestGoogleClass {

	WebDriver driver;
	GoogleHomePage home;
	SearchResults search;
	ResultedPage page;
	
	WindowManger windowManger;

	// Task1

	@Test

	public void checkThatTitleNameisGoogle() {

		var title = home.pagetitle();

		Assert.assertEquals(title, "Google", "Alert Title is incorrect");

	}

	// Task 2
	@Test

	public void checkThatGoogleLogoisDisblayed() {

		boolean logo = home.logodisplay();
		Assert.assertTrue(logo, "Alert logo is not displayed");
	}

	// Task 3
	@Test

	public void checkThatFirstResult() {

		home.searchForQuery("Selenium WebDriver");
		var first_result_text = search.get_first_result(1);
		Assert.assertEquals(first_result_text, "Selenium - Web Browser Automation",
				"Alert first result text is not right");

	}

	// using firefox
	// Task 4
	@Test
	public void checkThatFourthResult() {
//		home.navigate();

		home.searchForQuery("TestNG");
		// index is not 4 but 3 as the first result is not in the same query on the web
		// page
		var fourth_result_text = search.get_fourth_result(3);

		Assert.assertEquals(fourth_result_text, "TestNG Tutorial", "Alert fourth result text is not right");

	}

	// Task 5
	@Test
	public void checkThatSecondPageLink() {
//		home.navigate();

		home.searchForQuery("Cucumber IO");

		search.clickOnSecondLink(1);

		var pagelink = page.getPagelink();

		Assert.assertEquals(pagelink, "https://www.linkedin.com", "Alert second page link is not right ");

	}

	@BeforeMethod()
	public void before_test_set() {

		windowManger.navigateto("https://www.google.com/ncr");

	}

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();;

		driver = new ChromeDriver();

//		driver = new FirefoxDriver();
		
		windowManger=new WindowManger(driver);

		home = new GoogleHomePage(driver);

		search = new SearchResults(driver);

		page = new ResultedPage(driver);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

}
