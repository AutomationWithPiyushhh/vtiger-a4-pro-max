package learning_ad_rep;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class OrgTest {

	public ExtentReports report;

	@BeforeSuite
	public void repConfig() {

		String time = JavaUtility.getCurrentDateTime();

//		configure report
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/" + time + ".html");
		spark.config().setDocumentTitle("dummy title");
		spark.config().setReportName("dummy name");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("OS", "MAC");
		report.setSystemInfo("TESTER", "Rakshit");
		report.setSystemInfo("suite", "smoke");
		report.setSystemInfo("mode", "group");

	}

	@Test
	public void createOrgTest() {
		ExtentTest test = report.createTest("createOrgTest");
		test.log(Status.PASS, "this is passed");
	}

	@Test
	public void modifyOrgTest() {
//		generate report 
		ExtentTest test = report.createTest("modifyOrgTest");
		test.log(Status.FAIL, "this is passed");
	}

	@Test
	public void deleteOrgTest() {
//		generate report 
		ExtentTest test = report.createTest("deleteOrgTest");
		test.log(Status.SKIP, "this is passed");
	}

	@AfterSuite
	public void repBackup() {
//		report backup
		report.flush();
	}
}
