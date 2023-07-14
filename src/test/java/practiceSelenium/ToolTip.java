package practiceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
	
	@Test
	public void tootip() {
		//System.setProperty("webdriver.chrome.driver", "");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		String toolTip = driver.findElement(By.id("age")).getAttribute("title");
		System.out.println(toolTip);
	}
}
