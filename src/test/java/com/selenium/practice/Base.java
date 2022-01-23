package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver browser() {
		System.setProperty("webdriver.chrome.driver","D:\\Desktop\\desktop\\resume\\Notes\\seleniumassignment\\assignment\\src\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	
	public static void main(String[] args) {
		
	}

}
