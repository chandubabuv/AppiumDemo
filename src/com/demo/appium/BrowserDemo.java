package com.demo.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BrowserDemo {

	
	@Test
	public void test() throws MalformedURLException {

		try {
//			 File appDir = new File("src");
//			
//			 File app = new File(appDir,
//			 "LexisNexisLite-mapfreus-release-1.0.15.570.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			// cap.setCapability("fullReset", false);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");// "Android
																					// Emulator");
			
			//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
//			 cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			 //cap.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "300");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
			// Android Driver
			// IOS Driver

	
			AndroidDriver<WebElement> driver = new AndroidDriver<>(
					new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://google.com");
			System.out.println("Title: "+driver.getTitle());
			Thread.sleep(2000);
			driver.quit();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
