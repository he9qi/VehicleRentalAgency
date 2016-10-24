/*
 * Reservation Class
instance variables
String companyName
String creditCardNum
String rentalPeriodType // days, weeks, months
String rentalTime // 1, 2, 3, ... (can convert to int when needed)
methods
constructor (passed all of the needed information for a reservation)
- throws InvalidCreditCardException if credit card contains non-digits, or is not 16 digits long.
getCompanyName() getCreditCardNum() getRentalPeriodType() getRentalTime()
toString() // returns a string containing company name, credit card number used, and rental // period/rental time
Note that reservations cannot be altered once created (i.e., Reservation objects are immutable). Thus, there are no setters in the Reservation class.
 *
 */

public class Reservation {
	private String companyName,
		creditCardNum,
		rentalPeriodType,
		rentalTime;
	
	public Reservation(String companyName, String creditCardNum, String rentalPeriodType, String rentalTime) throws InvalidCreditCardException {
		if(!isValidCreditCard(creditCardNum)) {
			throw new InvalidCreditCardException();
		}
		this.companyName = companyName;
		this.creditCardNum = creditCardNum;
		this.rentalPeriodType = rentalPeriodType;
		this.rentalTime = rentalTime;
	}
	
	private boolean isValidCreditCard(String card) {
		try {
			Long.parseLong(card);
		} catch(Exception e) {
			return false;
		}
		return card.length() == 16;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public String getCreditCardNum() {
		return this.creditCardNum;
	}
	
	public String getRentalPeriodType() {
		return this.rentalPeriodType;
	}
	
	public String getRentalTime() {
		return this.rentalTime;
	}
	
	public String toString() {
		return this.companyName + "\t" 
				+ this.creditCardNum + "\t"
				+ this.rentalPeriodType + "/"
				+ this.rentalTime;
	}
}
