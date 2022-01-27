package com.selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public static void teardown() { 
		//driver.quit();	
	}
	
	@Test
	public static void carouselCount() throws InterruptedException {
		
		carouselFunction();
		
	}
	
	public static void carouselFunction() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		
		  List<WebElement> li = driver.findElements(By.xpath("(//div[@class='swiper-wrapper'])[3]//div[@title]"));
		  System.out.println(li.size()); 
		  
		  for (int i=0;i<li.size();i++) {
		  String name= li.get(i).getAttribute("title");
		  System.out.println(name);
		  }
		////*[text()='Recommended for you']//following::div[contains(@class,'swiper-slide')]//div[@title]
		
		
		
	}
	
	
	
	
	
}
