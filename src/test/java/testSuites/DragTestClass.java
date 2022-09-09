package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DragPage;
import utils.WindowManger;



public class DragTestClass {
	
	
	WebDriver driver;
	DragPage dragpage;
	WindowManger windowManger;
  @Test
  public void checkBoxIsDropped() {
	  
	  dragpage.dragbox();
	  
	  var droppedBoxText =dragpage.getTextdropHerebox();
	  
	  Assert.assertEquals(droppedBoxText, "Dropped!", "Alert box dropping Failed");
  }
  
  
  @BeforeMethod
	public void before_test_set() {

	  windowManger.navigateto("https://jqueryui.com/resources/demos/droppable/default.html");

	}
	
	
	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
//			WebDriverManager.firefoxdriver().setup();

		driver = new ChromeDriver();
		
//			driver = new FirefoxDriver();
		windowManger=new WindowManger(driver);

		dragpage = new DragPage(driver);
		
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}
}
