package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;

public class Emp_CompleteSiftingTask extends Config {

	@Test(dataProvider="SiftingTaskComplete",  dataProviderClass = DataProviders.class)
	public void verifyCompleteSiftingTask(String taskstartDate, String taskName, String growerName, String lotNo, String statusName, String actionName,  String budWeight,String jointsWeight, String oilWeight, String taskComment){
		logInToApplicationAs("Employee");
		emp_dashboardCommon.selectStatusTab(taskstartDate);
		emp_dashboardCommon.empSelectTask(taskName, growerName, lotNo, statusName);
		emp_dashboardCommon.clcikOnButton(actionName);
		emp_siftingTask.enterBudWeight(budWeight);
		emp_siftingTask.enterJointsWeight(jointsWeight);
		emp_siftingTask.enterOilsWeight(oilWeight);
		emp_siftingTask.enterTaskcomment(taskComment);
		emp_dashboardCommon.clcikOnButton(actionName);
		
	}
}