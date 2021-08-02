package com.wallethub.pages;

import org.openqa.selenium.WebDriver;

import com.wallethub.pages.facebook.FacebookLoginPage;
import com.wallethub.pages.wallethub.WalletHubLoginPage;

public class BasePage {
    public static WebDriver driver;
    
    public void setWebDriver(WebDriver webDriver) {
        BasePage.driver = webDriver;
    }

    public void LoginToFacebook(String username, String password) {
        new FacebookLoginPage().LoginToFacebook(username, password);
    }

    public void LoginToWalletHub(String username, String password) {
        new WalletHubLoginPage().Login(username, password);
    }
}
