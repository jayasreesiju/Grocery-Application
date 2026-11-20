package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	//^^ . represents the local directory path of the project, slash creates a folder called extent-reports,
	//extent-report is the html file name
	reporter.config().setReportName("7RMartSupermarketProject");
	//^^Reportname have to set as 7RMartSupermarketProject
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", " Sona"); // provides context of the report
	//setSystemInfo method used to provide the context of the report
	return extentReports;
	}

}
