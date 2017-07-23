package day2.session3;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LearnNotifications {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "5489f632");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		 
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		// AndroidDriver Class Methods
		driver.openNotifications();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest =new File("./snaps/snap1.jpg");
		FileUtils.copyFile(src, dest);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
