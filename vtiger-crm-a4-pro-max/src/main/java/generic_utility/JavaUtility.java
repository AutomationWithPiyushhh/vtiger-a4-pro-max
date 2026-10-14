package generic_utility;
// the utility which is common for all the app/testscript/project is called as generic utility


public class JavaUtility {
	public static int generateRandomNumber() {
		double ranDouble = Math.random();
		double random = ranDouble * 10000;
		int ran = (int) random;
		
		return ran;
	}
}
