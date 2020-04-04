package com.KeywordDriven.Testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.configfile.Constants;
import com.configfile.Keywords;
import com.utilites.Utility_OR;

public class HomePage_Tests {
	
	@Test(priority = 0)
	public static void Verify_Menu() 
	{
        Keywords.LaunchBrowser("Chrome");
		Keywords.open_Url("https://www.ebay.com/");
		Keywords.create_Logs("HomePage_Tests");
		Constants.logger.info("URL Launch");
		Keywords.maximize_Window();
		Constants.logger.info("Verify menu tabs");
		String expected_Menu[] = { "Home", "Saved", "Electronics", "Fashion", "Health & Beauty", "Motors",
				"Collectibles", "Sports", "Home & Garden", "Deals", "Under $10" };
		List<WebElement> sub_menu = Constants.driver.findElements(By.cssSelector(".hl-cat-nav__container>li"));
		//List<WebElement> sub_menu = Utility_OR.getLocator("sub_Menu")[0], Utility_OR.getlocator("sub_Menu")[1]);
		ArrayList<String> Actual_Menu = new ArrayList<String>();
		Iterator<WebElement> itr = sub_menu.iterator();
		    while (itr.hasNext()) {
			                    Actual_Menu.add(itr.next().getText());
		               }
		boolean isEqual = Actual_Menu.containsAll(Arrays.asList(expected_Menu));
		Assert.assertTrue(isEqual);
	}
	

	@Test(priority = 1)
	public static void verifyLogo() 
	{
		 Keywords.LaunchBrowser("Chrome");
	     Keywords.open_Url("https://www.ebay.com/");
	     Keywords.create_Logs("HomePage_Tests");
	     Constants.logger.info("URL Launch");
	     Keywords.maximize_Window();
	     Constants.logger.info("Maximize Browser");
		boolean logo = Keywords.is_Logo_Display("XPATH","//img[@alt='eBay Logo']");
		Constants.logger.info("Logo Verification");
		Assert.assertTrue(logo);
	  }
	

	@Test(priority = 4)
	public static void verify_Value_select_from_DropDown() 
	 {
		Constants.element = Constants.driver.findElement(By.name("Art"));
		Assert.assertEquals("Baby", "Art");
	 }
	
	
	@Test
	public static void take_Screenshot ()
	 {
		 Keywords.LaunchBrowser("Chrome");
	     Keywords.open_Url("https://www.ebay.com/");
	     Keywords.create_Logs("HomePage_Tests");
	     Constants.logger.info("URL Launch");
	     Keywords.maximize_Window();
	     Constants.logger.info("Maximize Browser");
		 Keywords.enterText("XPATH", "//input[@id='gh-ac']", "frames");
		 Keywords.apply_wait();
		 Constants.logger.info("Enter text into textbox");
		 Keywords.get_Screenshot("D:/framework/Testing/Screenshots/", "Home", ".PNG");
		 Constants.logger.info("Screenshot taken");
		
	 }

	@Test(priority = 5)
	public static void verifyTitle() 
	{
		String title = Constants.driver.getTitle();
		System.out.println("Page title is " + title);
		Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
		 if(title.equals("Electronics, Cars, Fashion, Collectibles &amp; More | eBay")) 
		  { 
			 System.out.println("Pass: Correct Title"); 
		  }
		 else {
		  System.out.println("Fail: Incorrect Title");
		  }
	 }
	

	@Test(priority = 6)
	public static void enter_text_In_searchbox() 
	{
		String expected_text="Frames";
		String actual_text=Keywords.enterText("XPATH", "//input[@id='gh-ac']", "frames");
		if(expected_text.equals(actual_text))
		{
			System.out.println("Pass: Correct text entered");
		}
		else
		{
			System.out.println("Fail: not matching text   ");
		}
	}
	

	@Test(priority = 7)
	public static void click_register() 
	{
		Keywords.clickOnElement("XPATH", "//a[contains(text(),'register')]");

	}
	

	@Test
	public void verify_label_Of_ShopByCategory_DropDown() 
	  {
		
		String expected_lable = "Shop by category";
		String actual_lable = Keywords.get_Label_Of_Webelement("XPATH", "//button[@class='gh-control']");
		Assert.assertEquals(actual_lable, expected_lable);

	  }
	
	
	@Test(priority = 8)
	public static void check_enabled()
	{
		boolean isenabled = Keywords.getWebElement("XPATH", "//button[@id='ppaFormSbtBtn']").isEnabled();
		if (isenabled) 
		{
			System.out.println("Pass: Button is enabled");
		} else
		{
			System.out.println("fail: Button is not enabled");
		}
	
	}

	@Test(priority = 11)
	public static void check_availbility_of_text() {
		String Expected_text = "Already a member?";
		// String
		// actual_text=Constant.driver.findElement(By.xpath("//span[text()='Already a
		// member?']")).getText();
		// boolean ispresent=Constant.driver.getPageSource().contains(Expected_text);
		if (Constants.driver.getPageSource().contains(Expected_text)) {
			System.out.println("Pass: Text is Present");
		}

		else {
			System.out.println("fail: Text is not present");
		}

	}

	@Test(priority = 12)
	public static void button_Display() 
	{
		boolean isdisplay = Keywords.getWebElement("XPATH", "//button[@id='reg_sfk_btn_ggl']").isDisplayed();
		if (isdisplay) {
			System.out.println("Pass: Button is display");
		} else {
			System.out.println("Fail: Button is not display");
		}
	}
	
	/*@Test
	public static void is_Image_Present() 
	{
		WebElement image=Keywords.getWebElement("XPATH", "//img[contains(@alt,'Shop Now - Pounce on Puma')]");
		boolean imagePresent= (boolean)((JavascriptExecutor)Constants.driver).executeScript("window.widget_platform_renderedComponents = undefined ;  ;", image);
		if(!imagePresent)
		{
			System.out.println("Pass: Image Is Present");
		}
		else
		{
			System.out.println("Fail: Image is not present");
		}
	}*/

	@Test(priority = 3)
	public static void mouse_Hover()
	{
		Keywords.mouse_Hover_Action("XPATH", "//*[@id='mainContent']/div[1]/ul/li[3]/a");

	}
	
	@Test(priority = 10)
	public static void create_Acccount()
	{
		Keywords.clickOnElement("CSS", "#ppaFormSbtBtn");
	}

}
