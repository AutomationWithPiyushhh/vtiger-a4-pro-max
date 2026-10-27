package generic_utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// the utility which is common for all the app/testscript/project is called as generic utility

public class JavaUtility {
	public static int generateRandomNumber() {
		double ranDouble = Math.random();
		double random = ranDouble * 10000;
		int ran = (int) random;

		return ran;
	}

	public static String getCurrentDateTime() {
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss_ddMMMyyyy"));
		return date;
	}
}
