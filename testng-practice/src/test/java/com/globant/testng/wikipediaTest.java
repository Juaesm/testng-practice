package com.globant.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class wikipediaTest{

    WebDriver driver;

    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\juan.munoz02\\Documents\\GU\\testNG-practice\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeClass(dependsOnMethods = "testSetup")
    public void openBrowser()
    {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("pt-login-2")).click();
        System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
    }   

    /*@BeforeMethod(description = "This method validates the signup functionality")
    public void signup() throws InterruptedException
    {

        System.out.println("In SignUp Window");
        driver.findElement(By.id("wpName2")).sendKeys("testng_jm_3");
        driver.findElement(By.id("wpPassword2")).sendKeys("Pass1234*");
        driver.findElement(By.id("wpRetype")).sendKeys("Pass1234*");

        driver.findElement(By.id("wpCreateaccount")).click();

        System.out.println("Registration successful");
    }*/

    @Test(description = "This method validates the login functionality")
    public void login()
    {

        driver.findElement(By.id("wpName1")).sendKeys("Testng jm 3");
        driver.findElement(By.id("wpPassword1")).sendKeys("Pass1234*");

        driver.findElement(By.id("wpLoginAttempt")).click();


        System.out.println("Login successful");

    }

    @Test(dependsOnMethods = "login", description = "This method validates the log out functionality")
    public void logout()
    {

        driver.findElement(By.id("vector-user-links-dropdown-checkbox")).click();
        
        driver.findElement(By.id("pt-logout")).click();


        System.out.println("Logout Completed");
    }

    @Test(description = "This method validates a search and change the language")
    public void testSearch()
    {
        driver.get("https://en.wikipedia.org/wiki/George_W._Bush");
        System.out.println("Article Find");
        driver.findElement(By.id("p-lang-btn-checkbox")).click();
        driver.findElement(By.className("interlanguage-link interwiki-fr mw-list-item")).click();
        System.out.println("Language Changed");
    }
    
    
    
    
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }

    
}