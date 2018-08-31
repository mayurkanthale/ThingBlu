package thingblu.TestsCasesManager;

import org.testng.annotations.Test;

import thingblu.core.Config;

public class Mngr_VerifyAddNewStrain extends Config {

	@Test
	public void addAddNewStrainAndValidateStatus() throws Exception {
		logInToApplicationAs("Manager");
		Thread.sleep(1000);
		navigation.clickOnMenuItem("New Strain");
		Thread.sleep(1000);
		mngr_strainMaster.selectStrainTypeName("Hybrid");
		mngr_strainMaster.selectGeneticsName("Genetics-1");
		mngr_strainMaster.enterStrainName("365");
//		mngr_strainMaster.clickOnSaveBtn();
//		Assert.assertEquals(mngr_productTypeMaster.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("saveSubBrand"), "Sub brand Not get successfully added.");
//		System.out.println("Sub Brand Added Successfully");
		Thread.sleep(1000);
		mngr_strainMaster.searchAddedStrainNameInTable("ew","Indica", "Genetics-1");
	}
}
