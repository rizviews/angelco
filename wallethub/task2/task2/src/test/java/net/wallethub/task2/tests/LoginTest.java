package net.wallethub.task2.tests;

import net.wallethub.task2.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private WebDriver driver;

    public void Login() {
        LoginPage loginPage = new LoginPage();
        loginPage.Login();
    }

}
