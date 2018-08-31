package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_AddNewSubBrand extends BasePage{

	public Mngr_AddNewSubBrand(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="brand")
	WebElement brandNameDrpDwn;
	
	@FindAll({ @FindBy(css = "p-dropdown[id='brand']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> brandList;
	
	@FindBy(id="subbrand")
	WebElement enterSubBrandName;
	
	@FindBy(id="description")
	WebElement entersubBrandDescription;
	
	@FindBy(id="btnProductTypeSave")
	WebElement clickSaveButton;
	
	@FindAll({ @FindBy(css = "p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr") })
	List<WebElement> SubBrandTableRows;
	
	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	
	public void selectBrandName(String brandName) {
		selectItemFromDrpDwn(brandNameDrpDwn, brandList, brandName);
	}
	
	public void enterSubBrandName(String subBrandName) {
		enterData(enterSubBrandName, subBrandName);
	}
	
	public void enterSubBrandDescription(String subBrandDesc) {
		enterData(entersubBrandDescription, subBrandDesc);
	}
	
	public void clickOnSaveBtn() {
		click(clickSaveButton);
	}
	
	public void clickOnEditForSubBrand(String brandName, String subBrandName) {
		for (int i = 1; i <SubBrandTableRows.size()+1; i++) {
			WebElement brand= driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			WebElement subBrand= driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
			if (brandName.equalsIgnoreCase(brand.getText()) && subBrandName.equalsIgnoreCase(subBrand.getText()) ) {
				System.out.println("Record Matched.");
			String text=	driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(4)>p-inputswitch:nth-child(4)>div>div:nth-child(1)>span")).getText();
			System.out.println("text is : " +text);
			break;
			}
		}
	}
	
	public void searchAddedSubBrandInTable(String brandName, String subBrandName) {
		for (int i = 1; i <SubBrandTableRows.size()+1; i++) {
			WebElement brand= driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			WebElement subBrand= driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
			if (brandName.equalsIgnoreCase(brand.getText()) && subBrandName.equalsIgnoreCase(subBrand.getText()) ) {
				System.out.println("Record Matched.");
				WebElement brandStatus= driver.findElement(By.cssSelector("p-table[sortfield='SubBrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(4)>p-inputswitch:nth-child(4)>div>div:nth-child(4)>input"));
				//System.out.println("status attribute is : "+brandStatus.getAttribute("aria-label"));
				if (brandStatus.getAttribute("aria-label").equalsIgnoreCase("InputSwitch On")) {
					System.out.println("sub brand Status is ON");
				}
				else {
					System.out.println("sub brand Status is OFF");
				}
			}
		}
	}

	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}
}
