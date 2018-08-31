package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_AddNewStrain extends BasePage{

	public Mngr_AddNewStrain(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="straintype")
	WebElement strainTypeDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='straintype']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> strainTypeList;
	
	@FindBy(id="strain")
	WebElement enterStrainName;
	
	@FindBy(id="genetics")
	WebElement genticsDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='genetics']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> genticsList;
		
	@FindBy(id="btnStrainSave")
	WebElement clickSaveButton;
	
	@FindAll({ @FindBy(css = "p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr") })
	List<WebElement> starinTableRows;
	
	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	
	public void selectStrainTypeName(String strainType) {
		selectItemFromDrpDwn(strainTypeDrpDwn, strainTypeList, strainType);
	}
	
	public void selectGeneticsName(String geneticsName) {
		selectItemFromDrpDwn(genticsDrpDwn, genticsList, geneticsName);
	}
	
	public void enterStrainName(String strainName) {
		enterData(enterStrainName, strainName);
	}
	
	public void clickOnSaveBtn() {
		click(clickSaveButton);
	}
	
	public void clickOnEditForSubBrand(String strainName, String strainTypeName, String genetcisName) {
		for (int i = 1; i <starinTableRows.size()+1; i++) {
			WebElement strain= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			WebElement strainType= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
			WebElement genetics= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)"));
			if (strainName.equalsIgnoreCase(strain.getText()) && strainTypeName.equalsIgnoreCase(strainType.getText()) && genetcisName.equalsIgnoreCase(genetics.getText()) ) {
				System.out.println("Strain name is Matched.");
			String text=	driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(8)>p-inputswitch:nth-child(4)>div>div:nth-child(1)>span")).getText();
			System.out.println("text is : " +text);
			break;
			}
		}
	}
	
	public void searchAddedStrainNameInTable(String strainName, String strainTypeName, String genetcisName) {
		for (int i = 1; i <starinTableRows.size()+1; i++) {
			WebElement strain= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			WebElement strainType= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
			WebElement genetics= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)"));
			if (strainName.equalsIgnoreCase(strain.getText()) && strainTypeName.equalsIgnoreCase(strainType.getText()) && genetcisName.equalsIgnoreCase(genetics.getText()) ) {
				System.out.println("Strain name is Matched.");
				WebElement strainStatus= driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(8)>p-inputswitch:nth-child(4)>div>div:nth-child(4)>input"));
				//System.out.println("status attribute is : "+brandStatus.getAttribute("aria-label"));
				if (strainStatus.getAttribute("aria-label").equalsIgnoreCase("InputSwitch On")) {
					System.out.println("Starin Name Status is ON");
				}
				else {
					System.out.println("Starin Name Status is OFF");
				}
			}
		}
	}

	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}
}
