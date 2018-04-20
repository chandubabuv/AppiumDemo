package com.testCases;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TLogin {

	CommonFunctions common = new CommonFunctions();

	@Test
	public void getLogin() {

		try {
			File appDir = new File("src");

			File app = new File(appDir, "LexisNexisLite-mapfreus-debug-1.0.17.609.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			// cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");// "Android
																					// Emulator");
			// cap.setCapability(MobileCapabilityType.APP,
			// app.getAbsolutePath());
			// cap.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "300");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
			// Android Driver
			// IOS Driver

			cap.setCapability("appPackage", "com.mapfreusa.driveadvisor");
			cap.setCapability("appActivity",
					"com.lexisnexis.risk.mobile.telematics.driver.activities.launchers.MapfreUsLauncher");

			AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			System.out.println(driver.getContext());
			TimeUnit.SECONDS.sleep(5);

			// while
			// (!driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").isEnabled())
			// {
			// common.toScrollDown(driver, 2);
			// }
			if(!driver.findElements(By.id("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree")).isEmpty()) {
				if (!driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").isEnabled()) {

					common.toScrollDown(driver, 100);
					driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").click();
					TimeUnit.SECONDS.sleep(5);
				}
			}

			common.toScrollDown(driver, 1);
			driver.context("WEBVIEW_com.mapfreusa.driveadvisor");
			// driver.findElementByXPath("//android.view.View[@content-desc='Click
			// here to Login']").click();

			// driver.findElementByXPath(
			// "//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='8']/android.view.View[@index='1']").click();

			driver.findElement(By.xpath("//a[contains(.,'Click here to Login')]")).click();

			TimeUnit.SECONDS.sleep(2);

			driver.context("NATIVE_APP");
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='1']/android.widget.EditText[@index='0']")
					.sendKeys("mapfre_a05@mail.com");
			driver.hideKeyboard();
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='3']/android.widget.EditText[@index='0']")
					.sendKeys("Test1234");
			driver.hideKeyboard();

			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='4']/android.widget.Button[@index='0']")
					.click();

			TimeUnit.SECONDS.sleep(5);
			
			//DashBoard
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(2);

//			driver.findElementByXPath(
//					"//android.view.View[@index='0']/android.view.View[@index='3']/android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='1']")
//					.click();
			
			driver.findElementByXPath("//android.view.View[@content-desc='Dashboard']").click();
			TimeUnit.SECONDS.sleep(2);
			
			//Overall Score
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);

			driver.findElementByXPath("//android.view.View[@content-desc='Overall Score']").click();
			TimeUnit.SECONDS.sleep(2);
			
			//News Feed
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);

			driver.findElementByXPath("//android.view.View[@content-desc='News Feed']").click();
			TimeUnit.SECONDS.sleep(3);
			
			//Trips
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);
	
			driver.findElementByXPath("//android.view.View[@content-desc='Trips']").click();
			TimeUnit.SECONDS.sleep(2);
			
			//Achievements
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);
			
			driver.findElementByXPath("//android.view.View[@content-desc='Achievements']").click();
			TimeUnit.SECONDS.sleep(2);

			
			//Leaderboard
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);
	
			driver.findElementByXPath("//android.view.View[@content-desc='Leaderboard']").click();
			TimeUnit.SECONDS.sleep(2);
				
			//Profile
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);

			driver.findElementByXPath("//android.view.View[@content-desc='Profile']").click();
			TimeUnit.SECONDS.sleep(2);
			
			
			//FAQs
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.view.View[@content-desc='FAQ']").click();
			TimeUnit.SECONDS.sleep(2);
			
			
			//Settings	
			driver.findElementByXPath("//android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.view.View[@content-desc='Settings']").click();
			TimeUnit.SECONDS.sleep(2);
			common.toScrollDown(driver, 1);
			driver.findElementByXPath("//android.widget.TextView[@text='Logout']").click();
			TimeUnit.SECONDS.sleep(2);
			driver.findElementByXPath("//android.widget.TextView[@text='Yes']").click();
			TimeUnit.SECONDS.sleep(5);
			driver.quit();
			// driver.findElementByXPath("//android.widget.EditText[@index='2']").sendKeys("Email");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
