package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	
	WebDriver driver;
	
	String userName = "demo@techfios.com";
	String password ="abc123";		
	String Dashboard_Header_Text = "Dashboard";
	String AddCustomer_Header_Text = "Add Contact";
	String fullName = "Selenium Feb2023";
	String COMPANY = "Techfios";
	String EMAIL = "demoFeb23@techfios.com";
	String PHONE = "1234567";
	String COUNTRY = "Antarctica";
	
	
	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, password);
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		
		dashboardPage.clickOnCustomerMenuElement();
		dashboardPage.clickOnAddCustomerMenuElement();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateaddCustomerPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyName(COMPANY);
		addCustomerPage.insertEmail(EMAIL);
		addCustomerPage.insertPhoneNum(PHONE);
		addCustomerPage.selectCountryName(COUNTRY);
		
		
	}

}
