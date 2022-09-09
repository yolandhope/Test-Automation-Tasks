package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.UploadPage;
import utils.WindowManger;

public class UploadTestClass {

	WebDriver driver;
	UploadPage uploadpage;
	WindowManger windowManger;

	String pathToFile = "C:\\Users\\ZIKA_\\eclipse-workspace\\seleniumAutomationDemo\\src\\test\\resources\\Mohab Mostafa.png";

	@Test
	public void checkFileUploaded() {

		uploadpage.uploadfile(pathToFile);

		var uploadedFileName = uploadpage.getNameofUplaodeFIle();

		Assert.assertEquals(uploadedFileName, "Mohab Mostafa.png", "Alert upload file failed");

	}

	@BeforeMethod
	public void before_test_set() {

		windowManger.navigateto("https://the-internet.herokuapp.com/upload");

	}

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
//			WebDriverManager.firefoxdriver().setup();

		driver = new ChromeDriver();

//			driver = new FirefoxDriver();
		windowManger=new WindowManger(driver);

		uploadpage = new UploadPage(driver);

		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}
}
