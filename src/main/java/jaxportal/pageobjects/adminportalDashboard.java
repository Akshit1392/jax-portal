package jaxportal.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import jaxportal.abstractcomponents.Utilities;

public class adminportalDashboard extends Utilities{
	WebDriver driver;
	
	public adminportalDashboard(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//app-kpi-cards[@class='ng-star-inserted']/div/div/div")
	WebElement critial;
	
	@FindBy(xpath="//div[contains(text(),'Warning')]/preceding-sibling::div")
	WebElement warningtext;
	
	@FindBy(xpath="//div[contains(text(),'All Good')]/preceding-sibling::div")
	WebElement allgoodtext;
	
	@FindBy(xpath="//span[text()=\"All's Well\"]/parent::div/following-sibling::span[not(contains(text(),'%'))]")
	WebElement allwell;
	
	@FindBy(xpath="//span[text()='Action Required']/parent::div/following-sibling::span[not(contains(text(),'%'))]")
	WebElement actionrequired;
	
	@FindBy(xpath="//span[text()='Immediate Action Required']/parent::div/following-sibling::span[not(contains(text(),'%'))]")
	WebElement ImmediateAction;
	
	@FindBy(xpath="//span[text()=\"All's Well\"]/parent::div/following-sibling::span[contains(text(),'%')]")
	WebElement percentageofallwell;
	
	@FindBy(xpath ="//span[text()='Action Required']/parent::div/following-sibling::span[contains(text(),'%')]")
	WebElement percentageofactionrequired;
	
	@FindBy(xpath = "//span[text()='Immediate Action Required']/parent::div/following-sibling::span[contains(text(),'%')]")
	WebElement percentageofimmediate;
	
	@FindBy(xpath ="//mat-datepicker-toggle/button[@aria-label='Open calendar']")
	WebElement calenderclick;
	
	@FindBy(xpath ="//mat-calendar[@id='mat-datepicker-0']")
	WebElement fullcalender;
	
	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement yearselector;
	
	@FindBy(xpath="")
	WebElement yeartext;
	
	@FindBy(xpath = "//tbody[@class='mat-calendar-body']")
	WebElement yearTable;
	
	public void ciritalcount() {
		String criccount = critial.getText();
		System.out.println(criccount);
	}
	public void warningtext() {
		String warcount = warningtext.getText();
		System.out.println(warcount);
	}
	public void allgoodtext() {
		String goodcount = allgoodtext.getText();
		System.out.println(goodcount);
	}
	public void allwellcount() {
		String allcount = allwell.getText();
		System.out.println(allcount);
	}
	public void actionrequiredcount() {
		String actioncount = actionrequired.getText();
		System.out.println(actioncount);
	}
	public void immediateactioncount() {
		String immediatecount = ImmediateAction.getText();
		System.out.println(immediatecount);
	}
	
	public void verifytheallgoodtoallwell() {
		String goodcount = allgoodtext.getText();
		String allcount = allwell.getText();
		if(goodcount.compareTo(allcount)==0) {
			System.out.println("The All good is equal to All's well");
		}else {
			System.out.println("Not Matched");
		}
	}
	public void verifywarningtoactionrequired() {
		String warcount = warningtext.getText();
		String actioncount = actionrequired.getText();
		if(warcount.compareTo(actioncount)==0) {
			System.out.println("The warning number is equal to Action required number");
		}else {
			System.out.println("Not Matched");
		}
	}
	public void verifycriticaltoimmediate() {
		String criccount = critial.getText();
		String immediatecount = ImmediateAction.getText();
		if(criccount.compareTo(immediatecount)==0) {
			System.out.println("The Critical number is equal to Immediate action required number");
		}else {
			System.out.println("Not Matched");
		}
	}
	public void checkThePercentageForAllWell() {
	    String allcount = allwell.getText();
	    int number1 = Integer.valueOf(allcount);
	    String actioncount = actionrequired.getText();
	    int number2 = Integer.valueOf(actioncount);
	    String immediatecount = ImmediateAction.getText();
	    int number3 = Integer.valueOf(immediatecount);

	    int sum = number1 + number2 + number3;
	    double percent = ((double) number1 / sum) * 100;
	    long roundedPercent = Math.round(percent);

	    String perceofallwell = percentageofallwell.getText();
	    perceofallwell = perceofallwell.replace("%", "");

	    long actualPercent = Long.parseLong(perceofallwell);

	    if (roundedPercent == actualPercent) {
	        System.out.println("The percentage of all's well is correct");
	    } else {
	        System.out.println("Not correct");
	    }
	}
	
	public void checkThePercentageForActionRequired() {
	    String allcount = allwell.getText();
	    int number1 = Integer.valueOf(allcount);
	    String actioncount = actionrequired.getText();
	    int number2 = Integer.valueOf(actioncount);
	    String immediatecount = ImmediateAction.getText();
	    int number3 = Integer.valueOf(immediatecount);

	    int sum = number1 + number2 + number3;
	    double percent = ((double) number2 / sum) * 100;
	    long roundedPercent = Math.round(percent);

	    String perceofallwell = percentageofactionrequired.getText();
	    perceofallwell = perceofallwell.replace("%", "");

	    long actualPercent = Long.parseLong(perceofallwell);

	    if (roundedPercent == actualPercent) {
	        System.out.println("The percentage of Action Require is correct");
	    } else {
	        System.out.println("Not correct");
	    }
	}
	
	public void checkThePercentageForImmediateAction() {
	    String allcount = allwell.getText();
	    int number1 = Integer.valueOf(allcount);
	    String actioncount = actionrequired.getText();
	    int number2 = Integer.valueOf(actioncount);
	    String immediatecount = ImmediateAction.getText();
	    int number3 = Integer.valueOf(immediatecount);

	    int sum = number1 + number2 + number3;
	    double percent = ((double) number3 / sum) * 100;
	    long roundedPercent = Math.round(percent);

	    String perceofallwell = percentageofimmediate.getText();
	    perceofallwell = perceofallwell.replace("%", "");

	    long actualPercent = Long.parseLong(perceofallwell);

	    if (roundedPercent == actualPercent) {
	        System.out.println("The percentage of Immediate Action Required is correct");
	    } else {
	        System.out.println("Not correct");
	    }
	}
	public void opencalender() {
		System.out.println("Hii open callender is working fine");
		calenderclick.click();
	}
	public void datepicker() {
		System.out.println("Date picker is working fine");
		waitForElementToAppear(fullcalender);
		String currentyear = yearselector.getText();
		System.out.println(currentyear);
		yearselector.click();
	}
	public void startdatepicker() {
		String year = "2024";
		String month = "MAR";
		String date = "8";
		
		List<WebElement> allYears = driver.findElements(By.xpath("//td[@role='gridcell']//span[contains(@class, 'mat-calendar-body-cell-content')]"));
		for (WebElement yearElement : allYears) {
		    String yearText = yearElement.getText().trim();
		    if (yearText.equals(year)) {
		        yearElement.click();
		        break;
		    }
		}
		List<WebElement> allmonth = driver.findElements(By.xpath("//span[contains(@class, 'mat-calendar-body-cell-content')]"));
		for (WebElement span : allmonth) {
		    if (span.getText().trim().equals(month)) {
		        span.click();
		        break;
		    }
		}
		List<WebElement> alldate = driver.findElements(By.xpath("//span[contains(@class, 'mat-calendar-body-cell-content mat-focus-indicator')]"));
		for(WebElement findate : alldate) {
			if(findate.getText().trim().equals(date)) {
				findate.click();
				break;
			}
		}
	}
	
	public void enddatepicker() {
		String year = "2024";
		String month = "MAR";
		String date = "8";
		
		List<WebElement> allYears = driver.findElements(By.xpath("//td[@role='gridcell']//span[contains(@class, 'mat-calendar-body-cell-content')]"));
		for (WebElement yearElement : allYears) {
		    String yearText = yearElement.getText().trim();
		    if (yearText.equals(year)) {
		        yearElement.click();
		        break;
		    }
		}
		List<WebElement> allmonth = driver.findElements(By.xpath("//span[contains(@class, 'mat-calendar-body-cell-content')]"));
		for (WebElement span : allmonth) {
		    if (span.getText().trim().equals(month)) {
		        span.click();
		        break;
		    }
		}
		List<WebElement> alldate = driver.findElements(By.xpath("//span[contains(@class, 'mat-calendar-body-cell-content mat-focus-indicator')]"));
		for(WebElement findate : alldate) {
			if(findate.getText().trim().equals(date)) {
				findate.click();
				break;
			}
		}
	}
}
