package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.utility.ExcelReader;

public class VerifyAddOrder2 extends Config {
	public int Rowcount = 1;
	String checkType = "";
	int totalrowcount = 1;

	@Test
	public void signInWithValidCredentials(String typeName) throws Exception {
		int panelNo = 0;
		navigation.clickOnOrderMenuItem();
		Thread.sleep(2000);
		navigation.clickOnOrderFormMenuItem();
		Thread.sleep(4000);
		orderEntryPage.selectRetailerName("Cokin");
		orderEntryPage.clickOnCalander("18");
		orderEntryPage.enterS2OrderID("98989954");
		typeName="Bud";
		if (checkType == "") {
			checkType = typeName;
			Rowcount++;
		} else if (checkType == typeName) {
			Rowcount++;
		} else {
			checkType = typeName;
			Rowcount = 2;

		}

		switch (typeName) {
		case "Bud":
			orderEntryPage.clickOnBudPlusIcon();
			panelNo = 2;
			break;

		case "Joints":
			orderEntryPage.clickOnJointsPlusIcon();
			panelNo = 3;
			break;

		case "Oil":
			orderEntryPage.clickOnOilPlusIcon();
			panelNo = 4;
			break;

		default:
		}

		orderEntryPage.selectBudBrand("El Ella", Rowcount, panelNo);
		orderEntryPage.selectBudSubBrand("-- Select --", Rowcount, panelNo);
		orderEntryPage.selectBudStrain("Blackberry Kush", Rowcount, panelNo);
		

		totalrowcount++;
		if (ExcelReader.getTotalRowCount("D:\\somanath\\automation_work\\ThingBluTest\\src\\test\\resources\\test-data\\orderEntryData.xls",
				"Sheet1") == totalrowcount) {
			orderEntryPage.clickOnSaveButton();
		}

	}
}