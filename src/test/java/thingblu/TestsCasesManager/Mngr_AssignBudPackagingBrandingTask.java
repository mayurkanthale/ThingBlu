package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;

public class Mngr_AssignBudPackagingBrandingTask extends Config {

	@Test
	public void verifyAssignGrindingTask() throws Exception {
		logInToApplicationAs("Manager");
		navigation.clickOnTaskMenuItem();
		Thread.sleep(2000);
		navigation.clickOnAssignTaskMenuItem();
		assignTaskPage.selectTask("A Bud Packaging & Branding");
		Thread.sleep(5000);
		assignTaskPage.selectS2OrderID("S-00045");
		Thread.sleep(5000);
		assignTaskPage.enterOrderItemQuantity("6");
		assignTaskPage.clickOnSelectLot("Blackberry Kush");
		assignTaskPage.selectLotAndEnterWeight("statelot02", "21");
		assignTaskPage.selectLotAndEnterWeight("L7887", "21");
		assignTaskPage.clickOnConfrimLotSelection();
		Thread.sleep(1000);
		assignTaskPage.clickOnSelectLot("Pacific Purple Urkle");
		assignTaskPage.selectLotAndEnterWeight("sf43", "42");
		assignTaskPage.clickOnConfrimLotSelection();
		assignTaskPage.selectEmployee("David Miller");
		assignTaskPage.clickOnAssignTaskBtn();
	}
}