import static org.testng.Assert.assertTrue;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ThirdTest {
	WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static boolean FinishMessage;

	@BeforeMethod
	public void Basic() throws InterruptedException{			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
			driver = new ChromeDriver(); 
			String baseUrl = "https://the-internet.herokuapp.com";
		    driver.get(baseUrl);
		    driver.manage().window().maximize();
		    Thread.sleep(4000);
	}
	
	public void Navigating() throws InterruptedException {
		WebElement dynamicLoading = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]"));
		js.executeScript("arguments[0].scrollIntoView();", dynamicLoading);
		Thread.sleep(3000);
		//scrolling to dynamic loading
		dynamicLoading.click();
		//Click on file dynamic loading
		Thread.sleep(3000);
		//waiting for loading the page content
		driver.findElement(By.xpath("//a[contains(text(),'Example 2: Element rendered after the fact')]")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[contains(text(),'Example 2: Element rendered after the fact')]")));
		//waiting for page loading
	}
	
	public void rendering() {
		driver.findElement(By.id("start")).click();
		//click start loading
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		//wait for loading 
		FinishMessage = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).isDisplayed();
	}
	
	@Test(priority=1)
	public void ResultLoadingTest() throws InterruptedException {
		Navigating();
		rendering();
		assertTrue(FinishMessage);
	}
	
}
