package jaxportal.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jaxportal.abstractcomponents.Utilities;

public class adminportalLoginPage extends Utilities{
	WebDriver driver;
	String landingdurl = "https://jax-dev.unimedia.tech/";
	
	public adminportalLoginPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement logincred;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordcred;
	
	@FindBy(xpath="//span[@class='mdc-button__label']")
	WebElement submitbutton;
	
	public void goTo() {
		driver.get(landingdurl);
	}
	
	public void enteringtheemail() {
		logincred.sendKeys("okasha_momin@softprodigy.com");
	}
	public void enteringthepass() {
		passwordcred.sendKeys("Pass@123");
	}
	public void loginsubmit() {
		submitbutton.click();
	}
}
