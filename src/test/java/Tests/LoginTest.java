package Tests;

import PageObjects.HomePage;

import PageObjects.LoginPage;
import driver.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseClass {
	static LoginPage login;
	static HomePage homePage;
	static {
		login = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		System.out.println("This is in static block");
	}
	
	// Priority
	// Groups
	
	@BeforeMethod (alwaysRun = true)
	public void hitURL() {
		driver.get("https://demoqa.com/login");
	}
	
	@Test (description = "Successful login", priority = 1, groups = {"Login", "Login1"})
	@Parameters ({"username" , "password"})
	public void PositiveLogin(String username, String password) {
		System.out.println("This is positive login");
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		homePage.ISeeHomePage();
	}

	@Test (description = "Invalid login", priority = 2, groups = {"Login","Login2","NegativeLogin"})
	@Parameters({"username","wrongPassword"})
	public void NegativeLogin(String username, String wrongPassword) {
		System.out.println("This is invalid login");
		login.enterUsername(username);
		login.enterPassword(wrongPassword);
		login.clickLoginButton();
		login.IShouldSeeErrorMEssage();
	}
	
	@DataProvider (name = "login-data")
	public Object[][] dpMethod(){
		return new Object[][] {
			{"RizwanDemo","TestPassword@1"},
			{"RizwanDemo2","TestPassword@2"},
			{"RizwanDemo3","TestPassword@3"}
			};
	}
	
	@Test (description = "Multiple login", priority = 1, groups = {"Login", "Login3"}, dataProvider = "login-data")
	public void MultipleLogin(String username, String password) {
		System.out.println("This is multiple login");
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		
		//Exception handling
		try {
			homePage.clickLogout();
		}catch(Exception e) {
			login.IShouldSeeErrorMEssage();
		}catch(Throwable e) {
			System.out.println("There is an error in logout");
		}
	}
	
	@AfterSuite (alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
