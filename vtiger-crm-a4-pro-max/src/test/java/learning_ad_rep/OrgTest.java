package learning_ad_rep;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OrgTest {
	@Test
	public void createOrgTest() {
//		configure report
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/adRep.html");
		spark.config().setDocumentTitle("dummy title");
		spark.config().setReportName("dummy name");
		spark.config().setTheme(Theme.STANDARD);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("OS", "MAC");
		report.setSystemInfo("TESTER", "Rakshit");
		report.setSystemInfo("suite", "smoke");
		report.setSystemInfo("mode", "group");

//		generate report 
		ExtentTest test = report.createTest("createOrgTest");
		test.log(Status.PASS, "this is passed");
		test.log(Status.FAIL, "this is failed");
		test.log(Status.SKIP, "this is skipped");

//		report backup
		report.flush();
	}
}
