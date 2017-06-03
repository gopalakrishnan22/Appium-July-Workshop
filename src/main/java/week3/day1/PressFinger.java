package week3.day1;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PressFinger {


	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "5489f632");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		// Find one of the element
		WebElement points = driver.findElementById("com.the511plus.MultiTouchTester:id/points");
		
		TouchAction action = new TouchAction(driver);
		action.press(points).perform();
		
		
	}

}
