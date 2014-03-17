import java.util.concurrent.ThreadLocalRandom;

public class Other {

	/*
	 * Strings in switch statements
	 */
	public String stringsInSwitchStatements(String dayOfWeek) {
		String typeOfDay;
		switch (dayOfWeek) {
		case "Monday":
			typeOfDay = "Start of work week";
			break;
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
			typeOfDay = "Midweek";
			break;
		case "Friday":
			typeOfDay = "End of work week";
			break;
		case "Saturday":
		case "Sunday":
			typeOfDay = "Weekend";
		default:
			throw new IllegalArgumentException("Invalid day of the week: "
					+ dayOfWeek);
		}
		return typeOfDay;
	}

	/*
	 * Underscores in numeric literals
	 */
	@SuppressWarnings("unused")
	public void underscoresInNumericLiterals() {
		long creditCardNumber = 1234_5678_9012_3456L;
		float pi = 	3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long bytes = 0b11010010_01101001_10010100_10010010;
		
//		int x3 = 52_;  // Invalid: underscores at the end of a literal
		// Invalid: underscores adjacent to a decimal point
//		float pi1 = 3_.1415F;
//		float pi2 = 3._1415F;
		// Invalid: underscores prior to an L suffix
//		long socialSecurityNumber1 = 999_99_9999_L;         
	}
	
	/*
	 * ThreadLocalRandom.current().next
	 */
	@SuppressWarnings("unused")
	public void isolatedRandomNumber() {
		boolean randomFlag = 
				ThreadLocalRandom.current().nextBoolean();
		double randomRatio = 
				ThreadLocalRandom.current().nextDouble();
		double randomYield = 
				ThreadLocalRandom.current().nextDouble(1.0, 2.0);
		Long randomCount = 
				ThreadLocalRandom.current().nextLong();
	}
}
