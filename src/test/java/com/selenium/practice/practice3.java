package com.selenium.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class practice3 extends Base {
	
	public WebDriver driver;
	@BeforeTest
	public void launch() {
		driver = Base.browser();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();		
	}
	
	
	@Test
	public void addtocart() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> price = driver.findElements(By.className("inventory_item_price"));
		System.out.println(price.size());
		List<Double> lil = new ArrayList<>();
		
		for (int i=0;i<price.size();i++) {
			String li= price.get(i).getText().substring(1);
			//System.out.println(li);
			double a=Double.parseDouble(li);
			lil.add(a);			
		}	
		double s=Collections.max(lil);
		//System.out.println("//div[@class='inventory_item_price' and contains(., \""+s+"\")]//following::button[1]");
		driver.findElement(By.xpath("//div[@class='inventory_item_price' and contains(., \""+s+"\")]//following::button[1]")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		String h=driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText().substring(1);
		double s1=Double.parseDouble(h);
		//System.out.println(h+" "+s);
		 Assert.assertEquals(s, s1);
		
	}
	
	
	@AfterTest
	public void browserClose() {
		//driver.quit();	
	}
}
