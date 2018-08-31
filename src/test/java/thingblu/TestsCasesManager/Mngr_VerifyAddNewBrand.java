package thingblu.TestsCasesManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.utility.ReadPropertiesFile;

public class Mngr_VerifyAddNewBrand extends Config {

	@Test
	public void addNewBrandAndValidateStatus() throws Exception {
		logInToApplicationAs("Manager");
		navigation.clickOnAddNewBarndMenuItem();
		Thread.sleep(1000);
		mngr_brandMaster.enterBrandName("BrandName 781");
		mngr_brandMaster.enterBrandDescription("decriptions of brand");
		mngr_brandMaster.clickOnSaveBtn();
		Assert.assertEquals(mngr_brandMaster.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("saveBrand"), "Brand Not get successfully added.");
		System.out.println("Brand Added Successfully");
		Thread.sleep(1000);
		mngr_brandMaster.searchAddedBrandInTable("BrandName 100");
		//mngr_brandMaster.searchAddedBrandInTable("BrandName 121a1");
	}
}
