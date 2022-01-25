package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice2 extends Base {

	public static WebDriver driver;
	
	@BeforeTest
	public static void chrome() {
		driver = Base.browser();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();}
	
	@AfterTest
	public static void teardown() { driver.quit();	}
	
	@Test
	public static void carouselCount() {
		
		carouselFunction();
		
	}
	
	public static void carouselFunction() {
		
	}
	
	
	
	
	
}
