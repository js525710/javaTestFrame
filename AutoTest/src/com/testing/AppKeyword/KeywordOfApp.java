package com.testing.AppKeyword;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.AppDriver.AppDriver;
import com.testing.autolog.AutoLogger;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class KeywordOfApp {
	public AndroidDriver driver;
	//构造方法
	public KeywordOfApp() {
		
	}
    
	//强制等待
	public void wait(String waitTime) {
		int t = Integer.parseInt(waitTime);
		try {
			Thread.sleep(t*1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    //脚本执行cmd命令
	public void runCmd(String str) {
		String cmd ="cmd /c start "+ str;
		Runtime runtime = Runtime.getRuntime();
		try {
			AutoLogger.log.info("执行cmd命令:  "+str);
			runtime.exec(cmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
			AutoLogger.log.error("cmd命令执行失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
		
	}

	//通过cmd执行启动appium的服务
	public void StartAppium(String port,String time) {
		//启动appium的 服务端
		AutoLogger.log.info("启动appium server服务");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
		//当前时间的字符串
		String createdate = sdf.format(date);
		//生成日志文件
		String appiumLogFile = "log/"+createdate + "AppiumLog.txt";
		
		String startAppiumCMD = "appium -a 127.0.0.1 -p "+ port +" --log " +appiumLogFile +" --local-timezone --log-timestamp";
		runCmd(startAppiumCMD);
		
		try {
			int t = Integer.parseInt(time);
			Thread.sleep(t*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//启动被测App
	public void StartApp(String deviceName,String platformVersion,String appPackage,String appActivity,String appiumServerIP,String waitTime) {
		try {
			AutoLogger.log.info("启动待测App!");
			AppDriver app = new AppDriver(deviceName, platformVersion, appPackage, appActivity, appiumServerIP, waitTime);
			driver = app.getdriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error("启动待测app失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
		
	}

	
	//input方法
	public void input(String xpath,String text) {
		try {
			explicityWait(xpath);
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(text);
			AutoLogger.log.info("向"+xpath+"元素中输入了： "+text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error(e,e.fillInStackTrace());
			saveScrShot("click");
		}
	}
	
	
	//input方法not clear
	public void inputAdd(String xpath,String text) {
		try {
			explicityWait(xpath);
//			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(text);
			AutoLogger.log.info("向"+xpath+"元素中输入了： "+text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error(e,e.fillInStackTrace());
			saveScrShot("click");
		}
	}
	
	//click操作
	public void click(String xpath) {
		try {
			explicityWait(xpath);
			driver.findElement(By.xpath(xpath)).click();
			AutoLogger.log.info(xpath+"元素进行点击");
		} catch (Exception e) {
			AutoLogger.log.error(e, e.fillInStackTrace());
			saveScrShot("click");
		}
	}
	
	//调用adb滑动
	public void adbSwipe(int i,int j,int k,int l,int m) {
		//adb shell input swipe i j k l m
		try {
			this.runCmd("adb shell input swipe " + i + " " + j + " " + k + " " + l + " " + m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("通过adb执行滑动失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
	}
	
	//调用adb模拟按键
	public void adbPressKey(String keycode) {
		
		try {
			int k = Integer.parseInt(keycode);
			String cmd = " adb shell input keyevent "+ k;
			runCmd(cmd);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("通过adb执行按键事件失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
	}
	
	//adb调用输入法
		public void sougouInput() {
			try {
				//adb shell ime list -s  查看输入法
				String cmd = "adb shell ime set com.sohu.inputmethod.sogou/.SogouIME"; 
				runCmd(cmd);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				AutoLogger.log.error("通过adb调用搜狗输入法失败");
				AutoLogger.log.error(e,e.fillInStackTrace());
			}
		}
		

	public void adbTap(String xAxis, String yAxis) {
		try {
			int x = Integer.parseInt(xAxis);
			int y = Integer.parseInt(yAxis);
			runCmd("adb shell input tap " + x + " " + y);
		} catch (Exception e) {
			AutoLogger.log.error("通过adb执行点击失败");
			AutoLogger.log.error(e, e.fillInStackTrace());
		}
	}

	//关闭app
	public void quitApp() {
		try {
			driver.closeApp();
		} catch (Exception e) {
			AutoLogger.log.error("关闭app失败");
			AutoLogger.log.error(e, e.fillInStackTrace());
		}
	}
	
	//关闭appium
	public void killAppium() {
		try {
			runCmd("taskkill /F /IM node.exe");
		} catch (Exception e) {
			AutoLogger.log.error("关闭appiumserver服务失败");
			AutoLogger.log.error(e, e.fillInStackTrace());
		}
	}

	//断言是否相等
	public void assertSame(String xpath,String paramRes) {
		try {
			explicityWait(xpath);
			String result = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(result);
			if (result.equals(paramRes)) {
				AutoLogger.log.info("断言成功，文本等于目标内容！");
			}else {
				AutoLogger.log.info("断言不相等，文本不等于目标内容！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("执行断言时报错！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
	}
	
	
	
	
	//断言是否包含内容
	public void assertContains(String xpath,String paramRes) {
		try {
			explicityWait(xpath);
			String result = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(result);
			if (result.contains(paramRes)) {
				AutoLogger.log.info("断言成功，文本包含目标内容！");
			}else {
				AutoLogger.log.info("断言失败，文本不包含目标内容！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("执行断言时失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
	}
	
	//判断登录与否
	public String assertLoginOrNot(String xpath,String expectContent) {
		explicityWait(xpath);
		String context = driver.findElement(By.xpath(xpath)).getText();
		String  result = null;
		System.out.println(context);
		if (context.equals(expectContent)) {
		   	result = "isLogin";	
		}else if (context.contains("昵称") || context.contains("请登录")){
			result = "noLogin";
		}else {	
			result = "otherLogin";
		}
		return result;
		
	}
	
	
	//通过appium的方法进行滑动屏幕
	public void appiumSwipe(String iniX,String iniY,String finX,String finY) {
		try {
			int x = Integer.parseInt(iniX);
			int y = Integer.parseInt(iniY);
			int x1 = Integer.parseInt(finX);
			int y1 = Integer.parseInt(finY);
			TouchAction action = new TouchAction(driver);
			PointOption pressPoint =  PointOption.point(x, y);
			PointOption movePoint  = PointOption.point(x1, y1);
			action.longPress(pressPoint).moveTo(movePoint).release().perform();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("执行Appium滑动方法失败！");
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
		
		
	}
	
	//通过appium的方法点击鼠标
	public void  appiumTap(String x,String y) {
		try {
			int xAxis = Integer.parseInt(x);
			int yAxis = Integer.parseInt(y);
			TouchAction action = new TouchAction(driver);
			PointOption pressPoint = PointOption.point(xAxis, yAxis);
			action.tap(pressPoint).release().perform();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error("执行Appium点击坐标方法失败");
			AutoLogger.log.error(e, e.fillInStackTrace());
		}
	}
	
	//使用appium方法长按
	public void appiumHold(String x,String y,String time) {
		try {
			int xAxis = Integer.parseInt(x);
			int yAxis = Integer.parseInt(y);
			int t = Integer.parseInt(time);
			PointOption pressPoint = PointOption.point(xAxis, yAxis);
			Duration last = Duration.ofSeconds(t);
			TouchAction action = new TouchAction(driver);
			action.longPress(pressPoint).waitAction(WaitOptions.waitOptions(last)).perform();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error("执行Appium滑动方法失败");
			AutoLogger.log.error(e, e.fillInStackTrace());
		}
	}

	//长按页面上的某一个元素
	public void appiumHoldEl(String xpath,String time) {
	    try {
			int t = Integer.parseInt(time);
			Duration last = Duration.ofSeconds(t);
			TouchAction action = new TouchAction(driver);
			action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElementByXPath(xpath))).withDuration(last)).waitAction(WaitOptions.waitOptions(last)).perform();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error("执行Appium长按方法失败");
			AutoLogger.log.error(e, e.fillInStackTrace());
		}
	
	}
	
	
	//显示等待,在每次定位元素时，会先尝试找元素，给10s的最长等待时间
	public void explicityWait(String xpath) {
		try {
			WebDriverWait eWait = new WebDriverWait(driver, 10);
			eWait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath(xpath));
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
		
	}
	
	//隐式等待
	public void implicitlyWait() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
	}
	
	public String returnContext(String xpath) {
		explicityWait(xpath);
		String context = driver.findElement(By.xpath(xpath)).getText();
		System.out.println("文本内容是："+context);
		return context;
	}
	
	public void printContexts() {
		Set<String> contexts=driver.getContextHandles();
		for(String s:contexts) {
			System.out.println(s);
		}
	}

	public void switchContext(String contextName) {
		try {
			AutoLogger.log.info("切换到"+contextName+"context");
			driver.context(contextName);
		} catch (Exception e) {
			AutoLogger.log.error("切换context失败。");
		}
	}
	
	//保存截图
	public void saveScrShot(String method) {
		// 获取当前的执行时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
		// 当前时间的字符串
		String createdate = sdf.format(date);
		// 拼接文件名，形式为：工作目录路径+方法名+执行时间.png
		String scrName = "SCRshot/" + method + createdate + ".png";
		// 以当前文件名创建文件
		File scrShot = new File(scrName);
		// 将截图保存到临时文件
		File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tmp, scrShot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error(e,e.fillInStackTrace());
			AutoLogger.log.error("截图失败！");
		}
	}
	
	
	

}
