package week4.day1;

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

public class LeafOrg {

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
		
		SessionId session = driver.getSessionId();
		System.out.println(session.toString());
		
		System.out.println(driver.currentActivity());
		
		// Take Snap
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./snaps/snap1.jpg"));
		
	/*	// Get all handles
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
			if(context.contains("WEBVIEW"))
				driver.context(context);
		}*/
		
		// Click create account
		driver.findElementByLinkText("Create an Account").click();		
		
		// close the app
		//driver.close();
		
		/*DesiredCapabilities dc1 = new DesiredCapabilities();
		dc1.setCapability("deviceName", "ZX1G224ZNM");
		dc1.setCapability("browserName", "chrome");
		
		AndroidDriver<WebElement> driver1 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc1);
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// load the URL
		driver1.get("http://leaforg.com");
		
		
				
		// close the browser
		//driver.close();
		
		Activity act = new Activity("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
		
		driver.startActivity(act);
*/
		

				
	}

}
