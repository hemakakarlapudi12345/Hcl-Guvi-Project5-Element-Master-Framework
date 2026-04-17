package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setReportName("ElementMaster Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}