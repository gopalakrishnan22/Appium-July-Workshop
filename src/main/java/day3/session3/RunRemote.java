package day3.session3;

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

public class RunRemote {

	public static void main(String[] args) throws IOException  {

		// Capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G224ZNM");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("nativeWebScreenshot", "true");
		dc.setCapability("autoWebview", "true");
		dc.setCapability("testobject_api_key", "1384D88A1472417DA36DD3AC2139D8FA");
		dc.setCapability("testobject_device", "LG_Nexus_5X_free");
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("https://eu1.appium.testobject.com/wd/hub"),dc);
		System.out.println(driver.getContext());
		
			
		// Take Snap
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./snaps/snap1.jpg"));
		
			
		// Click create account
		driver.findElementByLinkText("Create an Account").click();		
		
		
		

				
	}

}
