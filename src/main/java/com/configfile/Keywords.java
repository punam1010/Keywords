package com.configfile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Constant;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {
	/**
	 * It Will Launch Specified Browser
	 * @param BrowserName
	 * @return void
	 * @author Punam
	 */
	public static void LaunchBrowser(String BrowserName) {
	      switch(BrowserName) {
	      case "Chrome":
	    	  WebDriverManager.chromedriver().setup();
	    	  Constants.driver=new ChromeDriver();
	    	  break;
	      case "IE":
	    	  WebDriverManager.iedriver().setup();
	    	  Constants.driver=new InternetExplorerDriver();
	    	  break;
	      case "FireFox":
	    	  WebDriverManager.firefoxdriver().setup();
	    	  Constants.driver=new FirefoxDriver();
	    	  break;
	    	  default:
	    		  System.out.println("Invalid Browser "  +BrowserName);
	      }
		}
		/**
		 * It opens URL in Specified Browser
		 * @param url{@code: String} URL to open
		 * @return void
		 * @author Punam
		 */
		public static void open_Url(String url)
		{
			Constants.driver.get(url);

		}
		
		/**
		 * This method will Maximize window
		 * @return void
		 * @author Punam
		 */
		public static void maximize_Window() 
		{
			Constants.driver.manage().window().maximize();

		}
		
		/**
		 * This Method get the webelement
		 * @param locatortype
		 * @param locatorValue
		 * @return
		 * @author Punam
		 */
		public static WebElement getWebElement(String locatortype,String locatorValue) {
			WebElement element=null;
			
			switch(locatortype) {
			case "XPATH":
				element=Constants.driver.findElement(By.xpath(locatorValue));
				break;
			case "CSS":
				element=Constants.driver.findElement(By.cssSelector(locatorValue));
				break;
			case "ID":
				element=Constants.driver.findElement(By.id(locatorValue));
				break;
			case "CLASS_NAME":
				element=Constants.driver.findElement(By.className(locatorValue));
				break;
			case "LINK_TEXT":
				element=Constants.driver.findElement(By.linkText(locatorValue));
				break;
			case "PARTIAL_LINK_TEXT":
				element=Constants.driver.findElement(By.partialLinkText(locatorValue));
				break;
				default:
					System.out.println("Invalid Locator Type");
					break;
					
			}
			return element;
		}
		
		
		public static void clickOnElement(String locatortype, String locatorValue)
		   {
			getWebElement(locatortype,locatorValue).click();
		   }
		
		
		public static String enterText(String locatortype, String locatorValue, String text) 
		  {
			String s=null;
			getWebElement(locatortype,locatorValue).sendKeys(text);
			return s;
          }
		
		
		public static void select_Value_From_DropDown_ByVisibleText(WebElement element, String selectText) 
		{
 
			//element=getWebElement(locatortype,locatorValue);
			try {
			Constants.select=new Select(element);
			Constants.select.selectByVisibleText("Baby");
			}catch(NoSuchElementException e) {
				System.out.println("Value not Find in DropDown");
			}
        }
		
		
		public static void select_Value_From_Dropdown_ByIndex(WebElement element,int indexval)
		{
			//WebElement element=getWebElement(locatortype,locatorValue);
			try{
				Constants.select=new Select(element);
				Constants.select.selectByIndex(indexval);
			}catch(NoSuchElementException e) {
				System.out.println("Text not present at this index value");
			}
		}
		
		
		
		public static void search_Text(String locatortype, String locatorValue, String serachText)
		 {
			getWebElement(locatortype,locatorValue).sendKeys(serachText);
         }
		
		
		public static void button_text(String locatortype, String locatorValue)
		{
			getWebElement(locatortype,locatorValue).click();
		}
		
		
		public static void verify_Links(String locatortype, String locatorValue)
		 {
			getWebElement(locatortype, locatorValue).click();
		 }
		
		
		public static void mouse_Hover_Action(String locatortype, String locatorValue)
		{
			//getWebElement(locatortype, locatorValue);
			Constants.action=new Actions(Constants.driver);
			Constants.action.moveToElement(getWebElement(locatortype, locatorValue)).perform();;
		}
		
		
		
		public static String get_Label_Of_Webelement(String locatortype, String locatorValue) 
		{
			Constants.element=getWebElement(locatortype, locatorValue);
			String s=Constants.element.getText();
		//	System.out.println(Constant.element.getText());
			return s;
		}
		
		
		public static void IsImagePresent(String locatortype, String locatorValue) 
		 {
			WebElement imagefile=getWebElement(locatortype,locatorValue);
		 }
		
		
		public static void apply_wait() 
		  {
			Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		  }
		
		
		public static boolean is_Logo_Display(String locatortype, String locatorValue)
		  {
			boolean logo=getWebElement(locatortype, locatorValue).isDisplayed();
			return logo;
		  }
		
		
	public static void get_Screenshot(String path, String fileName, String ext) {
			TakesScreenshot ts=(TakesScreenshot)Constants.driver;
			File srcfile=ts.getScreenshotAs(OutputType.FILE);
		DateFormat date_time_format=new SimpleDateFormat("yyyy-MM-dd_hh_mm:ss");
		Date systemDate=new Date();
		String systemDateTime=date_time_format.format(systemDate);
		try {
			FileUtils.copyFile(srcfile, new File(path + fileName+" "+systemDateTime+ext));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		
			
		
	public static void get_fullPageScreenShot(String fullpage) throws IOException
	    {
			AShot ashot=new AShot();
			ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000));
			Screenshot s=ashot.takeScreenshot(Constants.driver);
			BufferedImage image=s.getImage();
			ImageIO.write(image, "jpg", new File(fullpage));
			
		}
	
	
		public static boolean is_Alert_Present()
		{
			try {
			Constants.al=Constants.driver.switchTo().alert();
			String s=Constants.al.getText();
			Constants.al.accept();
			return true;
			}
			catch(Exception e) {
				return false;
			}
		}
		
		
		public static void window_Handling()
		{
			String parentwindow=Constants.driver.getWindowHandle();
			Set<String> allkeys=Constants.driver.getWindowHandles();
			for (String child : allkeys) {
				while(!parentwindow.equals(child))
				{
					Constants.driver.switchTo().window(child);
				}
			}
		}
		
		
		public static void create_Logs(String classname) {
			Constants.logger = Logger.getLogger(classname);
			PropertyConfigurator.configure("D:\\framework\\Testing\\src\\main\\resources\\Log4j.properties");
					

		}
		
		public static void close_Window() 
		  {
			Constants.driver.close();
		  }
		
		
		public static void close_All_Windows()
		{
			Constants.driver.quit();
		}

}
