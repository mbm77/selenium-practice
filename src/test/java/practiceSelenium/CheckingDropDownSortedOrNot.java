package practiceSelenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingDropDownSortedOrNot {
	
	@Test
	public void checkingDropdownOrder() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://twoplugs.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();
		WebElement selectElement = driver.findElement(By.name("category_id"));
		
		Select ctgr_dd = new Select(selectElement);
		
		List<WebElement> elements = ctgr_dd.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for(WebElement option:elements) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		
		Collections.sort(tempList);
		
		System.out.println("Original List"+originalList);
		System.out.println();
		System.out.println("Temp List"+tempList);
		
		if(originalList.equals(tempList)) {
			System.out.println("DropDown in sorted order");
		}else {
			System.out.println("DropDown not in sorted order");
		}
	}

}
