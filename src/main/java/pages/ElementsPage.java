package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    By expand = By.xpath("//button[@title='Expand all']");
    By checkbox = By.xpath("(//span[@class='rct-checkbox'])[1]");
    By result = By.id("result");

    public void selectCheckbox() {

        driver.get("https://demoqa.com/checkbox");

        try { Thread.sleep(2000); } catch (Exception e) {}

        driver.findElement(By.xpath("//button[@title='Expand all']")).click();

        try { Thread.sleep(1000); } catch (Exception e) {}

        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[1]")).click();
    }
}