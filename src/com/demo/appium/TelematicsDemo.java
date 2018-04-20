package com.demo.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TelematicsDemo {

	@Test
	public void test() throws MalformedURLException {

		try {
			// File appDir = new File("src");
			//
			// File app = new File(appDir,
			// "LexisNexisLite-mapfreus-release-1.0.15.570.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			// cap.setCapability("fullReset", false);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");// "Android
																					// Emulator");
			// cap.setCapability(MobileCapabilityType.APP,
			// app.getAbsolutePath());
			// cap.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "300");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
			// Android Driver
			// IOS Driver

			// File classpathRoot = new File(System.getProperty("user.dir"));
			// File appDir = new File(classpathRoot, "../../../data/app/");
			// File app = new File(appDir, "Facebook.apk");
			// DesiredCapabilities capabilities = new DesiredCapabilities();
			// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			// capabilities.setCapability("deviceName","Android Emulator");
			// capabilities.setCapability("platformVersion", "4.4");
			// capabilities.setCapability("platformName","Android");
			// capabilities.setCapability("app", app.getCanonicalPath());

			cap.setCapability("appPackage", "com.mapfreusa.driveadvisor");
			cap.setCapability("appActivity",
					"com.lexisnexis.risk.mobile.telematics.driver.activities.launchers.MapfreUsLauncher");

			AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// TimeUnit.SECONDS.sleep(5);
			// String s=driver.getContext();
			//
			// System.out.println("context: "+s);
			TimeUnit.SECONDS.sleep(10);
			// driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_webview");
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			System.out.println("s=" + scrollStart);
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();// dimensions.getHeight()

			for (int i = 0; i < 90; i++) {
				driver.swipe(0, scrollStart, 0, scrollEnd, 1000);
			}
			while (!driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").isEnabled()) {
				driver.swipe(0, scrollStart, 0, scrollEnd, 1000);
			}

			// //driver.findElementByAndroidUIAutomator("new UiScrollable(new
			// UiSelector()).scrollIntoView(descriptionMatches("+DESTINATION_ELEMENT_TEXT+"));");
			// driver.findElementByAndroidUIAutomator("new UiScrollable(new
			// UiSelector().scrollable(true)).scrollIntoView(new
			// UiSelector().text(\"Last updated: August 10, 2016\"));");

			// driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").click();

			if (driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").isEnabled()) {
				driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").click();
				List<WebElement> ls = driver.findElementsByClassName("android.widget.EditText");
				ls.get(0).sendKeys("firstName");
				ls.get(1).sendKeys("LastName");
				ls.get(2).sendKeys("abc@email.com");
				// driver.findElementByXPath("//android.widget.EditText[@index='0']").sendKeys("FirstName");
				// driver.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("LastName");
				// driver.findElementByXPath("//android.widget.EditText[@index='2']").sendKeys("Email");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
