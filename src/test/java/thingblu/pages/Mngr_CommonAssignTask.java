package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_CommonAssignTask extends BasePage {
	public Mngr_CommonAssignTask(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "taskname")
	WebElement clickOnTaskDrpDwn;
	@FindAll({ @FindBy(css = "#taskname>div>div:nth-child(5)>div:nth-child(2)>ul>li>span") })
	List<WebElement> selectTaskFromDrpDwn;
	
	@FindBy(id = "strain")
	WebElement clickOnStrainDrpDwn;
	@FindAll({ @FindBy(css = "#strain>div>div:nth-child(5)>div:nth-child(2)>ul>li>span") })
	List<WebElement> selectStarinFromDrpDwn;
	
	@FindBy(id = "lotno")
	WebElement clicLotDrpDwn;
	@FindAll({ @FindBy(css = "#lotno>div>div:nth-child(5)>div:nth-child(2)>ul>li>span") })
	List<WebElement> selectLotFromDrpDwn;
	
	@FindBy(css = "label[for='strain']+div+div+span")
	WebElement getStrainName;
	@FindBy(id = "employee")
	WebElement clickOnEmpDrpDwn;
	
	@FindAll({ @FindBy(css = "#employee>div>div:nth-child(5)>div:nth-child(2)>ul>li>span") })
	List<WebElement> selectEmpFromDrpDwn;
	
	@FindBy(css = "label[for='lotWeight']+div+span")
	WebElement getLotWeigth;
	
	@FindBy(id = "estimatedstartdate")
	WebElement clickOnClndr;
	
	@FindAll({ @FindBy(css = "table.ui-datepicker-calendar>tbody>tr>td>a") })
	List<WebElement> clndrDates;
	
	@FindBy(id = "priority")
	WebElement clickOnPriorityDrpDwn;
	@FindAll({ @FindBy(css = "#priority>div>div:nth-child(5)>div>ul>li>span") })
	List<WebElement> selectPriorityFromDrpDwn;
	
	@FindAll({ @FindBy(css = "p-checkbox>label") })
	List<WebElement> notifyCheckBox;
	
	@FindBy(id = "comment")
	WebElement enterTaskComment;
	
	@FindBy(css="button[label='Assign Task']")
	WebElement assignTaskBtn;
	
	@FindBy(css="div[class='ui-growl-message']>p")
	WebElement alertMessagePopUp;
	
	@FindBy(id="assignwt")
	WebElement assignWt;
	
	// for orders
	@FindBy(id="orderno")
	WebElement clickOnOrderDrpDwn;
	@FindAll({ @FindBy(css = "#orderno>div>div:nth-child(5)>div:nth-child(2)>ul>li>span") })
	List<WebElement> selectS2OrderNoFromDrpDwn;
	
	@FindAll({ @FindBy(css = "div[formarrayname='budOrderPackets']>p-table>div>div>table>tbody>tr>td") })
	List<WebElement> checkOrderItemsData;
	
	@FindBy(id="btnLotSelectionConfirm")
	WebElement lotSelectionConfBtn;
	
	
	
	
	/**
	 * select trimming task from task list drop down.
	 * @param taskName
	 */
	public void selectTask(String taskName) {
		selectItemFromDrpDwn(clickOnTaskDrpDwn, selectTaskFromDrpDwn, taskName);
	}
	
	/**
	 * select strain from strain list drop down to get lots.
	 * @param strainName pass valid strain name.
	 */
	public void selectStarin(String strainName) {
		selectItemFromDrpDwn(clickOnStrainDrpDwn, selectStarinFromDrpDwn, strainName);
	}
	

	/**
	 * Select lot number from lot drop down for trimming task.
	 * @param lotNumber
	 */
	public void selectLotNumber(String lotNumber) {
		selectItemFromDrpDwn(clicLotDrpDwn, selectLotFromDrpDwn, lotNumber);
	}

	public void getStrainName() {
		System.out.println("Strain name is : " + getStrainName.getText());
	}

	public void selectEmployee(String empName) {
		selectItemFromDrpDwn(clickOnEmpDrpDwn, selectEmpFromDrpDwn, empName);
	}

	public void getLotWeight() {
		System.out.println("Lot weight is : " + getLotWeigth.getText());
	}

	public void selectStartDate(String date) {
		click(clickOnClndr);
		for (int i = 1; i < clndrDates.size(); i++) {
			if (clndrDates.get(i).getText().equalsIgnoreCase(date)) {
				clndrDates.get(i).click();
				break;
			}
		}
	}

	public void selectTaskPriority(String priorityName) {
		selectItemFromDrpDwn(clickOnPriorityDrpDwn, selectPriorityFromDrpDwn, priorityName);
	}

	public void notifyChkBx(String makeCheckboxStatus, String notifyRole) {
		checkCheckboxStatusAndSelect(makeCheckboxStatus, notifyCheckBox, notifyRole);
	}

	public void enterTaskComment(String commentText) {
		enterData(enterTaskComment, commentText);
	}

	public void enterAssignwt(String assignWgt){
		enterData(assignWt, assignWgt);
	}
	public void clickOnAssignTaskBtn(){
		click(assignTaskBtn);
	}

	
	public String getAlertMessagePopUpText(){
		return alertMessagePopUp.getText();
	}
	
	public void selectS2OrderID(String s2OrderID) {
		selectItemFromDrpDwn(clickOnOrderDrpDwn, selectS2OrderNoFromDrpDwn, s2OrderID);
	}
	
	public void getOrderData(){
		for (int i = 1; i < checkOrderItemsData.size()-1; i++) {
		}
	}
	
	@FindAll({ @FindBy(css = "input[formcontrolname='assignPackageWt']") })
	List<WebElement> assignOrderItemQuantity;
	
	public void enterOrderItemQuantity(String orderQuantity){
			
			for (int j = 1; j < assignOrderItemQuantity.size()+1 ; j++) {
				String orderPackInputBox= "div[formarrayname='budOrderPackets']>p-table>div>div>table>tbody>tr:nth-child("+j+")>td>input";
				WebElement orderQtyIputBox= driver.findElement(By.cssSelector(orderPackInputBox));
				enterData(orderQtyIputBox, orderQuantity);
			}
	}
	
	@FindAll({@FindBy(css="form>div>app-bud-packaging>div>div:nth-child(4)>p-table>div>div>table>tbody>tr")})
	List<WebElement> strainRowCount;
	
	public void clickOnSelectLot(String strainName){
		for (int i = 1; i < strainRowCount.size()+1; i++) {
			WebElement strainNameOrderDetails= driver.findElement(By.cssSelector("form>div>app-bud-packaging>div>div:nth-child(4)>p-table>div>div>table>tbody>tr:nth-child("+i+")>td:nth-child(1)"));
			if (strainNameOrderDetails.getText().equalsIgnoreCase(strainName)) {
				WebElement clickOnSelectLotText = driver.findElement(By.cssSelector("form>div>app-bud-packaging>div>div:nth-child(4)>p-table>div>div>table>tbody>tr:nth-child("+i+")>td:nth-child(2)>a"));
				scrollToElement(clickOnSelectLotText);
				clickOnSelectLotText.click();
			}
			
		}
	}
	
	@FindAll({@FindBy(css="p-table[id='tblLotSelection']>div>div>table>tbody>tr")})
	List<WebElement> lotRowsPopUp;
	
	public void selectLotAndEnterWeight(String stateLotNo , String assignWeight){
		for (int i = 1; i < lotRowsPopUp.size()+1; i++) {
			WebElement getLotNumber=driver.findElement(By.cssSelector("p-table[id='tblLotSelection']>div>div>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>p-checkbox>label"));
			if (getLotNumber.getText().equalsIgnoreCase(stateLotNo)) {
				getLotNumber.click();
				WebElement enterWeight=driver.findElement(By.cssSelector("p-table[id='tblLotSelection']>div>div>table>tbody>tr:nth-child("+i+")>td:nth-child(3)>input"));
				enterWeight.sendKeys(assignWeight);
			}
		}
		
	}
	
	public void clickOnConfrimLotSelection(){
		lotSelectionConfBtn.click();
	}
}
