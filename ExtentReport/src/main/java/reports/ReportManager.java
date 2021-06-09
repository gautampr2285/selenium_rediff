package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	static ExtentReports reports;
	ExtentTest test;
	
	public static ExtentReports getReports() {
		
		if (reports == null) { // this will check if reports is intialized ot not
			
			reports = new ExtentReports();
			ExtentSparkReporter sparkReports = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports");
			sparkReports.config().setReportName("Report for Autoation");
			sparkReports.config().setDocumentTitle("Execution Status");
			sparkReports.config().setTheme(Theme.DARK);
			sparkReports.config().setEncoding("utf-8");
			
			reports.attachReporter(sparkReports);
		}
		return reports;	
			
	}
	
	
}
	

