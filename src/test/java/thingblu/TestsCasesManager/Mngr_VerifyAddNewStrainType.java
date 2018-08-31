package thingblu.TestsCasesManager;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;
import thingblu.utility.ReadPropertiesFile;

public class Mngr_VerifyAddNewStrainType extends Config {

	@Test(dataProvider="StrainTYpes", dataProviderClass = DataProviders.class)
	public void addNewStrainTypeAndValidateStatus(HashMap<String, String> sbData) throws Exception {
		logInToApplicationAs("Manager");
		navigation.clickOnAddStrainTypeMenuItem();
		Thread.sleep(1000);
		mngr_strainTypeMaster.enterStrainTypeName("strainType");
		mngr_strainTypeMaster.enterStrainTypeDescription("Desc");
		mngr_strainTypeMaster.clickOnSaveBtn();
		Assert.assertEquals(mngr_strainTypeMaster.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("saveStrainType"), "Strain type saved successfully.");
		System.out.println("Strain Type Added Successfully");
		Thread.sleep(1000);
		mngr_strainTypeMaster.searchAddedStrainTypeInTable("strainType");
	}
}
