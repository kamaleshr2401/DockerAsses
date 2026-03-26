package com.app;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InventoryManagementApplicationTest {
	
	@Test
    void testUserLogin() 
    {
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://localhost:5173/");
    	
    	WebElement webElement = driver.findElement(By.className("form-control"));
    	webElement.sendKeys("admin");
    	
    	WebElement w = driver.findElement(By.className("form-contro"));
    	w.sendKeys("admin");
    	
    	WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
    	loginButton.click();
    	
    	System.out.println("Worked....");
    }
		
}
