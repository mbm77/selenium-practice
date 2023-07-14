package practiceSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesDemo {
	
	@Test
	public void testWindows() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		String windowId = driver.getWindowHandle();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr= windowIds.iterator();
//		String parentWindow = itr.next();
//		String childWindow1 = itr.next();
		
		//System.out.println(parentWindow);
		//System.out.println(childWindow1);
		
		List<String> windowsList = new ArrayList<String>(windowIds);
//		String w1 = windowsList.get(0);
//		String w2 = windowsList.get(1);
//		
//		driver.switchTo().window(w1);
//		String parentTitle = driver.getTitle();
//		
//		driver.switchTo().window(w2);
//		String child1_title = driver.getTitle();
		
		for(String window:windowsList) {
			String title = driver.switchTo().window(window).getTitle();
			if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.close();
			}
			System.out.println(title);
		}
		
		
	}
}
