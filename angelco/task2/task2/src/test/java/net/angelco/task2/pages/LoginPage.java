package net.angelco.task2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//span[text()=\"Login\"]/parent::button")
    WebElement loginButton;

    WebDriver driver;

    public LoginPage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public void Login() {
        emailBox.sendKeys(BasePage.configModel.getUsername());
        passwordBox.sendKeys(BasePage.configModel.getPassword());
        loginButton.click();
    }

}
