package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver; // one field/variable
	
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91996\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
		driver = new ChromeDriver();
	}
}
