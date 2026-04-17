package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    // 🔴 LOCATORS
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");

    By maleRadioLabel = By.xpath("//label[text()='Male']");
    By maleRadioInput = By.id("gender-radio-1");

    By mobile = By.id("userNumber");

    By submitBtn = By.id("submit");

    By successMessage = By.id("example-modal-sizes-title-lg");

    // 🔥 OPEN PAGE
    public void openFormPage() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    // 🔥 FILL FORM
    public void fillForm(String fname, String lname, String mail, String phone) {

        type(firstName, fname);
        type(lastName, lname);
        type(email, mail);

        WebElement male = driver.findElement(maleRadioLabel);
        scrollToElement(male);
        male.click();

        type(mobile, phone);
    }

    // 🔥 SUBMIT
    public void submitForm() {

        WebElement submit = driver.findElement(submitBtn);
        scrollToElement(submit);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    // 🔥 SUCCESS MESSAGE
    public String getSuccessMessage() {
        waitForElement(successMessage);
        return driver.findElement(successMessage).getText();
    }

    // 🔥 RADIO VALIDATION
    public boolean isMaleSelected() {
        return driver.findElement(maleRadioInput).isSelected();
    }

    // 🔥 NEGATIVE VALIDATION
    public boolean isFormInvalid() {
        return driver.findElements(successMessage).isEmpty();
    }

    // 🔥 SCROLL METHOD (FIX FOR YOUR ERROR)
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}