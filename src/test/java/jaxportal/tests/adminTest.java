package jaxportal.tests;
import org.testng.annotations.Test;

import jaxportal.pageobjects.adminportalDashboard;
import jaxportal.testcomponents.BaseTest;

public class adminTest extends BaseTest{
	@Test(groups = {"regression"})
	public void Flowone() {
		login.enteringtheemail();
		login.enteringthepass();
		login.loginsubmit();
		adminportalDashboard dashboard = new adminportalDashboard(driver);
		dashboard.ciritalcount();
		dashboard.warningtext();
		dashboard.allgoodtext();
		dashboard.allwellcount();
		dashboard.actionrequiredcount();
		dashboard.immediateactioncount();
	}
	@Test(groups = {"regression"})
	public void FlowTwo() {
		login.enteringtheemail();
		login.enteringthepass();
		login.loginsubmit();
		adminportalDashboard dashboard = new adminportalDashboard(driver);
		dashboard.verifywarningtoactionrequired();
		dashboard.verifycriticaltoimmediate();
		dashboard.verifytheallgoodtoallwell();
	}
	@Test(groups= {"regression"})
	public void FlowThree() {
		login.enteringtheemail();
		login.enteringthepass();
		login.loginsubmit();
		adminportalDashboard dashboard = new adminportalDashboard(driver);
		dashboard.checkThePercentageForAllWell();
		dashboard.checkThePercentageForActionRequired();
		dashboard.checkThePercentageForImmediateAction();
	}
	@Test(groups= {"smoke"})
	public void FlowFour() {
		login.enteringtheemail();
		login.enteringthepass();
		login.loginsubmit();
		adminportalDashboard dashboard = new adminportalDashboard(driver);
		dashboard.opencalender();
		dashboard.datepicker();
		dashboard.startdatepicker();
		dashboard.enddatepicker();
	}
}
