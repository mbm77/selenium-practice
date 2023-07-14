package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropDown {
	
	@Test
	public void testDropDownDatepicker() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.id("third_date_picker")).click();
		
		String target_month = "Jan";
		String target_year = "2010";
		String target_day = "20";
		
		
		
		while(true) {
			WebElement month_dd = driver.findElement(By.className("ui-datepicker-month"));
			WebElement year_dd = driver.findElement(By.className("ui-datepicker-year"));
			Select select_month = new Select(month_dd);
			Select select_year = new Select(year_dd);
			String month = select_month.getFirstSelectedOption().getText();
			String year = select_year.getFirstSelectedOption().getText();
			if(target_month.equalsIgnoreCase(month) && target_year.equals(year)) {
				break;
			}else {
				
				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]/span")).click();
				
			}
		}
		
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr//td[not(contains(@class,' ui-datepicker-other-month '))]"));
		for(WebElement td:days) {
			String day = td.getText();
			if(day.equals(target_day)) {
				td.click();
				break;
			}
		}
	}
}
