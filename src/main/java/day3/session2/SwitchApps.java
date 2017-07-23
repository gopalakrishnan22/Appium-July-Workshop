package day3.session2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

public class SwitchApps {

	public static void main(String[] args) throws IOException  {

		// Capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G224ZNM");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("nativeWebScreenshot", "true");
		dc.setCapability("autoWebview", "true");

		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		System.out.println(driver.getContext());
		
		SessionId session = driver.getSessionId();
		System.out.println(session.toString());
		
		System.out.println(driver.currentActivity());
		
		// Take Snap
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./snaps/snap1.jpg"));
		
		// Click create account
		driver.findElementByLinkText("Create an Account").click();		
		
		DesiredCapabilities dc1 = new DesiredCapabilities();
		dc1.setCapability("deviceName", "ZX1G224ZNM");
		dc1.setCapability("browserName", "chrome");
		
		AndroidDriver<WebElement> driver1 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc1);
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// load the URL
		driver1.get("http://leaforg.com");
		
		// launch the app again
		AndroidDriver<WebElement> driver2 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		

				
	}

}
