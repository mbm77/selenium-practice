package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableDemo {

	@Test
	public void testTableData() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/th"));
		
		for(int i=2;i<=rows.size();i++) {
			
			for(int j=2;j<columns.size();j++) {
				String data = driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(data.equals("Helen Bennett")) {
					String b_data="";
					for(int k=j;k<columns.size();k++) {
						b_data = b_data+driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr["+i+"]/td["+k+"]")).getText()+" ";
						
					}
					
					System.out.println(b_data);
				}
				
				
			}
			System.out.println();
		}
		
	}
}
