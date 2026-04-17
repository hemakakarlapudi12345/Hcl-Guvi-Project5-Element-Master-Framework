package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = "screenshots/" + testName + "_" + timeStamp + ".png";

        try {
            // create folder if not exists
            new File("screenshots").mkdirs();

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePath;
    }
}