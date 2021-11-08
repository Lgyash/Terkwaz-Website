import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class APITest {
	
	public String Path;
	
	@BeforeMethod
	public void Basic() throws InterruptedException{			
			Path = "https://alexwohlbruck.github.io/cat-facts/";
	}
	
	@Test(priority=1)
	public void CatFacts() {
		given().
		when().get(Path).
		then().body("isEmpty()", Matchers.is(false));
	}
	
	@Test(priority=2)
	public void GetRandomCat() {
		int random = (int)(Math.random() * 5 + 1);
		String CatFact = given().
		when().get(Path).
		then().extract().path("[random]._id");
		System.out.println(CatFact);
	}
	
	
}
