package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id = "userName")
	WebElement usernameField;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordField;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	@FindBy(id = "newUser")
	WebElement newUserButton;

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickNewUserButton() {
		newUserButton.click();
	}
	
	public void IShouldSeeErrorMEssage() {
		
	}

}
