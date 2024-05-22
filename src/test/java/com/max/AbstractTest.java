package com.max;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    static WebDriver webDriver;
    String appLogin = "login";
    String appPassword = "password";
    String appEmail = "login@login.ru";

    @BeforeAll
    static void authorization(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));;
        webDriver.get("https://gb.ru/login");
    }

    @BeforeEach
    void reboot(){
        webDriver.navigate().refresh();
    }

    @AfterAll
    static void closeApp(){
        webDriver.quit();
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public String getAppLogin(){
        return appLogin;
    }
    public String getAppPassword(){
        return appPassword;
    }

    public String getAppEmail(){
        return appEmail;
    }
}
