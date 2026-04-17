package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WidgetsPage;

public class WidgetsTest extends BaseTest {

    @Test
    public void testDatePicker() {

        WidgetsPage page = new WidgetsPage(driver);

        page.openPage();
        page.selectDate();

        Assert.assertTrue(page.getDate().contains("2026"));
    }
}