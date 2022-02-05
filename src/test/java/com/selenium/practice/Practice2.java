package com.selenium.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice2 extends Base {	
	/*
	Recommended for you
	Selling fast
	Healthcare essentials
	Trending electronics deals
	Clearance deals
	Top deals on watches & eyewear
	Top picks in laptops
	Top picks in televisions
	Top beauty deals
	Top deals on fragrances
	Top deals on appliances
	Top deals on home essentials
	Exclusive noon brands
	Top deals on baby essentials
	Top deals on trending toys
	Top deals on health & nutrition
	Top deals on sports	
	*/

	public static WebDriver driver;	
	//Add the tray name to fetch the product list
	public static String prodName = "Top picks in office supplies";
	
	
	@BeforeTest
	public static void chrome() throws InterruptedException {
		driver = Base.browser();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();

	}	
	
	@AfterTest
	public static void teardown() { 
		driver.quit();	
		}
	
	@Test
	public static void carouselCount() throws Exception {	
		productList(); // To Fetch the tray names
		carouselFunction(); 	// To fetch the products under that specific tray
		}
	
	private static void productList() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(int i=250; i<=10000; i++) {
		jse.executeScript("window.scrollBy(0, "+i+" )", "");
			Thread.sleep(2000);
			i = i +200;
		}
		 List<WebElement> prod = driver.findElements(By.xpath("//div[@class='sc-uxdHp fiDOnB']//h3"));
		 System.out.println("Total no. of trays: "+prod.size());
		 for (WebElement e1: prod) {
			 System.out.println(e1.getText());
			
		}
	}

	
	
	public static void carouselFunction() throws InterruptedException {
		Actions actions = new Actions(driver);
		while(driver.findElement(By.xpath("//span[text()='Sign In']")).isDisplayed()) {
			actions.sendKeys(Keys.ARROW_DOWN);
			actions.perform();
			WebElement recomentedEle = null; 
			try {
				recomentedEle = driver.findElement(By.xpath("//h3[text()='"+prodName+"']"));
				System.out.println("*********************************");
				System.out.println("Tray Name: "+recomentedEle.getText());
			  Thread.sleep(2000); 
			  List<WebElement> li = driver.findElements(By.xpath("//h3[text()='"+prodName+"']/ancestor::div[@class='sc-uxdHp fiDOnB']//div[@title]"));				
		  System.out.println("Total no. of products: "+li.size()); 
		  ArrayList<String> ar = new ArrayList<String>();		  
		  for (int i=0;i<li.size();i++) {
		  String name= li.get(i).getAttribute("title");
		  System.out.println(name);
		  ar.add(name);  }
		System.out.println("*****After Sorting the products*****");
		Collections.sort(ar);
		for(String s:ar) {
			System.out.println(s);
		}
	
			} catch(Exception e ) {
				System.out.println(e.getMessage());
			}
			if(recomentedEle !=null) {
				break ; 
			}
	}
	}
}

	
	

	

