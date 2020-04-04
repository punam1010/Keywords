package com.KeywordDriven.Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.configfile.Constants;
import com.configfile.Keywords;

public class Sign_in_tests {
	@Test
	public static void get_Label_Of_SignIn() 
	{
		Keywords.LaunchBrowser("Chrome");
		Keywords.open_Url("https://www.ebay.com/");
		Keywords.get_Label_Of_Webelement("XPATH", "//a[text()='Sign in']");
		String lable = Constants.element.getText();
		Assert.assertEquals(lable, "Sign in");
	}

	@Test
	public static void verify_signIn_Link() 
	{

		Keywords.clickOnElement("XPATH", "//a[text()='Sign in']");
		String title = Constants.driver.getTitle();
		System.out.println("Sign IN Page title: " + title);
		Assert.assertEquals(title, "Sign in or Register | eBay");

	}

	@Test(priority = 9)
	public static void enter_Text() 
	{
		Keywords.enterText("XPATH", "//input[@name='firstname']", "Punam");
		Keywords.enterText("XPATH", "//input[@name='lastname']", "Shirsath");
		Keywords.enterText("XPATH", "//input[@name='email']", "punammatade10@gmail.com");
		Keywords.enterText("XPATH", "//input[@name='PASSWORD']", "punammatade10@gmail.com");
	}

}
