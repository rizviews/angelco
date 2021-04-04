package net.angelco.task2.tests;

import net.angelco.task2.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private WebDriver driver;

    public void Login() {
        LoginPage loginPage = new LoginPage();
        loginPage.Login();
    }

}
