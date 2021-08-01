package net.wallethub.task2.pages;

import org.openqa.selenium.WebDriver;

import net.wallethub.task2.utils.ConfigModel;

public class BasePage {
    protected static WebDriver driver;
    protected static ConfigModel configModel;

    public void setWebDriver(WebDriver webDriver) {
        BasePage.driver = webDriver;
    }

    public void setConfigModel(ConfigModel model) {
        BasePage.configModel = model;
    }
}
