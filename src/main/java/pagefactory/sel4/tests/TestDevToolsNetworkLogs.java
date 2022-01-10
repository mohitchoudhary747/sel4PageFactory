package pagefactory.sel4.tests;

import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.network.Network;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDevToolsNetworkLogs {

	WebDriver driver=null;
	DevTools devTools=null;
	HashMap<String, String> requesHeaders=null;
	String header=null;

	@BeforeClass
	public void setUp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
		devTools=((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), requestSent -> {

//			System.out.println(requestSent.getRequest().getUrl().toString());
			if(requestSent.getRequest().getUrl().toString()
					.equalsIgnoreCase("https://rahulshettyacademy.com/")) {
			System.out.println("Request URL => " + requestSent.getRequest().getUrl());

			System.out.println("Request Method => " + requestSent.getRequest().getMethod());

			System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());
			header=requestSent.getRequest().getHeaders().toString();
			System.out.println("-------------------------------------------------");
			 System.out.println(header.substring(header.indexOf("User-Agent")+11, header.length()-1));
			}

		});
		devTools.addListener(Network.requestWillBeSent(), requestSent ->{
		});




	}

	@Test
	public void verifyWeCaptureNetWorkCalls()
	{
		driver.get("https://rahulshettyacademy.com/#/index");
	 int start=header.indexOf("User-Agent");
	 int end=header.indexOf("User-Agent");
	 System.out.println("hello -> "+header.substring(14));
	}


	@AfterClass
	public void tearDown() throws Exception {
		if(driver!=null) { driver.quit(); }

	}
}
