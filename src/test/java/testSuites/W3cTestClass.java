package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//import pages.HerokuaPage;
import pages.W3cPage;
import utils.WindowManger;

public class W3cTestClass {

	WebDriver driver;
	W3cPage w3cpage;
	WindowManger windowManger;

	@Test
	public void CheckCompanyCounrty() {

		var companyname = w3cpage.getCountryCompany(3);
		Assert.assertEquals(companyname, "Austria", "Alert Company name  is incorrect");
	}

	@BeforeMethod
	public void before_test_set() {

		windowManger.navigateto("https://www.w3schools.com/html/html_tables.asp");

	}

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
//			WebDriverManager.firefoxdriver().setup();

		driver = new ChromeDriver();

//			driver = new FirefoxDriver();
		windowManger=new WindowManger(driver);

		w3cpage = new W3cPage(driver);

		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}
}
