package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase2 {
    public WebDriver driver;
    public WebDriverWait waitDriver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void login(){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement username=driver.findElement(By.id("user-name"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.name("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        System.out.println("Login successfully");
    }

    @Test(priority = 2)
    public void SLBitemSelected(){
        WebElement ranac = driver.findElement(By.id("item_4_title_link"));
        ranac.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_container")));
        System.out.println("Sauce Labs Backpack Selected");
    }

    @Test(priority = 3)
    public void VerifySLBdetails(){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc_container")));
        boolean isDetailsDisplayed = driver.findElement(By.className("inventory_details_desc_container")).isDisplayed();
        Assert.assertTrue(isDetailsDisplayed,"Title, description and price are displayed");
        System.out.println("Title, description and price are displayed");
        WebElement add = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        add.click();
        System.out.println("Sauce Labs Backpack added to cart");
    }

    @Test(priority = 4)
    public void BackButton(){
        WebElement goBack = driver.findElement(By.id("back-to-products"));
        goBack.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        System.out.println("Back button navigated user to initial webpage successfully");
    }

    @Test(priority = 5)
    public void SLBLaddItem(){
        WebElement addSLBL = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addSLBL.click();
        System.out.println("Sauce Labs Bike Light added to cart");
    }
    @Test(priority = 6)
    public void ShoppingCart(){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_container")));
        WebElement goToCart = driver.findElement(By.className("shopping_cart_link"));
        goToCart.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_contents_container")));
        System.out.println("Shopping Cart opened successfully");
    }
    @Test(priority = 7)
    public void Checkout(){
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_info_container")));
        System.out.println("User navigated to checkout page successfully");
    }
    @Test(priority = 8)
    public void OrderDetails(){
        WebElement firstname=driver.findElement(By.id("first-name"));
        WebElement lastname=driver.findElement(By.id("last-name"));
        WebElement zipcode=driver.findElement(By.id("postal-code"));
        WebElement continuebutton=driver.findElement(By.id("continue"));
        firstname.sendKeys("Vera");
        lastname.sendKeys("Baric");
        zipcode.sendKeys("37000");
        continuebutton.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_summary_container")));
        System.out.println("User information filled out successfully");
    }
    @Test(priority = 9)
    public void Finish(){
        WebElement finish = driver.findElement(By.id("finish"));
        finish.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_complete_container")));
        System.out.println("User navigated to checkout: complete page successfully");
    }
    @Test(priority = 10)
    public void ThankYouMessage(){
        boolean isMessageDisplayed = driver.findElement(By.className("complete-header")).isDisplayed();
        Assert.assertTrue(isMessageDisplayed,"Thank you message is displayed");
        System.out.println("Thank you message is displayed");
    }
    @Test(priority = 11)
    public void Logout(){
        WebElement meni = driver.findElement(By.className("bm-burger-button"));
        meni.click();
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));
        System.out.println("Menu displayed");
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        WebElement logout=driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
        System.out.println("User logged out");
    }
}
