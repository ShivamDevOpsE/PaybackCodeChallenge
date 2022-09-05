package stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    InputStream fis;
    Properties property;

    public void setUp() throws IOException {
        property = new Properties();
        fis = getClass().getClassLoader().getResourceAsStream("config.properties");
        property.load(fis);

        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/DynamicExtentReport.html");
        reporter.config().setDocumentTitle("Angular_SmokeTestReport");
        reporter.config().setReportName("SmokeTests");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Project Name", "Live Contract - Angular Version");
        extent.setSystemInfo("Tester", "Shivam Goyal");
        extent.setSystemInfo("Stage", "RC");
    }

    public void tearDown() {
        try {
            extent.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}