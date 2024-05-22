package com.max.patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
    @FindBy(xpath="//input[@id='user_email']")
    private WebElement login;

    @FindBy(xpath="//input[@id='user_password']")
    private WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    private WebElement button;

    public LoginPageObject(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void sighIn(String inputLogin, String inputPass){
        login.sendKeys(inputLogin);
        password.sendKeys(inputPass);
        button.click();
    }
    public void sendLogin(String inputLogin){
        login.sendKeys(inputLogin);
        button.click();
    }
}
