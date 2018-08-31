package thingblu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class EmpTrimmingTaskComplete extends BasePage {

	public EmpTrimmingTaskComplete(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "p-checkbox[formcontrolname='islotcompleteyes']")
	WebElement isCompleteCheckBoxYes;

	@FindBy(css = "p-checkbox[formcontrolname='islotcompleteno']")
	WebElement isCompleteCheckBoxYNo;

	@FindBy(css = "input[id='usablebudwt']")
	WebElement usableBudInputBox;

	@FindBy(css = "textarea[formcontrolname='misccomment']")
	WebElement textAreaComment;

	@FindBy(css = "button[label='Confirm']")
	WebElement confirmButton;

	public void clickOnCheckBoxIfCompleted(String lotStatus) {
		switch (lotStatus) {
		case "Yes":
			click(isCompleteCheckBoxYes);
			break;

		case "No":
			click(isCompleteCheckBoxYNo);
			break;

		default:
			System.out.println("Checkbox not found or checkbox label not match.");
		}
	}

	public void enterUsableBudWeight(String budWeight) {
		enterData(usableBudInputBox, budWeight);
	}

	public void entertaskComment(String comment) {
		enterData(textAreaComment, comment);
	}

	public void clickOnConfrimButton() {
		click(confirmButton);
	}

}
