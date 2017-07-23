package day2.session3;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LearnAppInstall {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "5489f632");		
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		// InteractsWithApps
		
		
		// Check if it is Installed?
		System.out.println(driver.isAppInstalled("com.the511plus.MultiTouchTester"));
		
		
		// Remove It if it exist
		if(driver.isAppInstalled("com.the511plus.MultiTouchTester")){
			driver.removeApp("com.the511plus.MultiTouchTester");
		}
		System.out.println(driver.isAppInstalled("com.the511plus.MultiTouchTester"));

		
		// Else Install it






	}

}
