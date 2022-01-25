package com.selenium.practice;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice1Solution extends Base{
	
	public static WebDriver driver;
	public static String population_xpath = "//div[@class = 'maincounter-number']/span";
	public static String today_year_xpath = "//div[text()='This year' or text()='Today']//parent::div//span[@class='rts-counter']";
	
	@BeforeTest
	public static void chrome() {
		driver = Base.browser();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();}
	
	@AfterTest
	public static void teardown() { driver.quit();	}
	
	@Test
	public static void assignment1() throws InterruptedException {
		int count = 1;
		while(count<=20) {
			System.out.println(count + "sec");
			if (count==21) break;
		System.out.println("************Population count*****************");
		printPopulationValue(population_xpath);
		System.out.println("*************Today and This Year Population count********************");
		printPopulationValue(today_year_xpath);
		Thread.sleep(1000);
		count++; }
		}	
	
	public static void printPopulationValue(String locator) {		
			
		/*List<WebElement> population = driver.findElements(By.xpath(locator));
			for (WebElement e : population) {
				System.out.println(e.getText());}
			*/
			
			//To improve performance, we can use stream
	driver.findElements(By.xpath(locator)).stream().forEach(e1 -> System.out.println(e1.getText()));		 
	}

}
