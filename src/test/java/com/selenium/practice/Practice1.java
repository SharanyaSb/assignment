package com.selenium.practice;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice1 extends Base{
	public static WebDriver driver;
	
	public static void chrome() {
		driver = Base.browser();
		driver.get("https://www.worldometers.info/world-population/");
driver.manage().window().maximize();
	}
	
public static void main(String[] args) {
chrome();
String main_number =	driver.findElement(By.xpath("//div[@class = 'maincounter-number']/span")).getText();
String births_today = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[1]/span")).getText();
String deaths_today = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[2]/span")).getText();
String population_growth_today = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[3]/span")).getText();
String births_year = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[4]/span")).getText();
String deaths_year = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[5]/span")).getText();
String population_growth_year = driver.findElement(By.xpath("(//div[@class = 'sec-counter'])[6]/span")).getText();
while(true) {
	System.out.println(main_number);
	System.out.println(births_today);
	System.out.println(deaths_today);
	System.out.println(population_growth_today);
	System.out.println(births_year);
	System.out.println(deaths_year);
	System.out.println(population_growth_year);
	WebDriverWait wait = new WebDriverWait(driver,20);
break;
}
driver.close();
}

}
