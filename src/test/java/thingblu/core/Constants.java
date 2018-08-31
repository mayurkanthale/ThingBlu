package thingblu.core;

import org.openqa.selenium.Platform;

public class Constants {
	
	public static final String chromeDriverPath = "D:\\Mayur\\Automation\\Thingblu\\Drivers\\chromedriver.exe";
	public static final String IEDriverPath = "D:\\somanath\\automation_work\\Thingblu\\Drivers\\IEDriverServer.exe";
	public static final String firefoxDriverPath = "D:\\somanath\\automation_work\\Thingblu\\Drivers\\geckodriver.exe";
	public static final String safariDriverPath = "";
	public static final String testLink= "http://192.168.5.148/thingbluprocessor/#/login";
	public static final String uatLink= "https://thingbluuat.azurewebsites.net/#/login";
	public static final String liveLink= "";
	public static final String userTypes = "";
	
	//file locations
	public final String testReportFilePath = "D:\\somanath\\automation_work\\Thingblu\\TestReports\\thingbluTestReport.html";
	
	//Properties files
	public static final String propertiesFilePath="D:\\Mayur\\Automation\\Thingblu\\src\\test\\resources\\projectdata.properties";
	public static final String SQLQueriesFilePath="D:\\Mayur\\Automation\\Thingblu\\src\\test\\resources\\SQLQueries.properties";
	
	
	//Excel file locations
	public static final String folderPath="D:\\Mayur\\Automation\\Thingblu\\src\\test\\resources\\test-data\\";
	public static final String lotEntryFile =folderPath.concat("Lot-Entry-Data.xls");
	public static final String orderDataFile=folderPath.concat("orderEntryData.xls");
	public static final String taskAssignFile =folderPath.concat("TaskAssignData.xls");
	
			
			
	//Grid setup
	public static final Boolean USE_GRID = false;
	public static final Platform platform= Platform.ANY;
	public static final String HUB_URL="";
	public static final String NODE1_URL="http://192.168.0.5:5555/wd/hub";
	public static final String NODE2_URL="http://192.168.0.9:5555/wd/hub";
}
