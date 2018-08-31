package thingblu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_DashboardCommon extends BasePage{

	public Mngr_DashboardCommon(WebDriver driver) {
		super(driver);
	}

	@FindAll ({ @FindBy(css="p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr")})
	List<WebElement> reviewPendingtableRows;
	
	@FindBy(css="p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table")
	WebElement eleToScrollReviewTable;
	
	@FindBy(css="button[label='Submit Review']")
	WebElement submitReviewBtn;
	
	@FindBy(css="button[label='Start Task']")
	WebElement startMngrTaskButton;
	
	@FindBy(css="button[label='Pause']")
	WebElement puaseMngrTaskButton;
	
	@FindBy(css="button[label='Complete']")
	WebElement completeMngrTaskButton;
	
	@FindBy(css = "input[id='acthrs']")
	WebElement actualHrsInputBox;
	
	@FindBy(css = "input[id='actmins']")
	WebElement actualMinInputBox;
	
	@FindBy(css = "textarea[formcontrolname='rmisccomment']")
	WebElement textAreaComment;
	
	
	

	public void mngrSelectTaskForAssignedStatus(String employee, String status){
		for (int i = 1; i <reviewPendingtableRows.size()+1; i++) {
			WebElement employeeName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>u>a"));
			WebElement statusName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));

			if (employeeName.getText().equalsIgnoreCase(employee) && statusName.getText().equalsIgnoreCase(status)) {
				click(employeeName);
				break;
			}

		}
	}
	
	public void mngrSelectTaskForInProcessStatus(String employee, String status){
		for (int i = 1; i <reviewPendingtableRows.size()+1; i++) {
			WebElement employeeName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>u>a"));
			WebElement statusName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));

			if (employeeName.getText().equalsIgnoreCase(employee) && statusName.getText().equalsIgnoreCase(status)) {
				click(employeeName);
				break;
			}

		}
	}
	
	public void mngrSelectTaskForPauseStatus(String employee, String status){
		for (int i = 1; i <reviewPendingtableRows.size()+1; i++) {
			WebElement employeeName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>u>a"));
			WebElement statusName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));

			if (employeeName.getText().equalsIgnoreCase(employee) && statusName.getText().equalsIgnoreCase(status)) {
				click(employeeName);
				break;
			}

		}
	}
	public void mngrSelectTaskForCompletedStatus(String employee, String status){
		for (int i = 1; i <reviewPendingtableRows.size()+1; i++) {
			WebElement employeeName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>u>a"));
			WebElement statusName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));

			if (employeeName.getText().equalsIgnoreCase(employee) && statusName.getText().equalsIgnoreCase(status)) {
				click(employeeName);
				break;
			}

		}
	}
	
	public void mngrSelectTaskForReviewStatus(String employee, String status){
		for (int i = 1; i <reviewPendingtableRows.size()+1; i++) {
			WebElement employeeName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>u>a"));
			WebElement statusName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));

			if (employeeName.getText().equalsIgnoreCase(employee) && statusName.getText().equalsIgnoreCase(status)) {
				click(employeeName);
				break;
			}

		}
	}
	
	
	
	
	public void mngrSelectTask(String employee, String task, String strainName, String lot){
		scrollToElement(eleToScrollReviewTable);
		System.out.println("size: " +reviewPendingtableRows.size());
		for (int i = 1; i <reviewPendingtableRows.size()+1; i++) {
			WebElement employeeName=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(1)>u>a"));
			WebElement taskname=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(2)"));
		//  WebElement grower=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(3)"));
			WebElement strain=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(4)"));
			WebElement lotNum=driver.findElement(By.cssSelector("p-table[id=tblRevPendingTasks]>div>div:nth-child(2)>table>tbody>tr:nth-child("+i+")>td:nth-child(5)"));
	
			if (employeeName.getText().equalsIgnoreCase(employee) && taskname.getText().equalsIgnoreCase(task)
					&& strain.getText().equalsIgnoreCase(strainName) && lotNum.getText().equalsIgnoreCase(lot)) {
				//scrollToElement(employeeName);
				click(employeeName);
				break;
			}

		}
	}
	
	
	
	
	public void clcikOnButton(String ActionName) {
		switch (ActionName) {
		case "Start":
			click(startMngrTaskButton);
			break;

		case "Pause":
			click(puaseMngrTaskButton);
			break;

		case "Complete":
			click(completeMngrTaskButton);
			break;
			
		case "Review":
			
			try {
				click(submitReviewBtn);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Task is completed");
		}
	}
	

	
	public void enterTrimReviewComment(String comment) {
		enterData(textAreaComment, comment);
	}

	public void enterActualHrs(String hrs) {
		enterData(actualHrsInputBox, hrs);
	}

	public void enterActualMins(String mins) {
		enterData(actualMinInputBox, mins);
	}
	
	
	
	
}
