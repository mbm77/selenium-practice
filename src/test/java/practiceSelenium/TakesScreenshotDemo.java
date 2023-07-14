package practiceSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreenshotDemo {
	
	@Test
	public void takeScreenshotMethod() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
		
		/* TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\screenshots\\test.png"));
			System.out.println("screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		} */
		
	/*	WebElement section = driver.findElement(By.xpath("//div[@class='picture']//a[@title='Show details for Apple MacBook Pro 13-inch']"));
		File source = section.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\screenshot3\\test2.png"));
			System.out.println("screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		} */
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']/a"));
		File source = logo.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(".\\screenshots\\logo.png"));
			System.out.println("screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
