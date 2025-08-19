package ExcelData_TestNG;

import org.testng.annotations.DataProvider;

public class WebOrdersDataProvider {
	  @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][]{
	            {"Tester", "test", "success"},      // valid
	            {"Tester", "wrongpass", "invalid"}, // invalid password
	            {"wronguser", "test", "invalid"}    // invalid username
	        };
	    }
	}