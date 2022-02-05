package com.selenium.practice;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {	
	public static WebDriver driver;	
	
	
	@BeforeTest
	public static void chrome() throws InterruptedException {
		driver = Base.browser();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();

	}	
	
	@AfterTest
	public static void teardown() { 
		driver.quit();		}
	
	@Test
	public static void method1() throws Exception {	
		
		}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

	
	


	

