package types_of_execution;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(groups = "create")
	public void createContactTest() {
		System.out.println("Contact created");
	}

	@Test(groups = "modify")
	public void modifyContactTest() {
		System.out.println("Contact modified to LatestContact");
	}

	@Test(groups = "delete")
	public void deleteContactTest() {	
		System.out.println("LatestContact deleted");
	}
	
}
