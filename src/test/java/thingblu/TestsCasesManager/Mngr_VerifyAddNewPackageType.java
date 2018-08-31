package thingblu.TestsCasesManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.utility.ReadPropertiesFile;

public class Mngr_VerifyAddNewPackageType extends Config {

	@Test
	public void addNewPackageTypeAndValidateStatus() throws Exception {
		logInToApplicationAs("Manager");
		navigation.clickOnAddPackageTypeMenuItem();
		Thread.sleep(1000);
		mngr_packageTypeMaster.enterPackageTypeName("Auto Package");
		mngr_packageTypeMaster.enterPackageTypeDescription("auto description");
		mngr_packageTypeMaster.clickOnSaveBtn();
		Assert.assertEquals(mngr_packageTypeMaster.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("savePackageType"), "Package Type not get successfully added.");
		System.out.println("Package Type Added Successfully");
		Thread.sleep(1000);
		mngr_packageTypeMaster.searchAddedPckageTypeInTable("Auto Package");
	}
}
