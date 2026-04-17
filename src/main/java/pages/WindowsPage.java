package pages;

import base.BasePage;
import org.openqa.selenium.*;

import java.util.Set;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    By newTabBtn = By.id("tabButton");

    public void openPage() {
        driver.get("https://demoqa.com/browser-windows");
    }

    public String handleNewTab() {

        String parent = driver.getWindowHandle();

        driver.findElement(newTabBtn).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                return driver.getTitle();
            }
        }

        return "";
    }
}