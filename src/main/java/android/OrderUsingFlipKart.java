package android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class OrderUsingFlipKart {
	
	@Test
	public void orderUsingFlipKart() throws MalformedURLException, InterruptedException{
		
		AndroidDriver driver;

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G22RC88");
		dc.setCapability("appPackage", "com.flipkart.android");
		dc.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		System.out.println(driver.isAppInstalled("com.flipkart.android"));
		System.out.println(driver.currentActivity());
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'your wish today')]")).click();
		driver.findElementByAccessibilityId("Shopping Cart").click();
	}

}
