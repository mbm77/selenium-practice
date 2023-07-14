package practiceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {

	@Test
	public void openLinkInNewTab() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		String new_tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).sendKeys(new_tab);
		
	}
	
	@Test
	public void openLinkInNewWindow() {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.nopcommerce.com/");
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com/");
	
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://demo.nopcommerce.com/");
	}
}
