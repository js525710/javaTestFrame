package com.testing.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GoogleDriver {
	//定义成员变量driver
	private WebDriver driver = null;
	//构造方法,在类初始化为对象的时候加载
	public GoogleDriver(String driverpath) {
		//设置driver的路径
		System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions option = new ChromeOptions();
		//去除Chrome浏览器上的信息栏
		option.addArguments("--disable-infobars");
		//加载chrome用户文件
		option.addArguments("--user-data-dir=C:\\Users\\jinshan.sandy\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		//最大化浏览器窗口
		option.addArguments("--start-maximized");	
		//创建一个 ChromeDriver 的接口，用于连接 Chrome
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, option);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability(CapabilityType.VERSION, "");
//		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");	
		try {
			this.driver = new ChromeDriver(option);
			//默认打开空白页
			driver.get("about:blank");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("创建driver失败！！");
		}
	}
	//定义方法返回driver
	public WebDriver getdriver() {
		return this.driver;
	}
}
