package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;

public class FramesTest extends BaseTest {

    @Test
    public void testFrame() {

        FramesPage page = new FramesPage(driver);

        page.openPage();

        String text = page.getFrameText();

        Assert.assertTrue(text.contains("This is a sample page"));
    }
}