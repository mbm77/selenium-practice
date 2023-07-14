package practiceSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableDemo {
	WebDriver driver;
	@Test
	public void dynamicWebTableDemo() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.findElement(By.name("username")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space() = 'Login']")).click();

		driver.findElement(By.xpath("//button[@class = 'btn-close']")).click();
		driver.findElement(By.xpath("//a[normalize-space() = 'Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space() = 'Orders']")).click();
		String table_info = driver.findElement(By.xpath("//div[@id='order']//div[contains(@class,'text-end')]")).getText();
		String str_total_pages = table_info.substring(table_info.indexOf("(")+1,table_info.lastIndexOf(" "));
		int total_pages = Integer.parseInt(str_total_pages);
		for(int i=1;i<=total_pages;i++) {

			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			System.out.println(active_page.getText());
			//sactive_page.click();

			int columns = driver.findElements(By.xpath("//table[contains(@class,'table')]/thead/tr/td")).size();
			int rows = driver.findElements(By.xpath("//table[contains(@class,'table')]/tbody/tr")).size();
			for(int j=1;j<=rows;j++) {
				for(int k=4;k<=6;k++) {

					String table_data = driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody/tr["+j+"]/td["+k+"]")).getText();
					System.out.print(table_data+" ");
				}
				System.out.println();
			}
			String page = Integer.toString(i+1);

			if(Integer.parseInt(page) > total_pages) {
				break;
			}

			WebElement link;
			
				link = driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+page+"']"));
				scrollToElement(link, driver).click();
			

			Thread.sleep(3000);

		}

	}
	
	//when I got MoveTargetOutOfBoundsException then used below code then problem solved.
	public WebElement scrollToElement(WebElement elementToScroll, WebDriver webDriver) {

		Rectangle rect = elementToScroll.getRect();
		int deltaY = rect.y + rect.height;
		new Actions(webDriver)
		.scrollByAmount(0, deltaY)
		.perform();
		return elementToScroll;

	}

}
