package practiceSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownDemo {
	WebDriver driver;
	@Test
	public void testJqueryDropdown() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("start-maximized");
//		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("//input[@id='justAnotherInputBox']")).click();
		List<WebElement> choices = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		selectChoice(choices,"choice 3");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		List<WebElement> mchoices = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		selectChoice(mchoices,"choice 1","choice 2","choice 2 1","choice 3", "choice 4");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();
		List<WebElement> mchoicess = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']//input[@type='checkbox']"));
		selectChoice(mchoicess, "all");
	}
	
	public void selectChoice(List<WebElement> choices, String ... options) {
		if(!options[0].equalsIgnoreCase("all")) {
			for(WebElement choice:choices) {
				String text = choice.getText();
				for(String option:options) {
					if(text.equals(option)) {
						choice.click();
						break;
					}
				}
			}
		}else {
			for(WebElement choice:choices) {
				try {
					if(choice.isSelected()) {
						continue;
					}
					choice.click();
				}catch(Exception e) {
					
				}
				
			}
		}
		
	}
}
