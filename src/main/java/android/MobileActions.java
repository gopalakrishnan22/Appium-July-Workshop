package android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<?> driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "071c47a40b3fa1f4");
		capabilities.setCapability("appPackage","com.the511plus.MultiTouchTester");
		capabilities.setCapability("appActivity",".MultiTouchTester");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

		// Lets find the window size
		Dimension size = driver.manage().window().getSize();
		System.out.println("Size of the mobile window is: "+size);

		// Lets store the 4 corner x y axis
		int x1 =(int) (size.getWidth()*0.2);
		int y1 =(int) (size.getHeight()*0.2);

		int x2 =(int) (size.getWidth()*0.8);
		int y2 =(int) (size.getHeight()*0.2);

		int x3 =(int) (size.getWidth()*0.2);
		int y3 =(int) (size.getHeight()*0.8);

		int x4 =(int) (size.getWidth()*0.8);
		int y4 =(int) (size.getHeight()*0.8);

		int x5 =(int) (size.getWidth()/2);
		int y5 =(int) (size.getHeight()/2);	


		// Multi touch action
		TouchAction touch= new TouchAction(driver);

		// Press on center
		//touch.press(x5, y5).waitAction(2000).release().perform();


		// Long Press		
		//touch.longPress(driver.findElementById("com.the511plus.MultiTouchTester:id/points"),x5, y5,5000).perform();

		// Move To
		//touch.longPress(driver.findElementById("com.the511plus.MultiTouchTester:id/points")).moveTo(x1, y1).release().perform();


		// Swipe
		//driver.swipe(x5, y5, x1, y1, 2000);
		
		// Pinch
//		driver.pinch(driver.findElementById("com.the511plus.MultiTouchTester:id/points"));
		
		// Zoom
		//driver.zoom(driver.findElementById("com.the511plus.MultiTouchTester:id/points"));

		// Tap
		//driver.tap(1, driver.findElementById("com.the511plus.MultiTouchTester:id/points"), 3000);
		
		//	driver.navigate().back();

		//driver.pressKeyCode(4);
		
		//driver.pressKeyCode(3);
		
		//Network
//		System.out.println(driver.getNetworkConnection());
//		
//		NetworkConnectionSetting nc = new NetworkConnectionSetting(2);
//		driver.setNetworkConnection(nc);
//		
//		System.out.println(driver.getNetworkConnection());
		
//		driver.openNotifications();
//		
//		System.out.println(driver.isLocked());
//		
//		driver.lockScreen(2);
//		Thread.sleep(3000);
//				
//		System.out.println(driver.isLocked());
		
		
		
		driver.startActivity(" com.google.android.music", "com.android.music.activitymanagement.TopLevelActivity");
		
//		System.out.println(driver.getOrientation());
//		
//		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		Thread.sleep(5000);

		driver.findElementById("com.google.android.music:id/header_more").click();
		Thread.sleep(3000);
		driver.scrollTo("thi");
		
		driver.navigate().back();
		
		driver.findElementById("com.google.android.music:id/search").click();
		
		Thread.sleep(3000);
		
		driver.hideKeyboard();
		
		System.out.println(driver.location());


	}

}
