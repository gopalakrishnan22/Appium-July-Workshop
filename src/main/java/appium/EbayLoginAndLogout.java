package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.DeviceActionShortcuts;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayLoginAndLogout {
	private AppiumDriver driver;
	Dimension size;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","dc19b4ba055e1103");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	}

	@Test
	public void eBayLoginAndLogout() throws InterruptedException{
		Thread.sleep(10000);		
		driver.findElementById("com.ebay.mobile:id/action_view_icon").click();
		
		Thread.sleep(5000);
		driver.findElementById("com.ebay.mobile:id/username").click();
		
		Thread.sleep(5000);	
		driver.findElementById("com.ebay.mobile:id/edit_text_username").sendKeys("appium.testleaf@gmail.com");
		
		Thread.sleep(3000);
		driver.findElementById("com.ebay.mobile:id/edit_text_password").sendKeys("appium@123");
		
		Thread.sleep(5000);
		driver.findElementById("com.ebay.mobile:id/button_sign_in").click();
		
		Thread.sleep(10000);
		driver.findElementById("com.ebay.mobile:id/action_view_icon").click();		
		
		Thread.sleep(5000);
		driver.findElementById("com.ebay.mobile:id/settings").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Sign out']").click();
		
		Thread.sleep(5000);
		driver.findElementById("android:id/button1").click();
		
		Thread.sleep(20000);
	}	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}