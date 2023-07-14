package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_GoogleSearch {
	
	@Test
	public void autoSuggestGoogle() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		
		String str ="mbm";
		for(int i=0;i<str.length();i++) {
			StringBuilder sb = new StringBuilder();
			String s = sb.append(str.charAt(i)).toString();
			driver.findElement(By.id("APjFqb")).sendKeys(s);
			Thread.sleep(500);
		}
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		for(WebElement element:elements) {
			if(element.getText().contains("MBNA")) {
				element.click();
				break;
			}
			
		}
		
	}

}
