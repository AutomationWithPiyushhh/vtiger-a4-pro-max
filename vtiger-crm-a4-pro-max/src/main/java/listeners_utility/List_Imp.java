package listeners_utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class List_Imp implements ITestListener {
	public ExtentReports report;

	@Override
	public void onStart(ITestContext context) {
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
	
	@Override
	public void onFinish(ITestContext context) {
//		report backup
		report.flush();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName();
		ExtentTest test = report.createTest(methodName);
		test.log(Status.PASS, methodName +" is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		ExtentTest test = report.createTest(methodName);
		test.log(Status.FAIL, methodName +" is failed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();
		ExtentTest test = report.createTest(methodName);
		test.log(Status.SKIP, methodName +" is skipped");
	}
}
