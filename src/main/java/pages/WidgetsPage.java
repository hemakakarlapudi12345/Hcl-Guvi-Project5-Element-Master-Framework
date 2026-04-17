package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    By dateInput = By.id("datePickerMonthYearInput");

    public void openPage() {
        driver.get("https://demoqa.com/date-picker");
    }

    public void selectDate() {

        WebElement input = driver.findElement(dateInput);

        input.clear();
        input.sendKeys("04/20/2026");
        input.sendKeys(Keys.ENTER);
    }

    public String getDate() {
        return driver.findElement(dateInput).getAttribute("value");
    }
}