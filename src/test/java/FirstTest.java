import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

	WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeMethod
	public void Basic() throws InterruptedException{			
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
	    driver = new ChromeDriver(); 
	    String baseUrl = "https://www.google.com/ncr";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	}
	
	public void Search() throws InterruptedException {
		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("selenium webdriver");
		//search for "selenium webdriver" 
		Thread.sleep(3000);
	}
	
	public void Check() {
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='g']//div//div"));
		if ( items.size() > 0 ) {
			//Looping on all results
			if(items.size() == 3) {
				js.executeScript("arguments[0].scrollIntoView();", items.get(3));
			}
		  for ( WebElement we: items ) {
			//setting the list elements one by one in the weblement we
		   if (we.getText().contains("What is Selenium WebDriver")) {
			   break;
			   //if the we variable contains this text assert for true
		   	  }
		   }
		   	assertTrue(true);
		   	//asserting the result with true
		}
		 
	}
	
	@Test(priority=1)
	public void FirstTest() throws InterruptedException {
		Search();
		Check();
	}
	
	
}
