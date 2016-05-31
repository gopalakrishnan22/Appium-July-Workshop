package day5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AmericanAirlines {

	AndroidDriver<?> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", "com.aa.ct.innovation.keystar.vipBanner");
		capabilities.setCapability("appActivity", "com.aa.ct.innovation.keystar.vipBanner.VIPBanner");
		capabilities.setCapability("deviceName", "4d008cc9b253c0fd");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}

	@Test
	public void AmericanAir() throws InterruptedException, IOException{


		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
		}
		driver.context("WEBVIEW_1");
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
