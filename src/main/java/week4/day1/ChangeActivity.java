package week4.day1;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeActivity {


	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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

		// Click create account
		driver.findElementByLinkText("Create an Account").click();	

		String currentActivity = driver.currentActivity();
		System.out.println(currentActivity);

		// Go to Gmail
		Activity gmail = new Activity("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail");
		driver.startActivity(gmail);

		// Click Got it
		Thread.sleep(10000);

		List<WebElement> allEmails = driver.findElementsByClassName("android.view.View");
		System.out.println(allEmails.size());


		// Get back to LeafOrg
		Activity leaf = new Activity("com.testleaf.leaforg", currentActivity);
		driver.startActivity(leaf);




	}


}
