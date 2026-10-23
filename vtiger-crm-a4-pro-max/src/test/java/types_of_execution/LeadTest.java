package types_of_execution;

import org.testng.annotations.Test;

public class LeadTest {
	@Test(groups = "create")
	public void createLeadTest() {
		System.out.println("Lead created");
	}

	@Test(groups = "modify")
	public void modifyLeadTest() {
		System.out.println("Lead modified to LatestLead");
	}

	@Test(groups = "delete")
	public void deleteLeadTest() {	
		System.out.println("LatestLead deleted");
	}
	
}
