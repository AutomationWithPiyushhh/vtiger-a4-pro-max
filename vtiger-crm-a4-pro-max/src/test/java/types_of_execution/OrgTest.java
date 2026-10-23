package types_of_execution;

import org.testng.annotations.Test;

public class OrgTest {
	@Test(groups = "create")
	public void createOrgTest() {
		System.out.println("org created");
	}

	@Test(groups = "modify")
	public void modifyOrgTest() {
		System.out.println("org modified to LatestOrg");
	}

	@Test(groups = "delete")
	public void deleteOrgTest() {
		System.out.println("LatestOrg deleted");
	}

}
