package base;

import config.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
    }
    public void waitForElement(By locator) {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions
            .visibilityOfElementLocated(locator));
    }

    // 🔥 FORCE CLICK (bypasses ads / overlays)
    public void jsClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }
}