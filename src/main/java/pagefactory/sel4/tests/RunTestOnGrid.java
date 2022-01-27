package pagefactory.sel4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactory.sel4.PageActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class RunTestOnGrid {
//	/sel4/resources/screen-shot
	
	private String url ="http://automationpractice.com/index.php";
	WebDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		URL hubUrl=new URL("http://192.168.1.11:4444");
				
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capbilities=new DesiredCapabilities();
		capbilities.setBrowserName("chrome");
		RemoteWebDriver driver=new RemoteWebDriver(hubUrl,capbilities);
		
//		 driver=new ChromeDriver(); 
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
