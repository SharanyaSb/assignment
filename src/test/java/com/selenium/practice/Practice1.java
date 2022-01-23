package com.selenium.practice;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice1 extends Base{
	
	public static WebDriver driver;
	public static double previousTime;
	
	@BeforeTest
	public static void chrome() {
		driver = Base.browser();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public static void teardown() {
		
		driver.quit();
	}
	
	@Test
	public static void assignment1() throws InterruptedException {
		previousTime = System.currentTimeMillis();		
		int value=0;
		
		while(value<20) {
			//System.out.println("test");
			double currentTime = System.currentTimeMillis();
			//System.out.println("current time is "+currentTime);
			//System.out.println("previous time : "+previousTime);
			double elapsedTime = (currentTime - previousTime) / 1000.0;
			System.out.println("Time in seconds : " + elapsedTime);
			
			 value = (int)elapsedTime;
			System.out.println(value);

			String main_number =	driver.findElement(By.xpath("//div[@class = 'maincounter-number']/span")).getText();
			String births_today = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[1]/span")).getText();
			String deaths_today = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[2]/span")).getText();
			String population_growth_today = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[3]/span")).getText();
			String births_year = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[4]/span")).getText();
			String deaths_year = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[5]/span")).getText();
			String population_growth_year = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[6]/span")).getText();
			
			System.out.println("Total Population is "+main_number);
			System.out.println("Today Birth is "+births_today);
			System.out.println("Today Dealth is "+deaths_today);
			System.out.println("Today Population Growth is "+population_growth_today);
			System.out.println("Year Birth is "+births_year);
			System.out.println("Year Dealth is "+deaths_year);
			System.out.println("Year Population Growth is "+population_growth_year);
		}		
	}
	
	
}
