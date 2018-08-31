package thingblu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class EmpSiftingTaskComplete extends BasePage {

	public EmpSiftingTaskComplete(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#BUD_WT")
	WebElement budWeightInputBox;

	@FindBy(css = "#JOINTS_WT")
	WebElement jointsWeightInputBox;

	@FindBy(css = "#OIL_WT")
	WebElement oilWeightInputBox;

	public void enterBudWeight(String budWeight) {
		enterData(budWeightInputBox, budWeight);
	}

	public void enterJointsWeight(String jointWeight) {
		enterData(jointsWeightInputBox, jointWeight);
	}

	public void enterOilsWeight(String oilsWeight) {
		enterData(oilWeightInputBox, oilsWeight);
	}

	public void enterTaskcomment(String taskComment) {
		// TODO Auto-generated method stub
		
	}

}
