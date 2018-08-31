package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;
import thingblu.utility.ExcelReader;

public class Mngr_AddNewOrder extends Config {
	public int Rowcount = 1;
	String checkType = "";
	int totalrowcount = 1;

	@Test(dataProvider = "Apackdata", dataProviderClass = DataProviders.class)
	public void signInWithValidCredentials(String typeName, String brand, String subBrand, String strain,
			String packType, String packSize, String packQty, String orderItemQty) throws Exception {
		int panelNo = 0;
		navigation.clickOnOrderMenuItem();
		Thread.sleep(2000);
		navigation.clickOnOrderFormMenuItem();
		Thread.sleep(4000);
		orderEntryPage.selectRetailerName("Cokin");
		orderEntryPage.clickOnCalander("18");
		orderEntryPage.enterS2OrderID("98989954");
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

		orderEntryPage.selectBudBrand(brand, Rowcount, panelNo);
		orderEntryPage.selectBudSubBrand(subBrand, Rowcount, panelNo);
		orderEntryPage.selectBudStrain(strain, Rowcount, panelNo);
		orderEntryPage.selectBudPackageType(packType, Rowcount, panelNo);
		orderEntryPage.selectBudPackageSize(packSize, Rowcount, panelNo);
		orderEntryPage.selectBudPackageItemQty(packQty, Rowcount, panelNo);
		orderEntryPage.enterOrderQty(orderItemQty, Rowcount, panelNo);

		totalrowcount++;
		if (ExcelReader.getTotalRowCount("D:\\somanath\\automation_work\\ThingBluTest\\src\\test\\resources\\test-data\\orderEntryData.xls",
				"Sheet1") == totalrowcount) {
			orderEntryPage.clickOnSaveButton();
		}

	}
}