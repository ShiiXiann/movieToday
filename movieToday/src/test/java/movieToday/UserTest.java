package movieToday;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTest {
	private WebDriver driver;

//	@Test
//	public void f() throws InterruptedException {

//	}
	@Test
	public void aRegister() throws InterruptedException {
		// navigate the browser to this URL
		driver.get("http://localhost:8080/movieToday/register.jsp");

		// fill up the register form
		driver.findElement(By.name("username")).sendKeys("niklaus");
		driver.findElement(By.name("password")).sendKeys("camille");
		driver.findElement(By.name("email")).sendKeys("theoriginals@gmail.com");
		driver.findElement(By.name("phoneNumber")).sendKeys("98271627");

		// hit register button
		driver.findElement(By.name("register")).click();
		driver.getCurrentUrl();


	}

	@Test
	public void bLogin() throws InterruptedException {
		// fill up login form
		driver.get("http://localhost:8080/movieToday/login.jsp");
		driver.findElement(By.name("username")).sendKeys("niklaus");
		driver.findElement(By.name("password")).sendKeys("camille");

		// hit login button
		driver.findElement(By.name("login")).click();

		// redirects to profile page
		driver.getCurrentUrl();

	}

	@Test
	public void cEditProfile() throws InterruptedException {

		// user hits edit profile button
		driver.findElement(By.name("editProfile")).click();

		// redirected to edit user profile page
		driver.getCurrentUrl();

		// user to retype their information
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("phoneNumber")).clear();

		// refill up edit form
		driver.findElement(By.name("username")).sendKeys("freya");
		driver.findElement(By.name("password")).sendKeys("keelin");
		driver.findElement(By.name("email")).sendKeys("freya@gmail.com");
		driver.findElement(By.name("phoneNumber")).sendKeys("8887162");

		// user hits save button
		driver.findElement(By.name("save")).click();
		driver.getCurrentUrl();
		

	}

	@Test
	public void dDeleteProfile() throws InterruptedException {
		// fill up login form
		driver.findElement(By.name("deleteProfile")).click();
		driver.getCurrentUrl();

	}

	@BeforeTest
	public void beforeTest() {
		String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
