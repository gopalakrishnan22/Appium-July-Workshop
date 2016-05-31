package day5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Gmail {

	AndroidDriver<?> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", "com.google.android.gm");
		capabilities.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
		//		capabilities.setCapability("appActivity", "com.instagram.android/.nux.SignedOutFragmentActivity");
		capabilities.setCapability("deviceName", "071c47a40b3fa1f4");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}

	@Test
	public void Instgram() throws InterruptedException, IOException{

		Thread.sleep(10000);
		System.out.println(driver
				.findElementsByXPath("(//android.view.View[@content-desc='Tap to select this conversation'])[1]/../android.view.View").size());
		
		 WebElement firstEmail = driver
		.findElementByXPath("((//android.view.View[@content-desc="
				+ "'Tap to select this conversation'])[2]/../android.view.View)[1]");
	
		TouchAction tAction = new TouchAction(driver);
		tAction.tap(firstEmail).perform();
//	driver.swipe(startx, starty, endx, endy, duration);
	}
	//	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
