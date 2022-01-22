package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mathu\\Desktop\\DevOps\\SeleniumPractice\\Jars\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	
	public static void main(String[] args) {
		
	}

}
