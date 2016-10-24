import java.util.ArrayList;

/*
 * Vehicles Class
instance variable
Vehicle[ ] // array of Vehicle objects
methods
(appropriate constructor)
add(Vehicle v) // add vehicle to collection
getVehicle(VIN) // retrieve reference to Vehicle object by VIN.
- throws VINNotFoundException if no vehicle found for provided VIN
getReservations(company name) // returns list of vehicles reserved by company provided
- throws CompanyNotFoundException if no vehicles found reserved by provided company name
// Iterator Methods
reset() // resets to first vehicle in list
hasNextVehicle() // returns true if there is another vehicle in the list, otherwise returns false nextVehicle() // returns the next Vehicle object in the list
 */
public class Vehicles {
	ArrayList<Vehicle> vehicles;
	int currentVehicleIndex = -1;
	
	public Vehicles() {
		vehicles = new ArrayList<Vehicle>();
	}
	
	public void add(Vehicle v) {
		vehicles.add(v);
	}
	
	public Vehicle getVehicle(String VIN) throws VINNotFoundException {
		reset();
		while(hasNextVehicle()) {
			Vehicle v = nextVehicle();
			if(v.getVIN().equals(VIN)) {
				return v;
			}
		}
		throw new VINNotFoundException();
	}
	
	public ArrayList<Vehicle> getReservations(String companyName) throws CompanyNotFoundException {
		reset();
		ArrayList<Vehicle> reservedVehicles = new ArrayList<Vehicle>();
		
		while(hasNextVehicle()) {
			Vehicle v = nextVehicle();
			
			Reservation r;
			try {
				r = v.getReservation();
				if(r.getCompanyName() == companyName) {
					reservedVehicles.add(v);
				}
			} catch (UnreservedVehicleException e) {
			}
		}
		
		if(reservedVehicles.isEmpty()) {
			throw new CompanyNotFoundException();
		} else {
			return reservedVehicles;
		}
	}
	
	public void reset() {
		this.currentVehicleIndex = -1;
	}
	
	public boolean hasNextVehicle() {
		return currentVehicleIndex < vehicles.size() - 1;
	}
	
	public Vehicle nextVehicle() {
		if(hasNextVehicle()) {
			this.currentVehicleIndex ++;
			return vehicles.get(currentVehicleIndex);
		} else {
			return null;
		}
	}
}