package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WindowsPage;

public class WindowsTest extends BaseTest {

    @Test
    public void testNewTab() {

        WindowsPage page = new WindowsPage(driver);

        page.openPage();

        String title = page.handleNewTab();

        Assert.assertTrue(title.contains("ToolsQA"));
    }
}