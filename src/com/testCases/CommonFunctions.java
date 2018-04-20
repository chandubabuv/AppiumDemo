package com.testCases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CommonFunctions {

	
	public void toScrollDown(AndroidDriver<WebElement> driver, int scrollTimes){
		
		Dimension dimensions = driver.manage().window().getSize();
		 Double screenHeightStart = dimensions.getHeight() * 0.5;
		 int scrollStart = screenHeightStart.intValue();
//		 System.out.println("s=" + scrollStart);
		 Double screenHeightEnd = dimensions.getHeight() * 0.2;
		 int scrollEnd = screenHeightEnd.intValue();//dimensions.getHeight()
		 
		 for (int i = 0; i < scrollTimes; i++) {
			 driver.swipe(0,scrollStart,0,scrollEnd,1000);
			 }
	}
}
