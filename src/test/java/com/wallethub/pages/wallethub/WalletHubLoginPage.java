package com.wallethub.pages.wallethub;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.pages.BasePage;

public class WalletHubLoginPage {

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//span[text()=\"Login\"]/parent::button")
    WebElement loginButton;

    WebDriver driver;

    public WalletHubLoginPage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public void Login(String username, String password) {
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}
