package net.wallethub.tests.tests;

import net.wallethub.tests.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private WebDriver driver;

    public void Login() {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginToFacebook();
    }

}
