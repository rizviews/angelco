package net.angelco.tests.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.angelco.tests.pages.BasePage;
import net.angelco.tests.utils.ConfigModel;
import net.angelco.tests.utils.ConfigParser;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        BasePage basePage = new BasePage();

        ConfigParser configParser = new ConfigParser();
        ConfigModel configModel = configParser.parseConfig();
        basePage.setConfigModel(configModel);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        basePage.setWebDriver(driver);

        new LoginTest().Login();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
