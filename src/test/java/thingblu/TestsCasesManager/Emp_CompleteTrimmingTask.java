package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;

public class Emp_CompleteTrimmingTask extends Config {

	@Test(dataProvider="TrimmingTaskComplete",  dataProviderClass = DataProviders.class)
	public void verifyCompleteTrimmingTask(String taskstartDate, String taskName, String growerName, String lotNo, String statusName, String actionName, String isCompleted, String budWeight, String taskComment){
		logInToApplicationAs("Employee");
		emp_dashboardCommon.selectStatusTab(taskstartDate);
		emp_dashboardCommon.empSelectTask(taskName, growerName, lotNo, statusName);
		emp_dashboardCommon.clcikOnButton(actionName);
		emp_trimmingTask.clickOnCheckBoxIfCompleted(isCompleted);
		emp_trimmingTask.enterUsableBudWeight(budWeight);
		emp_trimmingTask.entertaskComment(taskComment);
		emp_dashboardCommon.clcikOnButton(actionName);
	}
}