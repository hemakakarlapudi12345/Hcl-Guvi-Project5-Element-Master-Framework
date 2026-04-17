package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By alertBtn = By.id("alertButton");
    By confirmBtn = By.id("confirmButton");
    By promptBtn = By.id("promtButton");

    By result = By.id("confirmResult");
    By promptResult = By.id("promptResult");

    public void openPage() {
        driver.get("https://demoqa.com/alerts");
    }

    // 🔥 SIMPLE ALERT
    public void handleSimpleAlert() {
        driver.findElement(alertBtn).click();
        driver.switchTo().alert().accept();
    }

    // 🔥 CONFIRM ALERT
    public void handleConfirmAlert() {
        driver.findElement(confirmBtn).click();
        driver.switchTo().alert().dismiss();
    }

    public String getConfirmResult() {
        return driver.findElement(result).getText();
    }

    // 🔥 PROMPT ALERT
    public void handlePromptAlert(String text) {
        driver.findElement(promptBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getPromptResult() {
        return driver.findElement(promptResult).getText();
    }
}