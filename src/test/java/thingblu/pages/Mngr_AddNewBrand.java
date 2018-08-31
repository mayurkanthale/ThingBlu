package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_AddNewBrand extends BasePage{

	public Mngr_AddNewBrand(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="brand")
	WebElement enterBrandName;
	
	@FindBy(id="description")
	WebElement enterBrandDescription;
	
	@FindBy(id="btnProductTypeSave")
	WebElement clickSaveButton;
	
	@FindAll({ @FindBy(css = "p-table[sortfield='BrandId']>div>div:nth-child(2)>table>tbody>tr") })
	List<WebElement> brandTableRows;
	
	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	
	int count=1;

	String table="";
	public void enterBrandName(String brandName) {
		enterData(enterBrandName, brandName);
	}
	
	public void enterBrandDescription(String brandDesc) {
		enterData(enterBrandDescription, brandDesc);
	}
	
	public void clickOnSaveBtn() {
		click(clickSaveButton);
	}
	

	public void searchAddedBrandInTable(String brandName) {
		for (count = 1; count <brandTableRows.size()+1; count++) {
			WebElement brand= driver.findElement(By.cssSelector("p-table[sortfield='BrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+count+")>td:nth-child(1)"));
			WebElement brandStatus= driver.findElement(By.cssSelector("p-table[sortfield='BrandId']>div>div:nth-child(2)>table>tbody>tr:nth-child("+count+")>td:nth-child(3)>p-inputswitch:nth-child(4)>div>div:nth-child(4)>input"));
			if (brandName.equalsIgnoreCase(brand.getText())) {
				System.out.println("Brand Name Matched.");
				if (brandStatus.getAttribute("aria-label").equalsIgnoreCase("InputSwitch On")) {
					System.out.println("brand Status is ON");
				}
			}
		}
	}
	
	//WebElement msgText= p-confirmdialog>div>div:nth-child(2)>span;
	// WebElement clickOnYes=p-confirmdialog>div>div:nth-child(3)>button:nth-child(1)
	

	
	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}
}
