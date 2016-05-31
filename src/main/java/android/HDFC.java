package android;

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

public class HDFC {

	AndroidDriver<WebElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", "com.snapwork.hdfc");
		capabilities.setCapability("appActivity", "com.snapwork.hdfc.HDFCBank");
		capabilities.setCapability("deviceName", "071c47a40b3fa1f4");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}

	@Test
	public void Instgram() throws InterruptedException, IOException{
		Thread.sleep(15000);
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
			driver.context(context);
		}
		
		driver.findElementByAccessibilityId("My Account").click();
		driver.findElementByAccessibilityId("Enter 4 digit Quick access pin").click();
		

		
	}


	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
