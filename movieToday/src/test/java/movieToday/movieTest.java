package movieToday;
import org.openqa.selenium.By;

//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class movieTest {
  //declare Selenium WebDriver
  private WebDriver driver;		
  
  
  @Test(priority=1)
  public void addMovie() throws InterruptedException{
	  
	  //define the drive instance
	 
	  
	  // browser look for link with text value
	  driver.findElement(By.linkText("Add New Movies")).click();
	  driver.getCurrentUrl();
  
	  
	// steps for creating a movie
	  driver.findElement(By.name("movieName")).sendKeys("White House Down");
	  driver.findElement(By.name("movieGenre")).sendKeys("Action");
	  driver.findElement(By.name("movieDescription")).sendKeys("Capitol Policeman John Cale has just been denied his dream job with the secret service of protecting President Ligma...");
	  driver.findElement(By.name("movieCasts")).sendKeys("Roland Emmerich, James Vanderbilt");
	  driver.findElement(By.name("movieDuration")).sendKeys("120");
	  driver.findElement(By.name("movieDateRelease")).sendKeys("28/6/13");
	  driver.findElement(By.name("movieImage")).sendKeys("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.rottentomatoes.com%2Fm%2Fwhite_house_down&psig=AOvVaw0QUjY_uw97aZEsS1hRG7xe&ust=1645001369141000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKjo0uSpgfYCFQAAAAAdAAAAABAD");
	  driver.findElement(By.name("addMovie")).click();
//	  driver.get("http://localhost:8080/movieToday/MovieServlet/display");
  }
 
  @Test(priority=2)
  public void updateMovie() throws InterruptedException{
	  
  
	  //steps for updating a movie
	  driver.findElement(By.linkText("Edit")).click();
	  driver.getCurrentUrl();
	  driver.findElement(By.name("movieName")).sendKeys("White House Up");
	  driver.findElement(By.name("movieGenre")).sendKeys("Parody");
	  driver.findElement(By.name("movieDescription")).sendKeys("Capitol Policeman joe biden has just been denied his dream job with the secret service of protecting President Ligma...");
	  driver.findElement(By.name("movieCasts")).sendKeys("man, woman");
	  driver.findElement(By.name("movieDuration")).clear();
	  driver.findElement(By.name("movieDuration")).sendKeys("120");
	  driver.findElement(By.name("movieDateRelease")).sendKeys("28/6/14");
	  driver.findElement(By.name("movieImage")).sendKeys("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.rottentomatoes.com%2Fm%2Fwhite_house_down&psig=AOvVaw0QUjY_uw97aZEsS1hRG7xe&ust=1645001369141000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKjo0uSpgfYCFQAAAAAdAAAAABAD");
	  driver.findElement(By.name("savebtn")).click();
	  Thread.sleep(2000);
  }
@Test(priority=3)
  public void deleteMovie() throws InterruptedException{
	  //steps for deleting a movie
	driver.findElement(By.linkText("Delete")).click();
  }
  
  
  
  @BeforeTest
  public void beforeTest() {

	  // define the chrome driver
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  
	  //define the drive instance
	  driver = new ChromeDriver();
	  
	  //navigate to url http://localhost:8080/movieToday/MovieServlet/display
	  driver.get("http://localhost:8080/movieToday/MovieServlet/display");
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
