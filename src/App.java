/*
Creates a Vehicles object, initialized for the vehicles of the rental agency.
Populates the Vehicles objects by call to a supporting method.
Contains the rental rates for all vehicle types
Provides the main menu of user options
**************************************************** 
 * Welcome to the Friendly Vehicle Rental Agency * 
*****************************************************
<<< MAIN MENU >>>
1 - Display rental rates
2 - Display available vehicles
3 – Display specific rental cost
4 – Make a reservation
5 - Cancel a reservation
6 – Display company reservations
7 - Quit
*/

import java.util.Scanner;


public class App {
	
	static Vehicles vs = new Vehicles();
	
	static double PER_MILE_CHARGE = 0.15;
	static double INSURANCE_RATE = 14.95;

	public static void main(String[] args) {
		populateVehicles();

		System.out.println("****************************************************");
		System.out.println(" * Welcome to the Friendly Vehicle Rental Agency * ");
		System.out.println("****************************************************");
		System.out.println("<<< MAIN MENU >>>");
		System.out.println("1 - Display rental rates");
		System.out.println("2 - Display available vehicles");
		System.out.println("3 – Display specific rental cost");
		System.out.println("4 – Make a reservation");
		System.out.println("5 - Cancel a reservation");
		System.out.println("6 – Display company reservations");
		System.out.println("7 - Quit");
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		processCommand(n);
		
		reader.close();
	}
	
	public static void processCommand(int m) {
		switch(m) {
		case 1:
			// Display rental rates
			displayRentalRates();
		case 2:
			// Display available vehicles
			displayAvailableVehicles();
		case 3:
			// Display specific rental cost
			displaySpecificRentalCost();
		case 4:
			// Make a reservation
		case 5:
			// Cancel a reservation
		case 6:
			// Display company reservations
		case 7:
			// Quit
			System.exit(0);
		}
	}

	public static void displayRentalRates() {
		System.out.println("\tDailey\tWeekly\tMonthly");
		System.out.println("Cars\t"+"$"+Car.DAILY_RATE + "\t" + "$"+Car.WEEKLY_RATE + "\t" + "$"+Car.MONTHLY_RATE);
		System.out.println("SUV\t"+"$"+SUV.DAILY_RATE + "\t" + "$"+SUV.WEEKLY_RATE + "\t" + "$"+SUV.MONTHLY_RATE);
		System.out.println("truck\t"+"$"+Truck.DAILY_RATE + "\t" + "$"+Truck.WEEKLY_RATE + "\t" + "$"+Truck.MONTHLY_RATE);
	}
	
	public static void displayAvailableVehicles() {
		System.out.println("Car (1), SUVs(2), or Trucks (3)");
	}
	
	public static void displaySpecificRentalCost() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Please enter the VIN");
		String VIN = reader.next();
		
		try {
			Vehicle v = vs.getVehicle(VIN);
			
			System.out.println(v.getDescription());
			System.out.println("Do you wish to rent by day (1), week (2) or month (3)");
			int rentBy = reader.nextInt();
			
			String rentPeriod = "";
			switch(rentBy) {
			case 1:
				rentPeriod = "day";
				break;
			case 2:
				rentPeriod = "week";
				break;
			case 3:
				rentPeriod = "month";
				break;
			}
			
			System.out.println("How many " + rentPeriod + "s do you plan to rent?");
			int numOf = reader.nextInt();
			
			System.out.println("What is the estimated number of miles you plan to drive?");
			int miles = reader.nextInt();
			
			System.out.println("Do you wish the optional insurance ($" + App.INSURANCE_RATE + "/day)?");
			String optIns = reader.next();
			
			double insuranceCost = 0.0;
			boolean hasInsurance = false;
			switch(optIns) {
			case "Yes":
			case "yes":
				insuranceCost = numOf * v.getRate(rentPeriod);
				break;
			}
			
			double cost = numOf * v.getRate(rentPeriod) + miles * App.PER_MILE_CHARGE + insuranceCost;
			
			System.out.println("The rental cost of this vehicle for " 
					+ numOf + " " + rentPeriod + "s, with an estimated miles of " 
					+ miles + ", and "+ (hasInsurance ? "" : "no ") 
					+ "insurance: $" + toPrice(cost));
			
		} catch (VINNotFoundException e) {
			System.out.println("VIN " + VIN + " Not Found");
		}
		
		reader.close();
	}
	
	public static double toPrice(double d) {
		return Math.round(d*100)/100.0d;
	}
	
	public static void populateVehicles() {
		vs.add(new Car("Chevrolet Camaro", "30", "2", "WG8JM5392DY"));
		vs.add(new Car("Chevrolet Camaro", "30", "2", "KH4GM4564GD"));
		vs.add(new Car("Ford Fusion", "34", "4", "AB4FG5689GM"));
		vs.add(new Car("Ford Fusion Hybrid", "35", "4", "GH2KL4278TK"));
		vs.add(new Car("Ford Fusion Hybrid", "32", "4", "KU4EG3245RW"));
		vs.add(new Car("Chevrolet Impala", "36", "4", "QD4BK7394JI"));
		vs.add(new Car("Chevrolet Impala", "30", "4", "RK3BM4256YH"));
	}
}
