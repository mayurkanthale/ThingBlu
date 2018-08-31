package thingblu.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHighlighter {
	
	/**
	 * 
	 * @param driver Passing driver 
	 * @param element Passing WebElement reference that will get highlighted during test execution
	 */
	public static void highLighter(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try 
		{
		Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
		 
		System.out.println(e.getMessage());
		} 
		 
		js.executeScript("arguments[0].setAttribute('style','border: solid 0px');", element); 
		 
		}
	}
