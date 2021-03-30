package net.angelco.tests.pages;

import org.openqa.selenium.WebDriver;

import net.angelco.tests.utils.ConfigModel;

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
