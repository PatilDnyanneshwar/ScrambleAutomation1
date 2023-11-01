package com.scramble.utils.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class BaseClass {
    WebDriver driver;

    public static void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qa.scrambleid.com/api/v1/login/saml/ZGVtfHxkZW1vZ3Vlc3QuY29t?SAMLRequest=fZLd[%E2%80%A6]d1u4S8YJSfE2WFgouRb1v%2B8Z%2FZR4BGuNTc6jUw%3D%3D&format=json");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
