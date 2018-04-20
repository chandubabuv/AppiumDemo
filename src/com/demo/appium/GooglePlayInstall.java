package com.demo.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GooglePlayInstall {

	@Test
	public void test() throws MalformedURLException {
	try {
		File appDir = new File("src");

		File app = new File(appDir, "AnyConnect ICS  4.0.01381.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("noReset", true);
//		cap.setCapability("fullReset", false);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
				MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,
				"Android Emulator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//cap.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "300");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
		// Android Driver
		// IOS Driver

		AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		
	}catch(Exception e){
		
		e.printStackTrace();
	}
}
}
