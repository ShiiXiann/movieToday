

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class FavouriteTest {
	private WebDriver driver;

//	@Test
//	public void f() throws InterruptedException {
//		// define the chrome driver
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//
//		// define the drive instance
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	}

	@Test (priority=1)
	public void clickLogin() throws InterruptedException {

		// login
		driver.get("http://localhost:8080/movieToday/login.jsp");
		driver.findElement(By.name("username")).sendKeys("null");
		driver.findElement(By.name("password")).sendKeys("123");

		driver.findElement(By.name("login")).click();
		driver.getCurrentUrl();
		Thread.sleep(2000);
	}

	@Test (priority=2)
	public void AddToFav() throws InterruptedException {

		// favourites
		driver.findElement(By.linkText("Home")).click();
		driver.getCurrentUrl();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Add to Fav")).click();
		driver.getCurrentUrl();
		Thread.sleep(2000);

	}

	@Test (priority=3)
	public void DeleteFav() throws InterruptedException {

		driver.findElement(By.linkText("Remove")).click();
	}

	@BeforeTest
	public void beforeTest() {
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
