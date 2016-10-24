public class Car extends Vehicle {
	
	public static double DAILY_RATE = 24.95;
	public static double WEEKLY_RATE = 149.95;
	public static double MONTHLY_RATE = 514.95;
	
	public Car(String description, String mpg, String num, String VIN) {
		this.description = description;
		this.mpg = mpg;
		this.num = num;
		this.VIN = VIN;
	}
	
	public double getRate(String rentPeriod) {
		switch(rentPeriod) {
		case "day":
			return Car.DAILY_RATE;
		case "week":
			return Car.WEEKLY_RATE;
		case "month":
			return Car.MONTHLY_RATE;
		}
		return 0;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}