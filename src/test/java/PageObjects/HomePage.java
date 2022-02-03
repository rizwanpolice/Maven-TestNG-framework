package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import driver.BaseClass;

public class HomePage extends BaseClass{

  @FindBy( xpath = "//div[text()=\"Profile\"]")
  private WebElement homepageHeader;
  
  @FindBy( id = "submit")
  private WebElement logoutButton;
	
   public void ISeeHomePage() {
	  new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()=\"Profile\"]")));
	  String homePage = homepageHeader.getText();
	  
	  // Hard assertion
	  // if it fails, next statements will not run
	  Assert.assertEquals(homePage, "somethingelse");
	  
	  //Soft assertion
	  // if it fails, next statements will run
//	  SoftAssert soft = new SoftAssert();
//	  soft.assertEquals(homePage, "somethingelse","The assertion for homepage failed");
	  
	  System.out.println("This is an after assertion statement");
	  
	  // 2 types
	  // 1. Soft assertion
	  // 2. Hard assertion
   }
   
   public void clickLogout() {
	   new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(logoutButton));
	   logoutButton.click();
   }

   
   
}
