package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_AddNewProductType extends BasePage{

	public Mngr_AddNewProductType(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="brand")
	WebElement brandNameDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='brand']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> brandList;
	
	@FindBy(id="subBrand")
	WebElement subBrandNameDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='subBrand']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> subBrandList;
	
	@FindBy(id="strain")
	WebElement strainNameDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='strain']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> strainList;
	
	@FindBy(id="skewType")
	WebElement skewTypeNameDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='skewType']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement>skewTypeList;
	
	@FindBy(id="packageType")
	WebElement packageTypeNameDrpDwn;
	@FindAll({ @FindBy(css = "p-dropdown[id='packageType']>div>div:nth-child(4)>div:nth-child(2)>ul>li>span") })
	List<WebElement> packageTypeList;
	
	@FindBy(id="packageunit")
	WebElement enterpackageunit;
	
	@FindBy(id="packageitemquantity")
	WebElement enterPackageItemQuantity;
	
	@FindBy(id="packagelable")
	WebElement enterPackageLable;
	
	@FindBy(id="btnProductTypeSave")
	WebElement clickSaveButton;
	
	@FindAll({ @FindBy(css = "p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr") })
	List<WebElement> productTypeTableRows;
	
	@FindBy(css = "div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	
	public void selectBrandName(String brandName) {
		selectItemFromDrpDwn(brandNameDrpDwn, brandList, brandName);
	}
	
	public void selectSubBrandName(String subBrandName) {
		selectItemFromDrpDwn(subBrandNameDrpDwn, subBrandList, subBrandName);
	}
	
	public void selectStrainName(String strainName) {
		selectItemFromDrpDwn(strainNameDrpDwn, strainList, strainName);
	}
	
	public void selectSkewType(String skewTypeName) {
		selectItemFromDrpDwn(skewTypeNameDrpDwn, skewTypeList, skewTypeName);
	}
	
	public void selectPackageType(String packageTypeName) {
		selectItemFromDrpDwn(packageTypeNameDrpDwn, packageTypeList, packageTypeName);
	}
	
	public void enterPackageUnit(String packageUnit) {
		enterData(enterpackageunit, packageUnit);
	}
	
	public void enterPackageItemQty(String packageItmQty) {
		enterData(enterPackageItemQuantity, packageItmQty);
	}
	
	public void enterPackageLabel(String packageLable) {
		enterData(enterPackageLable, packageLable);
	}
	
	public void clickOnSaveBtn() {
		click(clickSaveButton);
	}

	// Check & modify
/*	public void clickOnEditForSubBrand(String brandName, String subBrandName) {
		for (int i = 1; i <productTypeTableRows.size()+1; i++) {
			WebElement brand= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			WebElement subBrand= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
			if (brandName.equalsIgnoreCase(brand.getText()) && subBrandName.equalsIgnoreCase(subBrand.getText()) ) {
				System.out.println("Record Matched.");
			String text=	driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(4)>p-inputswitch:nth-child(4)>div>div:nth-child(1)>span")).getText();
			System.out.println("text is : " +text);
			break;
			}
		}
	}*/
	
	
	public void searchAddedProductTypeInTable(String brandName, String subBrandName, String strainName, String skewType,String packageType, String packageUnit, String packageItemqty) {
		for (int i = 1; i <productTypeTableRows.size()+1; i++) {
			WebElement brand= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			WebElement subBrand= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
			WebElement strain= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)"));
			WebElement skew= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(4)"));
			WebElement packType= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));
			WebElement packUnit= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(6)"));
			WebElement packQty= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(7)"));
			if (brandName.equalsIgnoreCase(brand.getText()) && subBrandName.equalsIgnoreCase(subBrand.getText()) && strainName.equalsIgnoreCase(strain.getText()) && skewType.equalsIgnoreCase(skew.getText()) && packageType.equalsIgnoreCase(packType.getText()) && packageUnit.equalsIgnoreCase(packUnit.getText()) && packageItemqty.equalsIgnoreCase(packQty.getText())) {
				System.out.println("Record Matched.");
				WebElement brandStatus= driver.findElement(By.cssSelector("p-table[sortfield='CreatedDate']>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(9)>p-inputswitch:nth-child(4)>div>div:nth-child(4)>input"));
				//System.out.println("status attribute is : "+brandStatus.getAttribute("aria-label"));
				if (brandStatus.getAttribute("aria-label").equalsIgnoreCase("InputSwitch On")) {
					System.out.println("Product Type status is ON");
				}
				else {
					System.out.println("Product Type status is OFF");
				}
			}
		}
	}

	public String getAlertMessagePopUpText() {
		return alertMessagePopUp.getText();
	}
}
