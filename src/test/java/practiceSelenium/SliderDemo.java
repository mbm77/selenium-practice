package practiceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	@Test
	public void testSlider() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		WebElement min = driver.findElement(By.xpath("//span[1]"));
		WebElement max = driver.findElement(By.xpath("//span[2]"));
		System.out.println(min.getLocation());
		System.out.println(min.getSize());
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(min, 100, 0).perform();
		
		actions.dragAndDropBy(max, -100, 0).perform();
	}
}
