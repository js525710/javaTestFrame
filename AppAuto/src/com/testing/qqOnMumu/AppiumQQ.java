package com.testing.qqOnMumu;

public class AppiumQQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//必要参数
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("platformName", "Android");
		//可选参数
		capabilities.setCapability("noSign", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		//电脑连接了多个设备的时候，指定设备。
		capabilities.setCapability("udid", deviceName);
		

	}

}
