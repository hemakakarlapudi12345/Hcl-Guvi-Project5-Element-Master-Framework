package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://demoqa.com/webtables");
    }

    public void addRecord() {

        openPage();

        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.id("firstName")).sendKeys("Hema");
        driver.findElement(By.id("lastName")).sendKeys("K");
        driver.findElement(By.id("userEmail")).sendKeys("hema@test.com");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("salary")).sendKeys("50000");
        driver.findElement(By.id("department")).sendKeys("QA");

        driver.findElement(By.id("submit")).click();

        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    public void searchRecord() {

        driver.findElement(By.id("searchBox")).sendKeys("Hema");

        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    public void deleteRecord() {

        // search record first
        WebElement search = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("searchBox"))
        );
        search.clear();
        search.sendKeys("Hema");

        // wait and click delete (first visible)
        WebElement deleteBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Delete']"))
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", deleteBtn);
    }
}