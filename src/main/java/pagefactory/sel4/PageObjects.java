package pagefactory.sel4;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	WebDriver driver;
	public PageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='Contact Us']")
	public WebElement linkContactUs;
	
	@FindBy(xpath = "(//a[normalize-space(text())='Faded Short Sleeve T-shirts'])[1]")
	public WebElement txtBlouse;
	
	@FindBy(xpath = "//body//*[text()='mohit']")
	public List<WebElement> myWrongElement;
	
}
