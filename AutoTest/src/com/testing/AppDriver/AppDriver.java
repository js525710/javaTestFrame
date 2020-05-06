package com.testing.AppDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.testing.autolog.AutoLogger;

import io.appium.java_client.android.AndroidDriver;

public class AppDriver {
	public AndroidDriver driver = null;	
	public AppDriver(String deviceName,String platformVersion,String appPackage,String appActivity,String appiumServerIP,String waitTime) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//必要参数
		capabilities.setCapability("deviceName",deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("platformName", "Android");
		//可选参数
		capabilities.setCapability("noSign", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		//电脑连接多个设备的时候需要指定设备
		capabilities.setCapability("udid", deviceName);
		
		try {
			driver = new AndroidDriver<>(new URL(appiumServerIP),capabilities);
			int t=Integer.parseInt(waitTime);
			Thread.sleep(t*1000);
			AutoLogger.log.info("App正在启动中。。。");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("App启动失败，请检查配置！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
	}
	
	public AndroidDriver getdriver() {
		return this.driver;
	}
	
}
