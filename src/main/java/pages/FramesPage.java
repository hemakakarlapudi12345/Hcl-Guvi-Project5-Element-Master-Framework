package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    By frame1 = By.id("frame1");
    By text = By.id("sampleHeading");

    public void openPage() {
        driver.get("https://demoqa.com/frames");
    }

    public String getFrameText() {

        driver.switchTo().frame(driver.findElement(frame1));

        String txt = driver.findElement(text).getText();

        driver.switchTo().defaultContent();

        return txt;
    }
}