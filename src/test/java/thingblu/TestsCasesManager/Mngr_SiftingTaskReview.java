package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;

public class Mngr_SiftingTaskReview extends Config{

	@Test
	public void VerifySiftingTaskreview() throws Exception{
		logInToApplicationAs("Manager");
		mngr_dashboardCommon.mngrSelectTask("David Miller", "Sifting", "9LB Hammer", "1");
		mngr_dashboardCommon.clcikOnButton("Review");
		Thread.sleep(5000);
		mngr_siftingTaskReview.enterSiftBudReviewWt("12");
		mngr_siftingTaskReview.enterSiftJointsReviewWt("10");
		mngr_siftingTaskReview.enterSiftOilReviewWt("15");
		mngr_dashboardCommon.enterActualHrs("54");
		mngr_dashboardCommon.enterActualMins("45");
		mngr_dashboardCommon.enterTrimReviewComment("This is automation comment text for trommong task review.");
	}
}
