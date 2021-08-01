package net.wallethub.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "pass")
    WebElement passwordBox;

    @FindBy(name = "login")
    WebElement loginButton;

    WebDriver driver;

    public LoginPage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public void LoginToFacebook() {
        emailBox.sendKeys(BasePage.configModel.getUsername());
        passwordBox.sendKeys(BasePage.configModel.getPassword());
        loginButton.click();
    }

}
