package android;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class CallPhone {

	public static void main(String[] args) throws IOException {

		AndroidDriver driver;
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G22RC88");
		dc.setCapability("appPackage", "com.google.android.dialer");
		dc.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");

		// pointing to the local appium server
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		// click on search icon
		driver.findElement(By.id("com.android.dialer:id/search_box_start_search")).click();
		
		// Enter the contact name
		driver.findElement(By.id("com.android.dialer:id/search_view")).sendKeys("Testleaf"); 		
		
		// Find how many search results
		List<WebElement> ele = driver.findElements(By.id("com.android.dialer:id/cliv_name_textview"));
		ele.get(0).click();
		
		// Take snap
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snaps/dial.jpg"));
		
		// Click end button
		driver.findElementById("com.android.dialer:id/floating_end_call_action_button").click();
		
		
		
	}

}
