package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {
	
	@Test
	public void testDatePicker() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		String target_year = "2023";
		String target_month = "july";
		String target_date = "20";
		driver.findElement(By.id("first_date_picker")).click();
		String str_date = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-title']")).getText();
		String month = str_date.split(" ")[0];
		String year = str_date.split(" ")[1];
		System.out.println(month+' '+year);
	
		while(true) {
			if(target_year.equals(year) && target_month.equalsIgnoreCase(month)) {
				break;
			}else {
				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
			}
		}
		
		List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td[not(contains(@class,'ui-datepicker-other-month'))]"));
		
		for(WebElement td:all_dates) {
			String day = td.getText();
			if(day.equals(target_date)) {
				td.click();
			}
		}
	}
}
