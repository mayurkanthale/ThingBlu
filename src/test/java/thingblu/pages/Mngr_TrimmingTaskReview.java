package thingblu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Mngr_TrimmingTaskReview extends BasePage{

	public Mngr_TrimmingTaskReview(WebDriver driver) {
		super(driver);
	}
	
	
	//Trimming
		@FindBy(css = "input[formcontrolname='rusablebudwt']")
		WebElement budMtrlInputBox;
		
		@FindBy(css = "input[id='oilmaterialwt']")
		WebElement oilMtrlInputBox;
		
		@FindBy(css = "input[id='wastematerialwt']")
		WebElement wasetMtrlInputBox;
		
		
		
		
		public void enterTrimBudReviewWt(String budRWeight) {
			enterData(budMtrlInputBox, budRWeight);
		}

		public void enterTrimOilReviewWt(String oilRWeight) {
			enterData(oilMtrlInputBox, oilRWeight);
		}

		public void enterTrimWasteReviewWt(String wasteRWeight) {
			enterData(wasetMtrlInputBox, wasteRWeight);
		}

		

}
