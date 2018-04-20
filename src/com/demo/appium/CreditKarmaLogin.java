package com.demo.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class CreditKarmaLogin {

	AndroidDriver<WebElement> driver;
	@Test
	public void test() throws MalformedURLException {
		try {
			File appDir = new File("src");

			File app = new File(appDir, "com.creditkarma.mobile_4.1.2.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
					MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,
					"Android Emulator");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			//cap.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "300");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
			// Android Driver
			// IOS Driver

			 driver = new AndroidDriver<>(new URL(
					"http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElementById(
					"com.creditkarma.mobile:id/welcome_button_login").click();
			driver.findElementById("com.creditkarma.mobile:id/login_email")
					.sendKeys("chandubabu@gmail.com");
			driver.findElementById("com.creditkarma.mobile:id/login_password")
					.sendKeys("chandu17");
			driver.findElementById(
					"com.creditkarma.mobile:id/login_remember_me").click();
			driver.findElementByName("SIGN IN").click();
			System.out.println("Clicked Sign In");
			driver.findElementByName("4").click();
			driver.findElementByName("5").click();
			driver.findElementByName("0").click();
			driver.findElementByName("5").click();

			driver.findElementByName("4").click();
			driver.findElementByName("5").click();
			driver.findElementByName("0").click();
			driver.findElementByName("5").click();
			Thread.sleep(1000);
			if (driver.findElementByName("Credit Karma").isDisplayed()) {
				System.out.println("Page Title: " + driver.getTitle());
				String welcomeText = driver.findElementById(
						"com.creditkarma.mobile:id/intro").getText();
				if (welcomeText.equalsIgnoreCase("Welcome back, Chandubabu!")) {
					System.out.println("Home Page: " + welcomeText);
				}

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
			driver.quit();
		}

	}
}
