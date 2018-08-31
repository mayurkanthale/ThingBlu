package thingblu.core;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

import jxl.read.biff.BiffException;
import thingblu.utility.ExcelReader;

public class DataProviders {

	@DataProvider(name = "Apackdata")
	public Object[][] orderEntryData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.orderDataFile, "Sheet1");
		return arrayObject;
	}

	@DataProvider(name = "LotEntryData")
	public Object[][] lotEntryData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.lotEntryFile, "Sheet1");
		return arrayObject;
	}
	

	@DataProvider(name = "LotEntryData1")
	public Object[][] lotEntryData1() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.lotEntryFile, "Sheet3");
		return arrayObject;
	}
	
	@DataProvider(name = "LotEntryDataIsTrimmedTrue")
	public Object[][] lotEntryDataIsTrimmed() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.lotEntryFile, "Sheet2");
		return arrayObject;
	}
	
	@DataProvider(name = "TrimmingTaskData")
	public Object[][] trimmingTaskData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet1");
		return arrayObject;
	}
	
	@DataProvider(name = "TrimmingTaskComplete")
	public Object[][] trimmingTaskComplete() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet5");
		return arrayObject;
	}
	
	@DataProvider(name = "TrimmingTaskReview")
	public Object[][] trimmingTaskReview() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet5");
		return arrayObject;
	}

	
	@DataProvider(name = "SiftingTaskData")
	public Object[][] siftingTaskData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet2");
		return arrayObject;
	}

	@DataProvider(name = "SiftingTaskComplete")
	public Object[][] siftingTaskComplete() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet6");
		return arrayObject;
	}
	
	@DataProvider(name = "GrindingTaskData")
	public Object[][] grindingTaskData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet3");
		return arrayObject;
	}
	
	@DataProvider(name = "JointsTaskData")
	public Object[][] jointsTaskData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(Constants.taskAssignFile, "Sheet4");
		return arrayObject;
	}
	
	@DataProvider(name = "SubBrandData")
	public Object[] productTypeData() {
		HashMap <String, String> ptData = new HashMap<String, String>();
		ptData.put("Brand", "BrandName 100");
		ptData.put("subBrand", "auto Sub245");
		ptData.put("Desc", "5665");
		return new Object[] {ptData};
	}
	
	@DataProvider(name ="StrainTYpes")
	public Object[] strainTypeData() {
		HashMap <String, String> ptData = new HashMap<String, String>();
		ptData.put("strainType", "subbrand Name 1");
		ptData.put("Desc", "5665 gfhghg");
		return new Object[] {ptData};
	}
	
}
