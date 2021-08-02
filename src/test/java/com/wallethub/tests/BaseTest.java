package com.wallethub.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.wallethub.pages.BasePage;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    @Parameters({"testUrl","propFile","testIdentifier"})
    public void setup(String testUrl,String propFile, String testIdentifier) {
        BasePage basePage = new BasePage();
        
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        driver.navigate().to(testUrl);
        driver.manage().window().maximize();

        basePage.setWebDriver(driver);

        new LoginTest().Login(propFile,testIdentifier);
        
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
