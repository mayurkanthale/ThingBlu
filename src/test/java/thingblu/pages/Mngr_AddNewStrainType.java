package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_AddNewStrainType extends BasePage{

	public Mngr_AddNewStrainType(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="straintype")
	WebElement enterStrainType;
	
	@FindBy(id="description")
	WebElement enterStrainTypeDescription;
	
	@FindBy(id="btnStrainTypeSave")
	WebElement clickSaveButton;
	
	@FindAll({ @FindBy(css = "p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr") })
	List<WebElement> strainTypeTableRows;
	
	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	String table="";
	public void enterStrainTypeName(String strainTypeName) {
		enterData(enterStrainType, strainTypeName);
	}
	
	public void enterStrainTypeDescription(String strainTypeDesc) {
		enterData(enterStrainTypeDescription,strainTypeDesc);
	}
	
	/**
	 * @author Mayur Kanthale
	 */
	public void clickOnSaveBtn() {
		click(clickSaveButton);
	}
	
	/**
	 * 
	 * @param strainTypeName
	 */
	public void searchAddedStrainTypeInTable(String strainTypeName) {
		for (int i = 1; i <strainTypeTableRows.size()+1; i++) {
			WebElement strainType= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			if (strainTypeName.equalsIgnoreCase(strainType.getText())) {
				System.out.println("Strain Type Name Matched.");
				WebElement brandStatus= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)>p-inputswitch:nth-child(4)>div>div:nth-child(4)>input"));
				//System.out.println("status attribute is : "+brandStatus.getAttribute("aria-label"));
				if (brandStatus.getAttribute("aria-label").equalsIgnoreCase("InputSwitch On")) {
					System.out.println("Strain Type Status is ON.");
				}
				else {
					System.out.println("Strain Type Status is OFF.");
				}
			}
		}
	}

	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}
}
