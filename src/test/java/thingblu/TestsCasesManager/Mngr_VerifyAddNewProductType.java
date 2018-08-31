package thingblu.TestsCasesManager;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;
import thingblu.utility.ReadPropertiesFile;

public class Mngr_VerifyAddNewProductType extends Config {

	@Test(dataProvider="SubBrandData", dataProviderClass = DataProviders.class)
	public void addNewSubBrandAndValidateStatus(HashMap<String, String> sbData) throws Exception {
		logInToApplicationAs("Manager");
		Thread.sleep(2000);
		navigation.clickOnAddNewSubBarndMenuItem();
		Thread.sleep(2000);
		mngr_subBrandMaster.selectBrandName(sbData.get("Brand"));
		mngr_subBrandMaster.enterSubBrandName(sbData.get("subBrand"));
		mngr_subBrandMaster.enterSubBrandDescription(sbData.get("Desc"));
		mngr_subBrandMaster.clickOnSaveBtn();
		Assert.assertEquals(mngr_subBrandMaster.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("saveSubBrand"), "Sub brand Not get successfully added.");
		System.out.println("Sub Brand Added Successfully");
		Thread.sleep(1000);
		mngr_subBrandMaster.searchAddedSubBrandInTable(sbData.get("Brand"), sbData.get("subBrand"));
	}
}
