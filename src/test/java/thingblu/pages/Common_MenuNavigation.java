package thingblu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import thingblu.core.BasePage;

public class Common_MenuNavigation extends BasePage {

	public Common_MenuNavigation(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".menu>ul>li:nth-child(2)>div>a>span")
	WebElement newLot;

	@FindBy(css = ".menu>ul>li:nth-child(3)>div>a>span")
	WebElement lotList;

	@FindBy(css = ".menu>ul>li:nth-child(4)>div>a>span")
	WebElement order;

	@FindBy(css = "a[ng-reflect-router-link='orderrequestform']>span")
	WebElement OrderRequestForm;

	@FindBy(css = ".menu>ul>li:nth-child(5)>div>a>span")
	WebElement task;

	@FindBy(css = "a[ng-reflect-router-link='assigntask']>span")
	WebElement assigntask;

	@FindBy(css = "span[ng-reflect-ng-class='fa-sign-out']+span")
	WebElement signOutLink;

	@FindBy(css = ".menu>ul>li:nth-child(8)>div>a>span")
	WebElement master;

	@FindBy(css = "a[ng-reflect-router-link='addnewbrand']>span")
	WebElement addNewBrandPageLink;

	@FindBy(css = "a[ng-reflect-router-link='addnewsubbrand']>span")
	WebElement addNewSubBrand;

	@FindBy(css = "a[ng-reflect-router-link='addnewpackagetype']>span")
	WebElement addNewPackageType;

	@FindBy(css = "a[ng-reflect-router-link='newproducttype']>span")
	WebElement addNewProductType;
	
	@FindBy(css = "a[ng-reflect-router-link='straintypemaster']>span")
	WebElement addNewStrainType;
	
	@FindBy(css = "a[ng-reflect-router-link='strainmaster']>span")
	WebElement addNewStrain;
	

	public void clickOnSignOut() {
		click(signOutLink);
	}

	public void clickOnNewLOtMenuItem() {
		click(newLot);
	}

	public void clickOnLotListMenuItem() {
		click(lotList);
	}

	public void clickOnOrderMenuItem() {
		click(order);
	}

	public void clickOnOrderFormMenuItem() {
		click(OrderRequestForm);
	}

	public void clickOnTaskMenuItem() {
		click(task);
	}

	public void clickOnAssignTaskMenuItem() {
		click(assigntask);
	}

	public void clickOnMastersMenuItem() {
		click(master);
	}

	public void clickOnAddNewBarndMenuItem() {
		//clickOnMastersMenuItem();
		click(addNewBrandPageLink);
	}

	public void clickOnAddNewSubBarndMenuItem() {
		try {
			clickOnMastersMenuItem();
			scrollToElement(addNewSubBrand);
			Thread.sleep(1000);
			click(addNewSubBrand);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickOnAddPackageTypeMenuItem() {
		try {
			// clickOnMastersMenuItem();
			scrollToElement(addNewPackageType);
			Thread.sleep(1000);
			click(addNewPackageType);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddProductTypeMenuItem() {

		try {
			// clickOnMastersMenuItem();
			scrollToElement(addNewProductType);
			Thread.sleep(1000);
			click(addNewProductType);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnAddStrainTypeMenuItem() {
		try {
			clickOnMastersMenuItem();
			Thread.sleep(1000);
			scrollToElement(addNewStrainType);
			Thread.sleep(1000);
			click(addNewStrainType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnAddStrainMenuItem() {
		try {
			clickOnMastersMenuItem();
			scrollToElement(addNewStrain);
			Thread.sleep(1000);
			click(addNewStrain);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnMenuItem(String menuName) {

		switch (menuName) {
		case "New Lot Entry":
			  newLot.click();
			  break;
		case "Lot List":
			  lotList.click();
			  break;
		case "Order":
			  order.click();
			  break;
		case "Order Request":
			  order.click();
			  click(OrderRequestForm);
			  break;
		case "All Orders":
			  order.click();
			  break;
		case "Task":
			  click(task);
			  break;
		case "Assign Task":
			  click(task);
			  click(assigntask);
			  break;
		case "Manager Dashboard":
			 
			  break;
		case "Masters":
		   	  master.click();
			  break;
		case "New Product Type":
			  master.click();
			  scrollToElement(addNewProductType);
			  addNewProductType.click();
			  break;
		case "New Strain Type":
			try {
				master.click();
				Thread.sleep(500);
				scrollToElement(addNewStrainType);
				addNewStrainType.click();
			} catch (Exception e) {
				System.out.println("Exception while clicking on menu add new strain type. Exception : " +e.getMessage());
			}
			break;
			
		case "New Strain":
			try {
				master.click();
				Thread.sleep(500);
				scrollToElement(addNewStrain);
				addNewStrain.click();
			} catch (Exception e) {
				System.out.println("Exception while clicking on menu add new strain. Exception : " +e.getMessage());
			}

			break;
		case "New Brand":
			  master.click();
			  scrollToElement(addNewBrandPageLink);
			  addNewBrandPageLink.click();
			  break;
		case "New Sub Brand":
			  master.click();
			  scrollToElement(addNewSubBrand);
			  addNewSubBrand.click();
			  break;
		case "New Package Type":
			  master.click();
			  scrollToElement(addNewPackageType);
			  addNewPackageType.click();
			  break; 
		}
	}
}
