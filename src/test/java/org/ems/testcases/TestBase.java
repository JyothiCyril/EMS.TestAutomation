package org.ems.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.ems.pages.LoginPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	LoginPages LoginOR;
	FileInputStream fileLoc;
	Properties prop;
	SoftAssert sAssert;

	@Parameters
	@BeforeClass
	public void setUp(String Browser, String Url) throws IOException {

		fileLoc =new FileInputStream("src/test/java/org/ems/testdata/credentials.properties");
		prop = new Properties();
		prop.load(fileLoc);
		sAssert = new SoftAssert();
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();		
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}else if(Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();		
		}
		
		LoginOR = new LoginPages(driver);
		driver.get(Url); // Load the URL on the Driver
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass	
	public void tearDown() {
		driver.quit();
	}

}
