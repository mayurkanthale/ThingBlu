package thingblu.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_LotEntry extends BasePage{

	public Mngr_LotEntry(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="grower")
	WebElement growserDrpDwn;
	@FindAll({ @FindBy(css="#grower>div>div:nth-child(4)>div>ul>li>span") })
	List<WebElement> growerList;
	
	@FindBy(id="strain")
	WebElement strainDrpDwn;
	@FindAll({@FindBy(css="#strain>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> strainList;

	@FindBy(id="growerlotno")
	WebElement growerLotNo;
	
	@FindBy(id="lottype")
	WebElement lotTypeDrpDwn;
	@FindAll({ @FindBy(css="#lottype>div>div:nth-child(4)>div>ul>li>span")})
	List<WebElement> lotTypeList;
	
	@FindBy(id="biotrweight")
	WebElement transferWeight;
	
	@FindBy(id="startweight")
	WebElement startWeight;
	
	@FindBy(id="costoflot")
	WebElement lotCost;
	
	@FindBy(id="shortOverWeight")
	WebElement shortOverWeight;
	
	@FindBy(css="p-dropdown[name='ddlStrain']")
	WebElement isTrimmed;
	@FindAll({ @FindBy(css="p-dropdown[name='ddlStrain']>div>div:nth-child(4)>div>ul>li>span") })
	List<WebElement> isTrimmedList;
	
	@FindBy(id="BUD_WT")
	WebElement enterBudweight;

	@FindBy(id = "JOINTS_WT")
	WebElement enterJointsWeight;

	@FindBy(id = "btnLotSave")
	WebElement saveBtn;

	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;

	@FindBy(id = "thc")
	WebElement THC;

	@FindBy(id = "thca")
	WebElement THCA;

	@FindBy(id = "cbd")
	WebElement CBD;

	@FindBy(id = "cbda")
	WebElement CBDA;

	@FindBy(id = "totalthc")
	WebElement totalTHC;

	public void selectGrower(String growerName) {
		selectItemFromDrpDwn(growserDrpDwn, growerList, growerName);
	}

	public void selectStrain(String strainName) {
		selectItemFromDrpDwn(strainDrpDwn, strainList, strainName);
	}

	public void clickOnStraiDrp(){
		click(strainDrpDwn);
		
	}
	public void matchStrain(String strainName){
		int a=76;
		for (int i = 1; i < strainList.size(); i++) {
			if (strainList.get(i).getText().equalsIgnoreCase(strainName)) {
				a=i;
				break;
			}
		}
		if (a<76) {
			System.out.println("Starin matched" + strainList.get(a).getText());
		}else {
			System.out.println("Starin not matched. Strain name: "+ strainList.get(a).getText());
		}
		
	}
	public void enterTHCValue(String THCValue) {
		enterData(THC, THCValue);
	}

	public void enterTHCAValue(String THCAValue) {
		enterData(THCA, THCAValue);
	}

	public void enterCBDvalue(String CBDvalue) {
		enterData(CBD, CBDvalue);
	}

	public void enterCBDAvalue(String CBDAvalue) {
		enterData(CBDA, CBDAvalue);
	}

	public void entertotalTHCVlaue(String totalTHCVlaue) {
		enterData(totalTHC, totalTHCVlaue);
	}

	public void enterLotnumber(String lotNumber) {
		enterData(growerLotNo, lotNumber);
	}

	public void selectLotType(String lotTypeName) {
		selectItemFromDrpDwn(lotTypeDrpDwn, lotTypeList, lotTypeName);
	}

	public void enterLotTransferWgt(String lotTransferWgt) {
		enterData(transferWeight, lotTransferWgt);
	}

	public void enterLotStartWgt(String lotStartWgt) {
		enterData(startWeight, lotStartWgt);
	}

	public void enterLotCost(String lotCostAmmount) {
		enterData(lotCost, lotCostAmmount);
	}

	public void selectIsTrimmedOption(String isTrimmedName) {
		selectItemFromDrpDwn(isTrimmed, isTrimmedList, isTrimmedName);
	}

	public void enterBudMaterialWeight(String budWeight) {
		enterData(enterBudweight, budWeight);
	}

	public void enterJointsMaterialWeight(String jointsWeight) {
		enterData(enterJointsWeight, jointsWeight);
	}

	public void mathcSumOfMaterial(String lotstartWeight, String lotBudWeight, String lotJouintsWeight) {
		float lotStartweight = Float.parseFloat(lotstartWeight);
		float totalWeight = Float.parseFloat(lotBudWeight) + Integer.parseInt(lotJouintsWeight);
		if (lotStartweight == totalWeight) {
			System.out.println("Lot start weight and sum of bud & joints materila is not match.");
		} else {
			System.out.println("Lot weight not match");
		}
	}

	public void clickOnSaveBtn() {
		click(saveBtn);
	}

	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}

}
