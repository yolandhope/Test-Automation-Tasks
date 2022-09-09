package testSuites;

import org.testng.Assert;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.HerokuaPage;
import utils.WindowManger;


public class HerokuaPageTest {

	WebDriver driver;
	HerokuaPage herokuoage;
	WindowManger windowManger;
	// Task 6

	@Test
	public void CheckCheckboxes() {

		herokuoage.checkbox_check(1);

		boolean checkbox1 = herokuoage.checkbox_is_checked(1);
		boolean checkbox2 = herokuoage.checkbox_is_checked(2);

		Assert.assertEquals(checkbox1, true, "Checkbox1 is not checked");

		Assert.assertEquals(checkbox2, true, "Checkbox2 is not checked");

	}

	@BeforeMethod
	public void before_test_set() {

		windowManger.navigateto("https://the-internet.herokuapp.com/checkboxes");

	}

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
//			WebDriverManager.firefoxdriver().setup();

		driver = new ChromeDriver();

//			driver = new FirefoxDriver();
		windowManger=new WindowManger(driver);

		herokuoage = new HerokuaPage(driver);

		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

}
