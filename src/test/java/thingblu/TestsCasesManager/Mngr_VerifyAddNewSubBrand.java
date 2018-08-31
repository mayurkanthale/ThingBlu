package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;

public class Mngr_VerifyAddNewSubBrand extends Config {

	@Test
	public void addNewSubBrandAndValidateStatus() throws Exception {
		logInToApplicationAs("Manager");
		navigation.clickOnAddProductTypeMenuItem();
		Thread.sleep(1000);
		mngr_productTypeMaster.selectBrandName("Dope");
		mngr_productTypeMaster.selectSubBrandName("Distillate Dabs");
		mngr_productTypeMaster.selectStrainName("Kimbo Kush");
		mngr_productTypeMaster.selectSkewType("Bud");
		mngr_productTypeMaster.selectPackageType("BLISTER");
		mngr_productTypeMaster.enterPackageUnit("1");
		mngr_productTypeMaster.enterPackageItemQty("1");
		mngr_productTypeMaster.enterPackageLabel("1");
		mngr_productTypeMaster.clickOnSaveBtn();
//		Assert.assertEquals(mngr_productTypeMaster.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("saveSubBrand"), "Sub brand Not get successfully added.");
//		System.out.println("Sub Brand Added Successfully");
		Thread.sleep(1000);
		mngr_productTypeMaster.searchAddedProductTypeInTable("Dawg Star", "Traditional","Lodi Dodi","BUD","BAG","28","1");
	}
}
