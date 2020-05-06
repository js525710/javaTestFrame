package com.testing.keyword;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.autologger.AutoLogger;
import com.testing.webdriver.FFDriver;
import com.testing.webdriver.GoogleDriver;
import com.testing.webdriver.IEDriver;


public class KeywordofWeb {
	//成员变量
	public WebDriver driver=null;
	//构造方法
	public KeywordofWeb() {
		
	}
	
	/**
	 * 
	 * @param browserType
	 */
	public void openBrowser(String browserType) {
		try {
			switch (browserType) {
			case "Chrome":
				GoogleDriver gg = new GoogleDriver("./drivers/chromedriver.exe");
				driver = gg.getdriver();
				invisibleWait();
				AutoLogger.log.info("chrome浏览器启动");
				break;
			case "Firefox":
				FFDriver ff=new FFDriver("", "./drivers/geckodriver.exe");
				driver = ff.getdriver();
				break;
			case "IE":
				IEDriver ie = new IEDriver("./drivers/IEDriver.exe");
				break;
			default:
				GoogleDriver chrome = new GoogleDriver("./drivers/chromedriver.exe");
				driver = chrome.getdriver();
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param url 访问网站的url
	 */
	public void visitWeb(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			AutoLogger.log.info("访问url失败");
		}
	}
	
	/** 
	 * @param name  根据输入框的名字实现定位
	 * @param content  在输入框中输入内容
	 */
	public void inputByName(String name,String content) {
		try {
			WebElement element =driver.findElement(By.name(name));
			element.clear();
			element.sendKeys(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			saveScrshot("inputByName");
		}
	}
	
	/**
	 * @param Xpath 根据xpath定位实现click的操作
	 */
	public void click(String Xpath) {
		try {
			driver.findElement(By.xpath(Xpath)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			saveScrshot("click");
		}
	}
	
	/** 
	 * @return
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	/**
	 *  显示等待
	 * @param Xpath
	 */
	public void visibleWait(String Xpath) {
		WebDriverWait eWait = new WebDriverWait(driver, 10);
		eWait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				WebElement ele = d.findElement(By.xpath(Xpath));
				return ele;
			}
		});
		
	}
	//隐式等待
	public void invisibleWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//强制等待
	public void halt(String waitTime) {
		try {
			int time=0;
			time = Integer.parseInt(waitTime);
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	  public void closeBrowser() {
		  try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	 
	  
	  public void assertTitle(String expect) {
		  try {
			String title=getTitle();
			  if (title.contains(expect)) {
				  System.out.println("断言title测试成功");
			  }else {
				  System.out.println("断言title测试失败");
				  
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error(e,e.fillInStackTrace());
		}
		  
	  }
	  
	  //通过xpath定位并输入
	  public void input(String Xpath,String content) {
		  try {
			driver.findElement(By.xpath(Xpath)).clear();
			driver.findElement(By.xpath(Xpath)).sendKeys(content);
			AutoLogger.log.info("向"+Xpath+"元素中输入： "+content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AutoLogger.log.error(e,e.fillInStackTrace());
			saveScrshot("input");
		}  
	  }
	  
	  //不指定定位方式
	  public void inputLocator(By by,String content) {
		  driver.findElement(by).clear();
		  driver.findElement(by).sendKeys(content);
	  }
	  
	  public void assertElentTextIs(String Xpath,String expect) {
		  String text = driver.findElement(By.xpath(Xpath)).getText();
		  String attr = driver.findElement(By.xpath(Xpath)).getAttribute("href");
		  System.out.println("text:"+text);
		  System.out.println("href的属性是："+attr);
		  if(text.equals(expect)) {
			  System.out.println("验证元素的文本是否符合预期测试成功");
		  }else {
			  System.out.println("炎症元素的文本是都符合预期测试失败");
		  }
	  }
	  
	  public void MultiElementText(String Xpath) {
		  List<WebElement> list1 = driver.findElements(By.xpath(Xpath));
		  for(WebElement ele:list1) {
			  System.out.println(ele.getText());
		  }
	  }
	
	 /**
	  * 根据xpath进入iframe
	  * @param Xpath
	  */
	  public void IntoIframe(String Xpath) {
		  try {
			WebElement frame  = driver.findElement(By.xpath(Xpath));
			driver.switchTo().frame(frame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("进入iframe页面失败");
			saveScrshot("IntoIframe");
		}
	  }
	  
	  /**
	   * 根据name切入iframe中
	   * @param name
	   */
	  public void IntoIframeByName(String name) {
		  try {
			driver.switchTo().frame(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
		}
		  
	  }
	  
	  /**
	   * 获取js运行结果
	   * @param text
	   * @return
	   */
	  public String getJs(String text) {
		  String t = "";
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  try {
			t = js.executeScript("return "+text).toString();
		  } catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			  System.out.println("Js脚本执行失败！");
		  }
		  return t;	  
	  }

	  public void outIframe() {
		  try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("切回主页面失败");
		}
		  
	  }
	  
	  
	  public void runJs(String text) {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  try {
			js.executeScript(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("js脚本执行失败！");
		}
	  }
	  
	  /**
	   * 操作浏览器进度条进行滚动
	   */
	  public void scrollWindowStraight(String height) {
		  JavascriptExecutor js =(JavascriptExecutor) driver;
		  try {
			String jsCmd = "window.scrollTo(0," + height + ")";
			  js.executeScript(jsCmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("操作浏览器滚动条失败");
		}
	  }
	  
	  /**
	   * 断言网页内容是否包含目标字段
	   * @param target
	   */
	  public void assertPageContains(String target) {
		  String PageContent = driver.getPageSource();
		  if (PageContent.contains(target)) {
			  System.out.println("网页中包含目标内容，测试成功");
		  }else {
			  System.out.println("网页中不含目标内容，测试失败");
		  }
	  }

/**
  * 使用option的value属性完成selector选择
 * @param Xpath
 * @param selector
 */
      public void SelectValue(String Xpath,String selector) {
    	  try {
			WebElement ele = driver.findElement(By.xpath(Xpath));
			  Select sel = new Select(ele);
			  sel.selectByValue(selector);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("通过值选择select失败！");
		}
    	  
      }

      /**
       * 通过文本text完成selector选择
       * @param Xpath
       * @param selector
       */
      public void selectText(String Xpath,String selector) {
    	  try {
			WebElement ele = driver.findElement(By.xpath(Xpath));
			  Select sel = new Select(ele);
			  sel.selectByVisibleText(selector);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("通过文本选择select失败！");
		}
      }
      
    
   /**
    * 上传文件
    * @param Xpath
    * @param filepath
    */
   public void upload(String Xpath,String filepath) {
	   try {
		driver.findElement(By.xpath(Xpath)).sendKeys(filepath);
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println("文件上传失败");
	}
   }   
      
  /**
   * 保存错误截图
   * @param method
   */
   public void saveScrshot(String method) {
	   //获取当前执行时间
	   Date date = new Date();
	   //将时间转换为指定的格式
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
	   String createdate = sdf.format(date);
	   //拼接文件名
	   String scrName = "log/ScrShot/"+ method+"_"+createdate+".png";
	   //以当前文件名创建一个空的png文件
	   File scrShot = new File(scrName);
	   //将截图保存到内存中的临时文件
	   File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	   try {
		FileUtils.copyFile(tmp, scrShot);
	} catch (IOException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println("截图失败！");
	}
	   

	   
   }
      
      public void switchHandles(int number) {
    	  List<String> handlesList = new ArrayList<String>(driver.getWindowHandles());
    	  String handles = handlesList.get(number);
          driver.switchTo().window(handles);
          	
      }
      
      
      
      
      
      
      
      
      
}
