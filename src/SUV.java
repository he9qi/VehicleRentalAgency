
public class SUV extends Vehicle{
	public static double DAILY_RATE = 29.95;
	public static double WEEKLY_RATE = 189.95;
	public static double MONTHLY_RATE = 679.95;
	
	public SUV(String description, String mpg, String num, String VIN) {
		this.description = description;
		this.mpg = mpg;
		this.num = num;
		this.VIN = VIN;
	}
	
	public double getRate(String rentPeriod) {
		switch(rentPeriod) {
		case "day":
			return SUV.DAILY_RATE;
		case "week":
			return SUV.WEEKLY_RATE;
		case "month":
			return SUV.MONTHLY_RATE;
		}
		return 0;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
