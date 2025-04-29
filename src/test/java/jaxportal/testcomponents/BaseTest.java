package jaxportal.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import jaxportal.pageobjects.adminportalLoginPage;

public class BaseTest {
	String browser;
	public WebDriver driver;
	protected adminportalLoginPage login;
	
	
	public WebDriver initalizeDriver() throws IOException {
		// Load properties
		Properties prop = new Properties();
		String fileSeparator = System.getProperty("file.separator");

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "java" 
				+ fileSeparator + "jaxportal" + fileSeparator + "resources" 
				+ fileSeparator + "GlobalProperties.properties");

		prop.load(fis);
		
		browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		switch (browser.toLowerCase()) {
			case "chrome" -> {
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
			}
			case "chrome-headless", "headless-chrome" -> {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
				driver.manage().window().setSize(new Dimension(1440, 900));
			}
			case "firefox" -> driver = new FirefoxDriver();
			case "edge" -> driver = new EdgeDriver();
			default -> {
				Assert.fail("The Browser Setup is not Configured for " + browser + ". It might be due to spelling mistake or a missing browser");
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public adminportalLoginPage launchApplication() throws IOException {
		driver = initalizeDriver();
		login = new adminportalLoginPage(driver);
		login.goTo();
		return login;
	}

//	@AfterMethod(alwaysRun = true)
//	public void closeBrowser() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
}