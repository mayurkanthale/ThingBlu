package thingblu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_SiftingTaskReview extends BasePage{

	public Mngr_SiftingTaskReview(WebDriver driver) {
		super(driver);
	}

	//Sifting

		@FindBy(css = "input[id='BUD_WT']")
		WebElement siftingBudMtrlInputBox;

		@FindBy(css = "input[ng-reflect-name='JOINTS_WT']")
		WebElement siftingJointsMtrlInputBox;

		@FindBy(css = "input[ng-reflect-name='OIL_WT']")
		WebElement siftingOilMtrlInputBox;
		
		public void enterSiftBudReviewWt(String budRWeight) {
			enterData(siftingBudMtrlInputBox, budRWeight);
		}

		public void enterSiftJointsReviewWt(String jointsRWeight) {
			enterData(siftingJointsMtrlInputBox, jointsRWeight);
		}

		public void enterSiftOilReviewWt(String oilRWeight) {
			enterData(siftingOilMtrlInputBox, oilRWeight);
		}
}
