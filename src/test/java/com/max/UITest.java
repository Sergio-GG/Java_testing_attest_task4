package com.max;

import com.max.patterns.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UITest extends AbstractTest{

    @Test
    void testGBNotEmailLogin() throws InterruptedException {
        // given
        WebDriver driver = getWebDriver();
        LoginPageObject lpo = new LoginPageObject(driver);
        // when
        lpo.sighIn(getAppLogin(),getAppPassword());
        // then
        Assertions.assertFalse(driver.findElements(By.xpath("//ul[@id='parsley-id-5']")).isEmpty());
    }

    @Test
    void testGBWithoutPassword() throws InterruptedException {
        // given
        WebDriver driver = getWebDriver();
        LoginPageObject lpo = new LoginPageObject(driver);
        // when
        lpo.sendLogin(getAppEmail());
        // then
        Assertions.assertFalse(driver.findElements(By.xpath("//ul[@id='parsley-id-7']")).isEmpty());
    }
}
