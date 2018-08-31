package thingblu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import thingblu.core.BasePage;
import thingblu.utility.ElementHighlighter;

public class Common_SignInPage extends BasePage{

	public Common_SignInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	WebElement username;
	@FindBy(css = "input[type='password']")
	WebElement password;
	@FindBy(css = "button[name='btnLogin']")
	WebElement logInBtn;
	
	
	public void setUsername(String aUsername) {
		ElementHighlighter.highLighter(driver, username);
		visibility(username);
		username.sendKeys(aUsername);
	}

	public void setPassword(String aPassword) {
		ElementHighlighter.highLighter(driver, password);
		password.sendKeys(aPassword);
	}

	public void ClickSignInBtn() {
		ElementHighlighter.highLighter(driver, logInBtn);
		logInBtn.click();
	}

}
