package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.NestedFramePage;
import utils.WindowManger;

public class NestedFrameTestClass {
	
	
	WebDriver driver;
	NestedFramePage nestedFramePage;
	WindowManger windowManger;
	
  @Test
  public void nestedFrameTextTeest() {
	  
	  Assert.assertEquals(nestedFramePage.getTextBottomFrame(), "BOTTOM", "Alert Bottom frame Text Incorrect");
	  
	  Assert.assertEquals(nestedFramePage.getTextLeftFrame(), "LEFT", "Alert Left frame Text Incorrect");

	  
  }
  
  
  @BeforeMethod
	public void before_test_set() {

	  windowManger.navigateto("https://the-internet.herokuapp.com/nested_frames");

	}
	
	
	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
//			WebDriverManager.firefoxdriver().setup();

		driver = new ChromeDriver();
		
//			driver = new FirefoxDriver();
		windowManger=new WindowManger(driver);

		nestedFramePage = new NestedFramePage(driver);
		
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}
}
