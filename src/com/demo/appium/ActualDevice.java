package com.demo.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ActualDevice {

	@Test
	public void test() throws MalformedURLException{
		
		File appDir=new File("src");
		
		File app=new File(appDir,"redBus Plus_apkpure.com.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
//		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "name of App Package");
//		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "MainActivity");
		//Android Driver
		//IOS Driver
		
		AndroidDriver<WebElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		driver.findElementById("redbus.rbplus.android:id/user_name").sendKeys("chandubabu@gmail.com");
//		driver.findElementById("redbus.rbplus.android:id/password").sendKeys("chandu17");
//		driver.findElementById("redbus.rbplus.android:id/btn_login").click();
		
		driver.findElement(By.id("redbus.rbplus.android:id/user_name")).sendKeys("chandubabu@gmail.com");
		driver.findElement(By.id("redbus.rbplus.android:id/password")).sendKeys("chandu17");
		driver.findElement(By.id("redbus.rbplus.android:id/btn_login")).click();
	}
	
}
