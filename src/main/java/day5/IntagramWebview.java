package day5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class IntagramWebview {

	AndroidDriver<?> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", "com.instagram.android");
		capabilities.setCapability("appActivity", "com.instagram.android.activity.MainTabActivity");
		//		capabilities.setCapability("appActivity", "com.instagram.android/.nux.SignedOutFragmentActivity");
		capabilities.setCapability("deviceName", "071c47a40b3fa1f4");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}

	@Test
	public void Instgram() throws InterruptedException, IOException{


		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
		}
		driver.findElement(By.id("com.instagram.android:id/log_in")).click();

		driver.findElement(By.id("com.instagram.android:id/login_username")).sendKeys("appium.testleaf");		

		driver.findElement(By.id("com.instagram.android:id/login_password")).sendKeys("appium@123");

		driver.findElement(By.id("com.instagram.android:id/next_button")).click();
		Thread.sleep(5000);

		driver.findElementByXPath("//android.widget.FrameLayout[contains(@content-desc,'Profile')]").click();
		Thread.sleep(5000);

		driver.findElementByXPath("//android.widget.ImageView[contains(@content-desc,'Options')]").click();
		Thread.sleep(5000);

		driver.scrollTo("Log Out");
		Thread.sleep(5000);

		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Log Out')]").click();
		Thread.sleep(5000);


		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	//		}
	//	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
