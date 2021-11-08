import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest {
	WebDriver driver = null;

	@BeforeMethod
	public void Basic() throws InterruptedException{			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
			driver = new ChromeDriver(); 
			String baseUrl = "https://the-internet.herokuapp.com";
		    driver.get(baseUrl);
		    driver.manage().window().maximize();
		    Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void FileUpload() {
		driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
		//Click on file upload link
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[contains(text(),'File Upload')]")));
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\aliab\\eclipse-workspace\\Terkwaz\\Files\\pexels-photo-771742.jpeg");
		//click on the upload button
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("file-upload")));
		driver.findElement(By.id("file-submit")).click();
		//submit the photo
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("file-submit")));
		boolean FileStatus = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).isDisplayed();
		assertTrue(FileStatus);		
	}
}
