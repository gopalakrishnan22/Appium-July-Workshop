package week4.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ReadEmail {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.google.android.gm");
		dc.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
		dc.setCapability("deviceName", "ZX1G22RC88");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

		// Click Got it
		driver.findElementById("com.google.android.gm:id/welcome_tour_got_it").click();

		// Take me to Gmail
		driver.findElementById("com.google.android.gm:id/action_done").click();

		// Know the first email
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Primary']")));
		System.out.println("I am done");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Double tap to select this conversation']")));
		System.out.println("I am done");


		// Get the first mail
		List<WebElement> allEmails = driver.findElementsByClassName("android.view.View");
		WebElement firstMail = allEmails.get(0);
		System.out.println("first email "+ firstMail.getAttribute("text"));

		TouchAction touch = new TouchAction(driver);
		// Tap on the first email and confirm the email is open
		touch.tap(firstMail).perform();

		String currentActivity = driver.currentActivity();
		System.out.println(currentActivity);



		// Get back to LeafOrg
		Activity multi = new Activity("com.the511plus.MultiTouchTester", "com.the511plus.MultiTouchTester.MultiTouchTester");
		driver.startActivity(multi);

		// Find one of the element
		WebElement points = driver.findElementById("com.the511plus.MultiTouchTester:id/points");

		TouchAction action = new TouchAction(driver);
		action.press(points).perform();


		// come back to gmail
		Activity gmail = new Activity("com.google.android.gm", currentActivity);
		driver.startActivity(gmail);

	}
}



