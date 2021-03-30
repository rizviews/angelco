package net.angelco.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage {

    @FindBy(xpath = "//div[@aria-label=\"Create a post\"]/div/div/div/span")
    WebElement createNewPostBox;
    @FindBy(xpath = "//div[contains(@aria-label,\"What's on your mind,\")]")
    WebElement writeStatusBox;
    @FindBy(xpath = "//div[contains(@aria-label,\"Edit privacy\")]")
    WebElement editPrivacyDropdown;
    @FindBy(xpath = "//span[text()=\"Only me\"]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div")
    WebElement selectOnlyMe;
    @FindBy(xpath = "//div[@aria-label=\"Post\"]")
    WebElement postButton;

    @FindBy(xpath = "//div[text()=\"hello world\"][1]")
    WebElement postedStatus;

    public FacebookHomePage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public void postStatus() {

        WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(createNewPostBox));
        createNewPostBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(editPrivacyDropdown));
        editPrivacyDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(selectOnlyMe));
        selectOnlyMe.click();
        wait.until(ExpectedConditions.visibilityOf(editPrivacyDropdown));
        wait.until(ExpectedConditions.visibilityOf(writeStatusBox));

        writeStatusBox.sendKeys("hello world");

        wait.until(ExpectedConditions.elementToBeClickable(postButton));

        postButton.click();

        wait.until(ExpectedConditions.visibilityOf(postedStatus));
    }

}
