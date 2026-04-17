package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTest extends BaseTest {

    @Test
    public void testSimpleAlert() {

        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.handleSimpleAlert();

        Assert.assertTrue(true);
    }

    @Test
    public void testConfirmAlert() {

        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.handleConfirmAlert();

        Assert.assertTrue(page.getConfirmResult().contains("Cancel"));
    }

    @Test
    public void testPromptAlert() {

        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.handlePromptAlert("Hema");

        Assert.assertTrue(page.getPromptResult().contains("Hema"));
    }
}