package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_AddNewPackageType extends BasePage{

	public Mngr_AddNewPackageType(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="packagetype")
	WebElement enterPackageTypName;
	
	@FindBy(id="description")
	WebElement enterPackageDescription;
	
	@FindBy(id="btnProductTypeSave")
	WebElement clickSaveButton;
	
	@FindAll({ @FindBy(css = "p-table[sortfield='PkgTypeId']>div>div:nth-child(2)>table>tbody>tr") })
	List<WebElement> packageTypeTableRows;
	
	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	String table="";
	public void enterPackageTypeName(String packageName) {
		enterData(enterPackageTypName, packageName);
	}
	
	public void enterPackageTypeDescription(String packageDesc) {
		enterData(enterPackageDescription, packageDesc);
	}
	
	public void clickOnSaveBtn() {
		click(clickSaveButton);
	}
	
	public void clickOnEdit(String packageName) {
		for (int i = 1; i <packageTypeTableRows.size()+1; i++) {
			WebElement packageType= driver.findElement(By.cssSelector("p-table[sortfield='PkgTypeId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			if (packageName.equalsIgnoreCase(packageType.getText())) {
				System.out.println("Package Type Name Matched.");
			String text=	driver.findElement(By.cssSelector("p-table[sortfield='PkgTypeId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)>p-inputswitch:nth-child(4)>div>div:nth-child(1)>span")).getText();
			System.out.println("text is : " +text);
			break;
			}
		}
	}
	
	public void searchAddedPckageTypeInTable(String packageName) {
		for (int i = 1; i <packageTypeTableRows.size()+1; i++) {
			WebElement packageType= driver.findElement(By.cssSelector("p-table[sortfield='PkgTypeId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			if (packageName.equalsIgnoreCase(packageType.getText())) {
				System.out.println("Package Type Name Matched.");
				WebElement brandStatus= driver.findElement(By.cssSelector("p-table[sortfield='PkgTypeId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)>p-inputswitch:nth-child(4)>div>div:nth-child(4)>input"));
				//System.out.println("status attribute is : "+brandStatus.getAttribute("aria-label"));
				if (brandStatus.getAttribute("aria-label").equalsIgnoreCase("InputSwitch On")) {
					System.out.println("Package Type Status is ON");
				}
				else {
					System.out.println("Package Type Status is OFF");
				}
			}
		}
	}

	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}
}
