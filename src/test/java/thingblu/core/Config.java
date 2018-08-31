package thingblu.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import thingblu.pages.Common_MenuNavigation;
import thingblu.pages.Common_SignInPage;
import thingblu.pages.EmpSiftingTaskComplete;
import thingblu.pages.EmpTrimmingTaskComplete;
import thingblu.pages.Emp_DashboardCommon;
import thingblu.pages.Mngr_AddNewBrand;
import thingblu.pages.Mngr_AddNewPackageType;
import thingblu.pages.Mngr_AddNewProductType;
import thingblu.pages.Mngr_AddNewStrain;
import thingblu.pages.Mngr_AddNewStrainType;
import thingblu.pages.Mngr_AddNewSubBrand;
import thingblu.pages.Mngr_CommonAssignTask;
import thingblu.pages.Mngr_DashboardCommon;
import thingblu.pages.Mngr_LotEntry;
import thingblu.pages.Mngr_OrderEntryForm;
import thingblu.pages.Mngr_SiftingTaskReview;
import thingblu.pages.Mngr_TrimmingTaskReview;

public class Config {
	protected WebDriver driver;


	protected Common_SignInPage signIn;
	protected Common_MenuNavigation navigation;
	protected Mngr_OrderEntryForm orderEntryPage;
	protected Mngr_LotEntry lotEntryPage;
	protected Mngr_CommonAssignTask assignTaskPage;
	protected Emp_DashboardCommon emp_dashboardCommon;
	protected Mngr_DashboardCommon mngr_dashboardCommon;
	protected EmpSiftingTaskComplete emp_siftingTask;
	protected EmpTrimmingTaskComplete emp_trimmingTask;
	protected Mngr_TrimmingTaskReview mngr_trimmingTaskReview;
	protected Mngr_SiftingTaskReview mngr_siftingTaskReview;
	protected Mngr_AddNewBrand mngr_brandMaster;
	protected Mngr_AddNewSubBrand mngr_subBrandMaster;
	protected Mngr_AddNewPackageType mngr_packageTypeMaster;
	protected Mngr_AddNewProductType mngr_productTypeMaster;
	protected Mngr_AddNewStrainType mngr_strainTypeMaster;
	protected Mngr_AddNewStrain mngr_strainMaster;
	

	@BeforeClass
	public void initBrowser() throws Exception {
		driver = WebDriverManager.getInstance("chrome");

		signIn = PageFactory.initElements(driver, Common_SignInPage.class);
		navigation = PageFactory.initElements(driver, Common_MenuNavigation.class);
		orderEntryPage = PageFactory.initElements(driver, Mngr_OrderEntryForm.class);
		lotEntryPage = PageFactory.initElements(driver, Mngr_LotEntry.class);
		assignTaskPage = PageFactory.initElements(driver, Mngr_CommonAssignTask.class);
		emp_dashboardCommon = PageFactory.initElements(driver, Emp_DashboardCommon.class);
		mngr_dashboardCommon = PageFactory.initElements(driver, Mngr_DashboardCommon.class);
		emp_siftingTask = PageFactory.initElements(driver, EmpSiftingTaskComplete.class);
		emp_trimmingTask = PageFactory.initElements(driver, EmpTrimmingTaskComplete.class);
		mngr_trimmingTaskReview = PageFactory.initElements(driver, Mngr_TrimmingTaskReview.class);
		mngr_siftingTaskReview = PageFactory.initElements(driver, Mngr_SiftingTaskReview.class);
		mngr_brandMaster = PageFactory.initElements(driver, Mngr_AddNewBrand.class);
		mngr_subBrandMaster=PageFactory.initElements(driver, Mngr_AddNewSubBrand.class);
		mngr_packageTypeMaster = PageFactory.initElements(driver, Mngr_AddNewPackageType.class);
		mngr_productTypeMaster = PageFactory.initElements(driver, Mngr_AddNewProductType.class);
		mngr_strainTypeMaster = PageFactory.initElements(driver, Mngr_AddNewStrainType.class);
		mngr_strainMaster = PageFactory.initElements(driver, Mngr_AddNewStrain.class);		
		driver.get(Constants.testLink);
	}

	/*
	 * @AfterMethod public void TakeFailedCasesScreenshot(ITestResult result) {
	 * if (ITestResult.FAILURE == result.getStatus()) { FailedCasesScreenshot fs
	 * = new FailedCasesScreenshot(); fs.takeScreenShot(driver,
	 * result.getName()); etlogger.log(LogStatus.FAIL, result.getName()); } }
	 * 
	 * @AfterTest public void closeReports() { report.endTest(etlogger);
	 * report.flush(); driver.get(
	 * "D:/somanath/gitRepositoryData/math2shine/reports/math2shine.html"); }
	 */

	public void logIntoSystemAsManager(String username, String password) {
		signIn.setUsername(username);
		signIn.setPassword(password);
		signIn.ClickSignInBtn();
	}

	public void logIntoSystemAsEmployee(String username, String password) {
		signIn.setUsername(username);
		signIn.setPassword(password);
		signIn.ClickSignInBtn();
	}

	public void logInToApplicationAs(String userRole) {
		switch (userRole) {
		case "Manager":
			try {
				logIntoSystemAsManager("omar", "111114");
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Exception occurs while log in as a manager : "+e.getMessage());
			}
			break;

		case "Employee":
			try {
				logIntoSystemAsEmployee("david", "123456");
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Exception occurs while log in as a manager : "+e.getMessage());
			}
			
			break;

		default:
			System.out.println("UserRole not match of login details are invalid.");
		}

	}
}