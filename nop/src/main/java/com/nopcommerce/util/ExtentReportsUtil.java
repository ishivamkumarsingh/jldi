package com.nopcommerce.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtil {
    private static ExtentReports extent;
    private static ExtentTest test;
    
    public static ExtentReports getExtentReport() {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/ExtentReport.html");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
    
    public static ExtentTest createTest(String testName) {
        test = getExtentReport().createTest(testName);
        return test;
    }
    
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}


