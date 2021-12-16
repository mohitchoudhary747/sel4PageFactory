package pagefactory.sel4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WdUtils {
	
	public static WebElement waitForElementToVisible(WebDriver localDriver,WebElement element)
	{
		WebDriverWait wait=new  WebDriverWait(localDriver, Duration.ofSeconds(10000));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}

}

