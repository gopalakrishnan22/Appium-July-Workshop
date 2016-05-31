package day5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AmazonWebSite {

	AndroidDriver<WebElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//		capabilities.setCapability("appPackage", "com.google.android.gm");
		//		capabilities.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
		//		capabilities.setCapability("appActivity", "com.instagram.android/.nux.SignedOutFragmentActivity");
		capabilities.setCapability("deviceName", "071c47a40b3fa1f4");
		capabilities.setCapability("browserName", "chrome");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}

	@Test
	public void Amazon() throws InterruptedException, IOException{
		
		driver.get("http://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.findElementsByClassName("nav-input").size());
		//driver.findElementById("twotabsearchtextbox").sendKeys("Bags");
		driver.findElementsByClassName("nav-input").get(1).sendKeys("Bags");
		
		//driver.findElementByLinkText("Deals").click();
		
//		driver.scrollTo("Ray-Ban");

	}


	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
