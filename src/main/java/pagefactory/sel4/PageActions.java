package pagefactory.sel4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class PageActions {
	WebDriver driver;
	PageObjects page;
	
	
	public PageActions(WebDriver driver)
	{
		this.driver=driver;
		page=new PageObjects(driver);
	}
	
	public void waitForContactUs()
	{
		Reporter.log("Going to Wait for Contact Us",true);
		WebElement ele=WdUtils.waitForElementToVisible(driver, page.linkContactUs);
		Reporter.log(ele.getText()+"Got this text");
		Reporter.log("Waited for the Contact Us", true);
	}
	public void scrollingToBlouse()
	{
//		page.txtBlouse
		JavascriptExecutor exe=(JavascriptExecutor) driver;
		exe.executeScript("arguments[0].scrollIntoView(true)", page.txtBlouse);
		
	}
	public void checkIfElemenentPresent() {
		Reporter.log("Checking Element Exists",true);
		
		
		
		Reporter.log("Before"
			+	printDate(),true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		List<WebElement> myElement=page.myWrongElement;
		int size=myElement.size();
		Reporter.log("Size is "+size, true);
		Reporter.log("After"
				+	printDate(),true);
		
		Reporter.log("Done with Element Check",true);
	}
	public String printDate()
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime myDateObj = LocalDateTime.now();
	    String formattedDate = myDateObj.format(myFormatObj);
	    return formattedDate;
	}
}