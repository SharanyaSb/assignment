package com.selenium.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BrokenLinks extends Base {
	public WebDriver driver;
	@BeforeTest
	public void launch() {
		driver = Base.browser();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
	}
@Test	
public void brokenlinks() {
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("No.of Links: "+links.size());
	for (WebElement e : links) {
		String url = e.getAttribute("href");
		checkBL(url);
	}
}

public void checkBL(String linkUrl) {
	try {
		URL url = new URL(linkUrl);
		HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
		httpUrlConnection.setConnectTimeout(5000);
		httpUrlConnection.connect();
		if (httpUrlConnection.getResponseCode()>=400) {
			System.out.println(linkUrl + " " + httpUrlConnection.getResponseMessage() + " is broken link");
		}
		else {
			System.out.println(linkUrl + " " + httpUrlConnection.getResponseMessage() + " is working fine");
		}
	}
catch (Exception e) {
	
}

}

	@AfterTest
	public void browserClose() {
		driver.quit();	
	}
	

}
		

