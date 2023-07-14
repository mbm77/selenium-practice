package practiceSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions {
	
	@Test
	public void keyBoardActions() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://text-compare.com/");
		WebElement text1 = driver.findElement(By.id("inputText1"));
		WebElement text2 = driver.findElement(By.id("inputText2"));
		text1.sendKeys("getLocation getSize FileUtils groups run include");
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		
		actions.sendKeys(Keys.TAB);
		
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		
		String data1 = text1.getText();
		String data2 = text2.getText();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(data1.equals(data2)) {
			
			js.executeScript("window.alert('both same')");
		}else {
			js.executeScript("window.alert('both not same')");
		}
		
		
	}
}
