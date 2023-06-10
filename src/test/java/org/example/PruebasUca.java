package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PruebasUca {

    public WebDriver driver ;

    public void setUpLogin(){
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setUpAdd(){
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setUpRemove(){
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void Login(){
        WebElement loginBtn;
        WebElement userInput;
        WebElement passInput;
        loginBtn = driver.findElement(By.cssSelector("#login-button"));
        userInput = driver.findElement(By.cssSelector("#user-name"));
        passInput = driver.findElement(By.cssSelector("#password"));
        userInput.sendKeys("standard_user");
        passInput.sendKeys("secret_sauce");
        loginBtn.click();
    }

    public void LoginError(){
        WebElement loginBtn;
        WebElement userInput;
        WebElement passInput;

        loginBtn = driver.findElement(By.cssSelector("#login-button"));
        userInput = driver.findElement(By.cssSelector("#user-name"));
        passInput = driver.findElement(By.cssSelector("#password"));

        userInput.sendKeys("standard_user");
        passInput.sendKeys("secret_sauce");
        loginBtn.click();
    }

    public void Logout(){
        WebElement logoutBtn;
        WebElement menuBtn;

        menuBtn = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        logoutBtn = driver.findElement(By.cssSelector("#logout_sidebar_link"));

        menuBtn.click();
        logoutBtn.click();
    }

    public void AddProduct(){
        WebElement AddProduct1;
        AddProduct1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        AddProduct1.click();

        WebElement AddProduct2;
        AddProduct2 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        AddProduct2.click();
    }

    public void RemoveProduct(){
        WebElement RemoveBtn;
        RemoveBtn = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        RemoveBtn.click();
    }

    @Test (priority = 1)
    public void testLogin() {
        setUpLogin();
        Login();
    }

    @Test (priority = 2)
    public void testAdd() {
        setUpLogin();
        Login();

        AddProduct();
    }

    @Test (priority = 3)
    public void testRemove() {
        setUpLogin();
        Login();

        AddProduct();

        RemoveProduct();
    }

    @Test (priority = 4)
    public void testLogout() {
        setUpLogin();
        Login();
        Logout();
    }

    @Test (priority = 5)
    public void testLoginError() {
        setUpLogin();
        LoginError();
    }

}
