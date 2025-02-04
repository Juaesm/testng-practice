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

    @BeforeMethod
    public void openBrowser()
    {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("pt-createaccount-2")).click();
        System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
    }

    @BeforeMethod(description = "This method validates the signup functionality")
    public void signup() throws InterruptedException
    {

        System.out.println("In SignUp Window");
        driver.findElement(By.id("wpName2")).sendKeys("testng_jm_1");
        driver.findElement(By.id("wpPassword2")).sendKeys("Pass1234*");
        driver.findElement(By.id("wpRetype")).sendKeys("Pass1234*");

        driver.wait(10000);

        driver.findElement(By.id("wpCreateaccount")).click();

        System.out.println("Registration successful");



    }

    @Test(description = "This method validates the login functionality")
    public void login()
    {

        driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");

        driver.findElement(By.id("wpName1")).sendKeys("test1000");
        driver.findElement(By.id("wpPassword1")).sendKeys("Pass1234*");

        driver.findElement(By.id("wpLoginAttempt")).click();

        System.out.println("Login successful");




    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }

    
}