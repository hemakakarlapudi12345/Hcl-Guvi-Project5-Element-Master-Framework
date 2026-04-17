package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTest extends BaseTest {

    @Test
    public void testFormSubmission() {

        FormPage form = new FormPage(driver);

        form.openFormPage();
        form.fillForm("Hema", "K", "hema@test.com", "9876543210");
        form.submitForm();

        Assert.assertEquals(form.getSuccessMessage(), "Thanks for submitting the form");
    }

    @Test
    public void testRadioButton() {

        FormPage form = new FormPage(driver);

        form.openFormPage();
        form.fillForm("Hema", "K", "hema@test.com", "9876543210");

        Assert.assertTrue(form.isMaleSelected(), "Radio not selected");
    }

    @Test
    public void testEmptyForm() {

        FormPage form = new FormPage(driver);

        form.openFormPage();
        form.submitForm();

        Assert.assertTrue(form.isFormInvalid(), "Validation failed");
    }
}