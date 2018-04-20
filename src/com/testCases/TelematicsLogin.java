package com.testCases;

import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TelematicsLogin {
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
//			 cap.setCapability(MobileCapabilityType.APP,
//			 app.getAbsolutePath());
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

			System.out.println(driver.getContext());
			TimeUnit.SECONDS.sleep(5);
			common.toScrollDown(driver, 100);

			// while
			// (!driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").isEnabled())
			// {
			// common.toScrollDown(driver, 2);
			// }

			// //driver.findElementByAndroidUIAutomator("new UiScrollable(new
			// UiSelector()).scrollIntoView(descriptionMatches("+DESTINATION_ELEMENT_TEXT+"));");
			// driver.findElementByAndroidUIAutomator("new UiScrollable(new
			// UiSelector().scrollable(true)).scrollIntoView(new
			// UiSelector().text(\"Last updated: August 10, 2016\"));");

			// driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").click();

			// if (driver.findElementByXPath("//android.view.View[@text='I
			// AGREE']").isEnabled()) {
			driver.findElementById("com.mapfreusa.driveadvisor:id/fragment_disclaimer_agree").click();

			// driver.findElementByXPath("//android.view.View[@text='I
			// AGREE']").click();
			TimeUnit.SECONDS.sleep(5);
			// driver.findElementByAndroidUIAutomator("new UiScrollable(new
			// UiSelector().scrollable(true)).scrollIntoView(new
			// UiSelector().text(\"Click here to Login\"));");
			// common.toScrollDown(driver, 2);
			// driver.findElementByXPath("//android.view.View[contains(@content-desc,'Click
			// here to Login')]").click();
			// TimeUnit.SECONDS.sleep(2);
//			System.out.println(driver.getContext());
			
//			Set<String> s= driver.getContextHandles();
//			for(String handle:s){
//				System.out.println(handle);
//			}
//			driver.context("WEBVIEW_com.mapfreusa.driveadvisor");
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='1']/android.widget.EditText[@index='0']")
					.sendKeys("FirstName");
			driver.hideKeyboard();
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='1']/android.view.View[@index='1']/android.widget.EditText[@index='0']")
					.sendKeys("LastName");
			driver.hideKeyboard();
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='2']/android.widget.EditText[@index='1']")
					.sendKeys("abc@bbc.com");
			driver.hideKeyboard();
			
			driver.findElementByXPath("//android.widget.Spinner[@index='0']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.widget.CheckedTextView[@text='04']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.widget.Spinner[@index='0']").sendKeys("\n");
			//new Actions(driver).moveToElement(driver.findElementByXPath("//android.widget.Spinner[@index='1']")).click().perform();
			driver.findElementByXPath("//android.widget.Spinner[@index='1']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.widget.CheckedTextView[@text='03']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.widget.Spinner[@index='1']").sendKeys("\n");
			//new Actions(driver).moveToElement(driver.findElementByXPath("//android.widget.Spinner[@index='2']")).click().perform();
			driver.findElementByXPath("//android.widget.Spinner[@index='2']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.widget.CheckedTextView[@text='1997']").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//android.widget.Spinner[@index='2']").sendKeys("\n");
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='4']/android.view.View[@index='1']/android.widget.EditText[@index='0']")
					.sendKeys("Password123");
			driver.hideKeyboard();
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='5']/android.view.View[@index='1']/android.widget.EditText[@index='0']")
					.sendKeys("Password123");
			driver.hideKeyboard();
			common.toScrollDown(driver, 1);
			driver.findElementByXPath(
					"//android.view.View[@index='2']/android.view.View[@index='0']/android.view.View[@index='6']/android.view.View[@index='1']/android.widget.EditText[@index='0']")
					.sendKeys("LeaderBoardAlias");
			driver.hideKeyboard();
			// driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Submit')]").click();

			// List<WebElement> ls =
			// driver.findElementsByClassName("android.widget.EditText");
			// ls.get(0).sendKeys("mapfre_a05@mail.com");
			// ls.get(1).sendKeys("Test1234");
			// driver.findElementByXPath("//android.widget.Button[@content-desc='Log
			// In']").click();
			// TimeUnit.SECONDS.sleep(5);

			TimeUnit.SECONDS.sleep(2);
			driver.quit();
			// driver.findElementByXPath("//android.widget.EditText[@index='2']").sendKeys("Email");

			// }

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
