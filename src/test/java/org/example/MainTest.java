package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainTest {
    public WebDriver driver;
    public WebDriverWait waitDriver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    }
    @Test(priority = 2)
    public void VerifyHeader(){
        boolean isHeaderDisplayed = driver.findElement(By.className("title")).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed,"PRODUCTS header is displayed");
    }

    @Test(priority = 3)
    public void VerifyShoppingCart(){
        boolean isShopppingCartDisplayed = driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        Assert.assertTrue(isShopppingCartDisplayed,"Shopping Cart is displayed");
    }

    @Test(priority = 4)
    public void VerifyBurgerMenu(){
        boolean isBurgerMenuDisplayed = driver.findElement(By.id("menu_button_container")).isDisplayed();
        Assert.assertTrue(isBurgerMenuDisplayed,"Menu is displayed");
    }

    @Test(priority = 5)
    public void VerifyFacebookLink(){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("social_facebook")));
    }

    @Test(priority = 6)
    public void VerifyTwitterLink(){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("social_twitter")));
    }

    @Test(priority = 7)
    public void VerifyLinkedInLink(){
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.className("social_linkedin")));
    }

    @Test(priority = 8)
    public void Logout(){
        WebElement meni = driver.findElement(By.className("bm-burger-button"));
        meni.click();
        WebElement logout=driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
    }
}