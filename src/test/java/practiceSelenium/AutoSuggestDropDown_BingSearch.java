package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_BingSearch {
	@Test
	public void automateBingSearch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bing.com/");
		String str = "selenium";
		for(int i=0;i<str.length();i++) {
			StringBuilder sb = new StringBuilder();
			String s = sb.append(str.charAt(i)).toString();
			driver.findElement(By.id("sb_form_q")).sendKeys(s);
			Thread.sleep(1000);
		}


		List<WebElement> suggestions = driver.findElements(By.xpath("//li[contains(@class,'sa_sg')]//span"));
		for(WebElement s:suggestions) {
			if(s.getText().contains("download")) {
				try {
					s.click();
					break;
				}catch(StaleElementReferenceException e) {
					List<WebElement> suggestions2 = driver.findElements(By.xpath("//li[contains(@class,'sa_sg')]//span"));
					for(WebElement s2:suggestions2) {
						if(s2.getText().contains("download")) {
							s.click();
							break;
						}

					}
				}
			}

		}

	}
}
