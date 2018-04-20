package com.demo.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class CreditKarmaSignUp {

	@Test
	public void test() throws MalformedURLException {

		File appDir = new File("src");

		File app = new File(appDir, "com.creditkarma.mobile_4.1.2.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		// cap.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT,"300");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
		// Android Driver
		// IOS Driver

		AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementById("com.creditkarma.mobile:id/welcome_button_signup").click();
		driver.findElementByName("First name").sendKeys("Tester");
		driver.findElementByName("Next").click();
		driver.findElementByName("Last name").sendKeys("Auto");
		driver.findElementByName("Next").click();
		driver.findElementByName("Email address").sendKeys("Tester@test.com");
		driver.findElementByName("Next").click();
		driver.findElementById("com.creditkarma.mobile:id/edit_text").sendKeys("Test1234");

		driver.findElementByName("Next").click();
		driver.findElementByName("NO").click();

		driver.findElementByName("Next").click();

		// driver.findElementByName("redbus.rbplus.android:id/user_name").sendKeys("chandubabu@gmail.com");
		// driver.findElementByName("redbus.rbplus.android:id/password").sendKeys("chandu17");
		// driver.findElementByName("redbus.rbplus.android:id/btn_login").click();

	}
}
