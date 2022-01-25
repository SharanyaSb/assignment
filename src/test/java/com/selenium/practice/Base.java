package com.selenium.practice;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver browser() {
		String path = System.getProperty("user.dir");   // return project folder path
		String driverpath = path + "\\chromedriver.exe";   // return driver folder path 
		System.setProperty("webdriver.chrome.driver",driverpath );
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	
	public static void main(String[] args) {
		
	}

}
