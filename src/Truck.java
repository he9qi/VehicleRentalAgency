
public class Truck extends Vehicle{
	public static double DAILY_RATE = 34.95;
	public static double WEEKLY_RATE = 224.95;
	public static double MONTHLY_RATE = 797.95;
	
	public Truck(String description, String mpg, String num, String VIN) {
		this.description = description;
		this.mpg = mpg;
		this.num = num;
		this.VIN = VIN;
	}
	
	public double getRate(String rentPeriod) {
		switch(rentPeriod) {
		case "day":
			return Truck.DAILY_RATE;
		case "week":
			return Truck.WEEKLY_RATE;
		case "month":
			return Truck.MONTHLY_RATE;
		}
		return 0;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
