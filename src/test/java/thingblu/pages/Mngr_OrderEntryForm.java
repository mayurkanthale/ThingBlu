package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_OrderEntryForm extends BasePage {

	public Mngr_OrderEntryForm(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "retailers")
	WebElement retailerDrpDwn;

	@FindAll({ @FindBy(css = "#retailers>div>div:nth-child(5)>div:nth-child(2)>ul>li>span") })
	List<WebElement> retlrName;

	@FindBy(id = "deliverydate")
	WebElement clickClndr;

	@FindAll({ @FindBy(css = "table.ui-datepicker-calendar>tbody>tr") })
	List<WebElement> clndrDateRows;

	@FindAll({ @FindBy(css = "table.ui-datepicker-calendar>tbody>tr>td>a") })
	List<WebElement> clndrDates;

	@FindBy(id = "orderrefid")
	WebElement OrderIdInput;

	@FindBy(css = "div[formarrayname='aBudItems']>a")
	WebElement budplusIcon;

	@FindBy(css = "div=[formarrayname='aBudItems']>div>div:nth-child(2)>div>div>p-dropdown>div>div:nth-child(4)>div:nth-child(2)>ul>li>span")
	WebElement s;

	@FindBy(css = "p-fieldset[legend='B Joints Order Details']>fieldset>div>div>div>a")
	WebElement jointsplusIcon;

	@FindBy(css = "div[formarrayname='cOilItems']>a")
	WebElement oilplusIcon;
	
	@FindBy(css="form>div:nth-child(5)>button[label='Save']")
	WebElement submitbutton;
	
	@FindBy(css="p-panel[ng-reflect-header='Order Request Form']")
	WebElement panelHeader;
	
	public void selectRetailerName(String retailerName) {
		scrollToElement(panelHeader);
		selectItemFromDrpDwn(retailerDrpDwn, retlrName, retailerName);
	}

	public void clickOnCalander(String date) {
		scrollToElement(panelHeader);
		click(clickClndr);
		for (int i = 1; i < clndrDates.size(); i++) {
			if (clndrDates.get(i).getText().equalsIgnoreCase(date)) {
				clndrDates.get(i).click();
				break;
			}
		}
	}

	public void enterS2OrderID(String s2OrderID) {
		scrollToElement(panelHeader);
		enterData(OrderIdInput, s2OrderID);
	}

	public void clickOnBudPlusIcon() {
		scrollToElement(budplusIcon);
		click(budplusIcon);
	}

	public void clickOnOilPlusIcon() {
		scrollToElement(oilplusIcon);
		click(oilplusIcon);
	}
	
	public void clickOnSaveButton(){
		click(submitbutton);
	}

	public void clickonbrand() {
		WebElement clickOnBudBrand = driver.findElement(By.cssSelector(
				"div>form>p-fieldset:nth-child(2)>fieldset>div:nth-child(2)>div>div>div>div:nth-child(2)>div>div>p-dropdown"));
		clickOnBudBrand.click();
	}
	
	public void seletType(String typeName){
		
	}
	
	public void clickOnJointsPlusIcon() {
		scrollToElement(jointsplusIcon);
		click(jointsplusIcon);
	}

	public void selectBudBrand(String budBrandName, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnBudBrand = driver.findElement(By.cssSelector("div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(1)>p-dropdown"));
			clickOnBudBrand.click();
			Thread.sleep(1000);
			String rowinterator = "div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(1)>p-dropdown>div>div:nth-child(4)>div:nth-child(2)>ul>li>span";
			List<WebElement> budBrandList = driver.findElements(By.cssSelector(rowinterator));
			for (int i = 1; i < budBrandList.size()+1; i++) {
				if (budBrandList.get(i).getText().equalsIgnoreCase(budBrandName)) {
					budBrandList.get(i).click();
					break;
				}
			}
			break;
		}
	}

	public void selectBudSubBrand(String budSubBrandName, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnSubBudBrand = driver.findElement(By.cssSelector("div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(2)>p-dropdown"));
			clickOnSubBudBrand.click();
			Thread.sleep(1000);
			String rowinterator = "div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(2)>p-dropdown>div>div:nth-child(4)>div:nth-child(2)>ul>li>span";
			List<WebElement> budSubBrandList = driver.findElements(By.cssSelector(rowinterator));

			for (int i = 1; i < budSubBrandList.size(); i++) {
				if (budSubBrandList.get(i).getText().equalsIgnoreCase(budSubBrandName)) {
					budSubBrandList.get(i).click();
					break;
				}
			}
			break;
		}
	}

	public void selectBudStrain(String budStrainName, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnBudStrain = driver.findElement(By.cssSelector("div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(3)>p-dropdown"));
			clickOnBudStrain.click();
			Thread.sleep(1000);
			String rowinterator = "div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(3)>p-dropdown>div>div:nth-child(4)>div:nth-child(2)>ul>li>span";
			List<WebElement> budStrainList = driver.findElements(By.cssSelector(rowinterator));
			for (int i = 1; i < budStrainList.size()+1; i++) {
				if (budStrainList.get(i).getText().equalsIgnoreCase(budStrainName)) {
					budStrainList.get(i).click();
					break;
				}
			}
			break;
		}
	}

	public void selectBudPackageType(String budPackName, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnBudPackType = driver.findElement(By.cssSelector("div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(4)>p-dropdown"));
			clickOnBudPackType.click();
			Thread.sleep(1000);
			String rowinterator = "div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(4)>p-dropdown>div>div:nth-child(4)>div>ul>li>span";
			List<WebElement> budPackTypeList = driver.findElements(By.cssSelector(rowinterator));
			for (int i = 1; i < budPackTypeList.size()+1; i++) {
				if (budPackTypeList.get(i).getText().equalsIgnoreCase(budPackName)) {
					budPackTypeList.get(i).click();
					break;
				}
			}
			break;
		}
	}

	public void selectBudPackageSize(String budPackSizeName, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnBudPackSize = driver.findElement(By.cssSelector("div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(5)>p-dropdown"));
			clickOnBudPackSize.click();
			Thread.sleep(1000);
			String rowinterator = "div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(5)>p-dropdown>div>div:nth-child(4)>div>ul>li>span";
			List<WebElement> budPackSizeList = driver.findElements(By.cssSelector(rowinterator));
			for (int i = 1; i < budPackSizeList.size()+1; i++) {
				if (budPackSizeList.get(i).getText().equalsIgnoreCase(budPackSizeName)) {
					budPackSizeList.get(i).click();
					break;
				}
			}
			break;
		}
	}

	public void selectBudPackageItemQty(String budPackItemQty, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnBudPackItemQty = driver.findElement(By.cssSelector("div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(6)>p-dropdown"));
			clickOnBudPackItemQty.click();
			Thread.sleep(1000);
			String rowinterator = "div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(6)>p-dropdown>div>div:nth-child(4)>div>ul>li>span";
			List<WebElement> budPackItemQtyList = driver.findElements(By.cssSelector(rowinterator));
			for (int i = 1; i < budPackItemQtyList.size()+1; i++) {
				if (budPackItemQtyList.get(i).getText().equalsIgnoreCase(budPackItemQty)) {
					budPackItemQtyList.get(i).click();
					break;
				}
			}
			break;
		}
	}

	public void enterOrderQty(String orderQnty, int rowNo, int panelNo) throws Exception {
		for (int j = rowNo; j > 0;) {
			WebElement clickOnBudPackItemQty = driver.findElement(By.cssSelector(
					"div>form>p-fieldset:nth-child("+panelNo+")>fieldset>div:nth-child(2)>div>div>div>div:nth-child("+j+")>div>div:nth-child(7)>input"));
			clickOnBudPackItemQty.click();
			clickOnBudPackItemQty.sendKeys(orderQnty);
			break;
		}
	}
}
