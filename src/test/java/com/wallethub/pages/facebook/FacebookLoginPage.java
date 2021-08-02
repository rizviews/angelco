package com.wallethub.pages.facebook;

import org.openqa.selenium.WebElement;

import com.wallethub.pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "pass")
    WebElement passwordBox;

    @FindBy(name = "login")
    WebElement loginButton;

    WebDriver driver;

    public FacebookLoginPage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public void LoginToFacebook(String username, String password) {
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}
