package com.adept.findjob.mytest;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AppTest {
	public AppiumDriver driver=null;
	@Test
    public void Saucetest() throws MalformedURLException, InterruptedException
{

		
	
	DesiredCapabilities caps = DesiredCapabilities.ipad();
	caps.setCapability("browserName", "");
	caps.setCapability("platformVersion", "7.1");
	caps.setCapability("appium-version", "1.0");
	caps.setCapability("platformName", "iOS");
	caps.setCapability("deviceName", "iPad Simulator");
	caps.setCapability("name", "Findjob_Login");

	
	
	
	caps.setCapability("app","sauce-storage:Findjob.zip");
	driver = new AppiumDriver(
				  new URL("http://satish_sauce:6ff1b2d2-05f8-4013-9fb8-80aea16b5b62@ondemand.saucelabs.com:80/wd/hub"),
				  caps);
	Thread.sleep(8000);
	
	login();

}
	public void login()
	{
		driver.rotate(ScreenOrientation.LANDSCAPE);

	driver.findElement(By.className("UIATextField")).sendKeys("findjob@apple.com");	
	driver.findElement(By.name("Hide keyboard")).click();
	driver.findElement(By.className("UIASecureTextField")).sendKeys("findjob");
	driver.findElement(By.name("Hide keyboard")).click();
	driver.findElement(By.name("Login")).click();
	}
	@AfterTest 
	public void killdriver()
	{
		driver.quit();
		
	}
}