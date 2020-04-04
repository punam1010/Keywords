package com.configfile;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Constants {
	public static WebDriver driver;
	public static Actions action;
	public static Select select;
	public static WebElement element;
	public static FileInputStream fis;
	public static Properties pro;
	public static Logger logger;
	public static Alert al;

}
