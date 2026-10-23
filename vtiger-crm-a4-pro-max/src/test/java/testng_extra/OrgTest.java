package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrgTest {
	@Test
	public void createOrgTest() {
		System.out.println("org created");
	}

	@Test(dependsOnMethods = "createOrgTest")
	public void modifyOrgTest() {
		Assert.assertTrue(false);
		System.out.println("org modified to LatestOrg");
	}

	@Test(dependsOnMethods = "modifyOrgTest", alwaysRun = true)
	public void deleteOrgTest() {	
		System.out.println("LatestOrg deleted");
	}
	
}
