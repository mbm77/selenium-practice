package practiceSelenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {
	WebDriver driver;
	@Test
	public void waitsInSelenium() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Test Automation']")));
		//element.click();
		WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='Test Automation']"));
		waitForVisibility(driver);
		
		
		
	}
	
	public WebElement waitForVisibility(WebDriver driver) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement element = fwait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//a[normalize-space()='Test Automation']"));
			}
		});
		
		return element;
	}

}
