package day3;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class CallTestLeaf {

	public static void main(String[] args) throws IOException {
		AndroidDriver<WebElement> driver;
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("appPackage", "com.google.android.dialer");
		dc.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		dc.setCapability("deviceName", "071c47a40b3fa1f4");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.findElementById("com.android.dialer:id/search_box_start_search").click();
		
		driver.findElementById("com.android.dialer:id/search_view").sendKeys("Testleaf");
		
		File src =driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snaps/dialer.jpeg"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.dialer:id/cliv_name_textview")));
		ele.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
