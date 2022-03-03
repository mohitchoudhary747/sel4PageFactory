package pagefactory.sel4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserLanguageCopyExample {
    WebDriver driver;
    @Test
    public void check(){
        //ChromeOptions object
        ChromeOptions options = new ChromeOptions();
//        String[] args=new String[1];
//        args[0]="--lang=fr-CA";
//        //set language to Spanish
//        options.addArguments(args);
        options.addArguments("--intl.accept_languages=en-US");
        WebDriverManager.chromedriver().setup();

        // configure options parameter to Chrome driver
         driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        System.out.println("a");
        JavascriptExecutor exec=(JavascriptExecutor) driver;
       String val= exec.executeScript("return window.navigator.language").toString();
        System.out.println(val);
    }

    @Test
    public void workingSolution(){

        /*
        Chrome Commands: https://peter.sh/experiments/chromium-command-line-switches/
        Solution Worked For Me: https://stackoverflow.com/questions/18645205/set-chromes-language-using-selenium-chromedriver

         */
        DesiredCapabilities jsCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "fr");
//        prefs.put("intl.accept_languages", "es");
        options.setExperimentalOption("prefs", prefs);
        jsCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        System.out.println("a");
        JavascriptExecutor exec=(JavascriptExecutor) driver;
        String val= exec.executeScript("return window.navigator.language").toString();
        driver.get("https://www.google.com/");
        System.out.println(val);
    }
    /*
    Not Working
     */
    @Test
    public void tryingOtherSolution(){

        /*
        Chrome Commands: https://peter.sh/experiments/chromium-command-line-switches/
        Solution Worked For Me: https://stackoverflow.com/questions/18645205/set-chromes-language-using-selenium-chromedriver

         */
        ChromeOptions options = new ChromeOptions();
        options.setCapability("intl.accept_languages", "fr");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        System.out.println("a");
        JavascriptExecutor exec=(JavascriptExecutor) driver;
        String val= exec.executeScript("return window.navigator.language").toString();
        System.out.println(val);
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
