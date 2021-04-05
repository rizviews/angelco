package net.angelco.task2.pages;

import java.util.List;

import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import net.angelco.task2.utils.Lorem;
import net.angelco.task2.pages.BasePage;

public class WalletHubInsurancePage {

    @FindBy(xpath = "//h1[@class=\"profile-name\"]")
    WebElement profileNameHeader;
    @FindBy(xpath = "//*[@id='reviews-section']/div[1]/div[3]/review-star/div/*[name()='svg'][4]")
    WebElement fourthStar;
    @FindBy(xpath = "//div[@class='left-content']/a/span[text()='Reviews']/parent::a")
    WebElement reviewsMenuLink;
    @FindBy(xpath = "//*[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/i")
    WebElement policyDropdown;
    @FindBy(xpath = "//li[text()='Health Insurance']")
    WebElement policyDropdownItem;
    @FindBy(className = "textarea wrev-user-input validate")
    WebElement writeReviewTextArea;

    String fourthReviewStarPath = "//*[@id='reviews-section']/div[1]/div[3]/review-star/div/*[name()='svg'][4]/*[name()='g']/*[name()='path']";

    String insuranceUrl = "https://wallethub.com/profile/test-insurance-company-13732055i";
    WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);

    public WalletHubInsurancePage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public void assertHeader() {

        BasePage.driver.navigate().to(insuranceUrl);
        wait.until(ExpectedConditions.visibilityOf(profileNameHeader));

        Assert.assertEquals(profileNameHeader.getText(), "Test Insurance Company");

    }

    public void assertReviewStarHighlightedOnHover() {

        BasePage.driver.navigate().to("https://wallethub.com/profile/test-insurance-company-13732055i#reviews");

        wait.until(ExpectedConditions.visibilityOf(fourthStar));

        Actions act = new Actions(BasePage.driver);
        act.moveToElement(fourthStar).build().perform();

        try {
            Thread.sleep(2000);
        } catch (Exception exp) {

        }

        List<WebElement> svgPaths = BasePage.driver.findElements(By.xpath(fourthReviewStarPath));
        Assert.assertEquals(svgPaths.size(), 2, "Star was not highlighted with hover.");

    }

    public void assertReviewSubmittedSuccessfully() {

        Actions act = new Actions(BasePage.driver);
        act.moveToElement(fourthStar).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(policyDropdown));

        policyDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(policyDropdownItem));

        policyDropdownItem.click();

        Lorem lorem = new Lorem();

        String randomText = lorem.characters(200, 200, true, true);

        writeReviewTextArea.sendKeys(randomText);

        try {
            Thread.sleep(2000);
        } catch (Exception exp) {

        }

    }

}
