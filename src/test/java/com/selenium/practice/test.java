package com.selenium.practice;

public class test {
	public static double previousTime;
	
	public static void main(String[] args) {

	
	previousTime = System.currentTimeMillis();
	//System.out.println("Start time is "+previousTime);
		
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
			
		}
	}
}
