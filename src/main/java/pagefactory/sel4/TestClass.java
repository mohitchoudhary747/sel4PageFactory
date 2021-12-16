package pagefactory.sel4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	private String url ="http://automationpractice.com/index.php";
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		Reporter.log("Title is: "+driver.getTitle(), true);
		
	}
	@Test
	public void checkingScroll() throws InterruptedException
	{

		PageActions actions=new PageActions(driver);
		actions.waitForContactUs();
		actions.scrollingToBlouse();
		
		actions.checkIfElemenentPresent();
		
		Thread.sleep(3000);
		

		
			
	}
	
	
@AfterTest
public void tearDown() throws Exception {
	if(driver!=null)
	{
		driver.quit();
	}
}

}
