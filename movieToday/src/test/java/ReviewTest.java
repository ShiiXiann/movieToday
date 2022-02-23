

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ReviewTest {
	private WebDriver driver;

	//@Test
	//public void f() throws InterruptedException {
		// define the chrome driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");

		// define the driver instance
//	  WebDriver driver = new ChromeDriver();
//	  // tell driver to maximize window first before loading in
//	  driver.manage().window().maximize();
		// navigate the browser to the url
//		driver.get("http://localhost:8080/movieToday/login.jsp");
//
//		// fill up the login form
//		driver.findElement(By.name("username")).sendKeys("Yuandao1");
//		driver.findElement(By.name("password")).sendKeys("123");
//		Thread.sleep(2000);
//		// click on the login button
//		driver.findElement(By.name("login")).click();
//		Thread.sleep(2000);
//		// click on review
//		driver.findElement(By.linkText("Review")).click();
//		Thread.sleep(2000);
//		// fill up the movie_id and the feedback
//		driver.findElement(By.name("movie_id")).sendKeys("1");
//		driver.findElement(By.name("review")).sendKeys("this movie is good");
//		Thread.sleep(2000);
//		// click the submit button
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(2000);
//		// click on the edit
//		driver.findElement(By.linkText("Edit")).click();
//		Thread.sleep(2000);
//		// type something in review
//		driver.findElement(By.name("review")).clear();
//		driver.findElement(By.name("review")).sendKeys("this movie is too good");
//		Thread.sleep(2000);
//		// click on save
//		driver.findElement(By.name("save")).click();
//		Thread.sleep(2000);
//		// click on delete
//		driver.findElement(By.linkText("Delete")).click();
//		Thread.sleep(2000);

	// }

	@Test
	public void aLogin() throws InterruptedException {
		driver.get("http://localhost:8080/movieToday/login.jsp");

		// fill up the login form
		driver.findElement(By.name("username")).sendKeys("Yuandao1");
		driver.findElement(By.name("password")).sendKeys("123");
		Thread.sleep(2000);
		// click on the login button
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);

	}

	@Test
	public void bCreateReview() throws InterruptedException {
		// click on review
		driver.findElement(By.linkText("Review")).click();
		Thread.sleep(2000);
		// fill up the movie_id and the feedback
		driver.findElement(By.name("movie_id")).sendKeys("1");
		driver.findElement(By.name("review")).sendKeys("this movie is good");
		Thread.sleep(2000);
		// click the submit button
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
	}

	@Test
	public void cEditReview() throws InterruptedException {
		// click on the edit
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		// type something in review
		driver.findElement(By.name("review")).clear();
		driver.findElement(By.name("review")).sendKeys("this movie is too good");
		Thread.sleep(2000);
		// click on save
		driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
	}
	
	  @Test
	  public void dDeleteReview()throws InterruptedException {
		// click on delete
			driver.findElement(By.linkText("Delete")).click();
			Thread.sleep(2000);
	  }

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
	}

}
