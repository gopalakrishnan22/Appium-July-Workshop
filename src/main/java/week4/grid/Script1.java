package week4.grid;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

public class Script1 {

	@Test
	public void script1() throws IOException  {
		
		// Capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G224ZNM");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("nativeWebScreenshot", "true");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://192.168.0.115:4444/wd/hub"),dc);
		System.out.println(driver.getContext());
		
		// Get all handles
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
			if(context.contains("WEBVIEW"))
				driver.context(context);
		}
		
		// Click create account
		driver.findElementByLinkText("Create an Account").click();		
		
		driver.findElementByXPath("//input[@formcontrolname='phone']").click();

		if(driver.isKeyboardShown()){
			driver.hideKeyboard();
		}
		

				
	}

}
