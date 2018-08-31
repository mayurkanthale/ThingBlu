package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;
import thingblu.utility.DBConnect;
import thingblu.utility.ReadPropertiesFile;

public class Mngr_ReviewTrimmingTask extends Config{
	
	@Test(dataProvider="TrimmingTaskReview",  dataProviderClass = DataProviders.class)
	public void verifyReviewtrimmingTask( String empName, String task, String strain, String lot, String action,String budW, String oilW, String wasteW, String hrs, String Mins, String comment, String processedW ){
		logInToApplicationAs("Manager");
		mngr_dashboardCommon.mngrSelectTask(empName, task, strain, lot);
		mngr_dashboardCommon.clcikOnButton(action);
		mngr_trimmingTaskReview.enterTrimBudReviewWt(budW);
		mngr_trimmingTaskReview.enterTrimOilReviewWt(oilW);
		mngr_trimmingTaskReview.enterTrimWasteReviewWt(wasteW);
		mngr_dashboardCommon.enterActualHrs(hrs);
		mngr_dashboardCommon.enterActualMins(Mins);
		mngr_dashboardCommon.enterTrimReviewComment(comment);
		if (DBConnect.getDataFromDataBase(ReadPropertiesFile.getQueriesFromResource("getTrimmProcessedW")).equalsIgnoreCase(processedW)) {
			System.out.println("data is matched with database");
		}
		if (DBConnect.getDataFromDataBase(ReadPropertiesFile.getQueriesFromResource("getTrimmProcessedW")).equalsIgnoreCase(processedW)) {
			System.out.println("data is matched with database");
		}
	}
}
