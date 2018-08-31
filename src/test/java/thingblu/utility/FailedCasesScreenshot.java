package thingblu.utility;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FailedCasesScreenshot {
	/**
	 * 
	 * @param driver
	 * @param imageName
	 */
	public void takeScreenShot(WebDriver driver , String imageName){	
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
			LocalDateTime now = LocalDateTime.now();
			String date= dtf.format(now);
			String scrName = imageName.concat(date);
			TakesScreenshot ts =(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+scrName+".png"));
			System.out.println("Screenshot taken successfully");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot :" +e.getMessage());
		}
	}

}
