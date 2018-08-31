package thingblu.TestsCasesManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import thingblu.core.Config;
import thingblu.core.DataProviders;
import thingblu.utility.DBConnect;
import thingblu.utility.ReadPropertiesFile;

public class Mngr_AddNewLotEntry extends Config {

	@Test(dataProvider = "LotEntryData", dataProviderClass = DataProviders.class)
	public void verifyLotEntry(String growerName, String StrainName,  String THC,  String THCA, String CBD ,String CBDA, String totalTHC,String lotNo, String materialType,
			String transferWeight, String startWeight, String lotcost) throws Exception {
		logInToApplicationAs("Manager");
		navigation.clickOnNewLOtMenuItem();
		Thread.sleep(2000);
		lotEntryPage.selectGrower(growerName);
		lotEntryPage.selectStrain(StrainName);
		lotEntryPage.enterTHCValue(THC);
		lotEntryPage.enterTHCAValue(THCA);
		lotEntryPage.enterCBDAvalue(CBD);
		lotEntryPage.enterCBDAvalue(CBDA);
		lotEntryPage.entertotalTHCVlaue(totalTHC);
		lotEntryPage.enterLotnumber(lotNo);
		lotEntryPage.selectLotType(materialType);
		lotEntryPage.enterLotTransferWgt(transferWeight);
		lotEntryPage.enterLotStartWgt(startWeight);
		lotEntryPage.enterLotCost(lotcost);
		lotEntryPage.clickOnSaveBtn();
		Assert.assertEquals(lotEntryPage.getAlertMessagePopUpText(),ReadPropertiesFile.getDataFromProperties("successfulTaskAssign"));
		System.out.println("Lot details saved successfully.");
		Assert.assertEquals(DBConnect.getDataFromDataBase(startWeight),"200", "Start weight is not matched with database values.");
		System.out.println("data is matched with database");

	}
	
	@Test(dataProvider ="LotEntryDataIsTrimmedTrue", dataProviderClass=DataProviders.class)
	public void verifyLotEntryWithTrimmedYes(String growerName, String StrainName, String THC,  String THCA, String CBD ,String CBDA, String totalTHC, String lotNo, String materialType, String transferWeight, String startWeight, String lotcost, String isTrimmed, String budWeight, String jointsWeight  ) throws Exception{
		logInToApplicationAs("Manager");
		navigation.clickOnNewLOtMenuItem();
		Thread.sleep(2000);
		lotEntryPage.selectGrower(growerName);
		lotEntryPage.selectStrain(StrainName);
		lotEntryPage.enterTHCValue(THC);
		lotEntryPage.enterTHCAValue(THCA);
		lotEntryPage.enterCBDAvalue(CBD);
		lotEntryPage.enterCBDAvalue(CBDA);
		lotEntryPage.entertotalTHCVlaue(totalTHC);
		lotEntryPage.enterLotnumber(lotNo);
		lotEntryPage.selectLotType(materialType);
		lotEntryPage.enterLotTransferWgt(transferWeight);
		lotEntryPage.enterLotStartWgt(startWeight);
		lotEntryPage.enterLotCost(lotcost);
		lotEntryPage.selectIsTrimmedOption(isTrimmed);
		lotEntryPage.enterBudMaterialWeight(budWeight);
		lotEntryPage.enterJointsMaterialWeight(jointsWeight);
		lotEntryPage.mathcSumOfMaterial(startWeight,budWeight,jointsWeight);
		lotEntryPage.clickOnSaveBtn();
		Assert.assertEquals(lotEntryPage.getAlertMessagePopUpText(), ReadPropertiesFile.getDataFromProperties("successfulTaskAssign"));
		System.out.println("Task is successfully assigned.");
	}


}
