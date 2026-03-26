package com.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
public class InventoryManagementApplicationTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    void shouldAnswerWithTrue() {
        driver.get("http://localhost:5173");

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Username']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        usernameInput.sendKeys("user");
        passwordInput.sendKeys("user");
        loginButton.click();

       
        WebElement productInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Enter product']")));
        assertTrue(productInput.isDisplayed());
    }

    @Test
    @Order(2)
    void stockRequest() {
       
        WebElement productInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Enter product']")));
        WebElement qtyInput = driver.findElement(By.xpath("//input[@placeholder='Enter quantity']"));
        WebElement requestButton = driver.findElement(By.xpath("//button[text()='Request Stock']"));

        productInput.sendKeys("Laptop");
        qtyInput.sendKeys("5");
        requestButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Stock Requested"));
        alert.accept();
    }

    

    @Test
    @Order(3)
    void adminLogin() {
        driver.get("http://localhost:5173");

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Username']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("admin");
        loginButton.click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[text()='Approve']")));
        assertTrue(driver.getPageSource().contains("Admin Dashboard"));
    }

    @Test
    @Order(4)
    void testAdminApproveRequest() {
        List<WebElement> approveButtons = driver.findElements(By.xpath("//button[text()='Approve']"));
        if (!approveButtons.isEmpty()) {
            approveButtons.get(0).click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assertTrue(alert.getText().contains("Request Approved"));
            alert.accept();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
        }
    }

    @Test
    @Order(5)
    void testAdminRejectRequest() {
        List<WebElement> rejectButtons = driver.findElements(By.xpath("//button[text()='Reject']"));
        if (!rejectButtons.isEmpty()) {
            rejectButtons.get(0).click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assertTrue(alert.getText().contains("Request Rejected"));
            alert.accept();
        }
    }
}
