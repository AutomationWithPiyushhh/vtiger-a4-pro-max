package dataprovider_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoTest {

	/*
	 * DP => executing the same test script multiple times 
	 * 		with the different set of data
	 */

	@Test(dataProvider = "getData")
	public void login(String un, String pwd) {
		System.out.println(un);
		System.out.println(pwd);
		System.out.println();
	}

//	Mark a method as supplying data for a test method.
	@DataProvider
	public String[][] getData() {

		String[][] creds = new String[6][2];
//						num of row = num of execution
//						num of col = num of parameters

		creds[0][0] = "standard_user";
		creds[0][1] = "secret_sauce"; 

		creds[1][0] = "locked_out_user";
		creds[1][1] = "secret_sauce";

		creds[2][0] = "problem_user";
		creds[2][1] = "secret_sauce";

		creds[3][0] = "performance_glitch_user";
		creds[3][1] = "secret_sauce";

		creds[4][0] = "error_user";
		creds[4][1] = "secret_sauce";

		creds[5][0] = "visual_user";
		creds[5][1] = "secret_sauce";

		return creds;
	}
}
