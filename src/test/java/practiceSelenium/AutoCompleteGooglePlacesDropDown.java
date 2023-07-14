package practiceSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {
	
	@Test
	public void autocompleteGooglePlaces() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://twoplugs.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();
		WebElement search = driver.findElement(By.id("autocomplete"));
		search.clear();
		String str = "Toronto";
		for(int i=0; i<str.length();i++) {
			StringBuilder sb = new StringBuilder();
			String s =sb.append(str.charAt(i)).toString();
			search.sendKeys(s);
			Thread.sleep(500);
		}
		
		String text;
		do {
			search.sendKeys(Keys.ARROW_DOWN);
			text = search.getAttribute("value");
			if(text.equals("Toronto, OH, USA")) {
				search.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		}while(!text.isEmpty());
		
		
		
	}
}
