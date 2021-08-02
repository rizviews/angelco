package net.wallethub.task2.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.wallethub.task2.pages.BasePage;
import net.wallethub.task2.utils.ConfigModel;
import net.wallethub.task2.utils.ConfigParser;

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

        driver.navigate().to("https://wallethub.com/join/login");
        driver.manage().window().maximize();

        basePage.setWebDriver(driver);

        new LoginTest().Login();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
