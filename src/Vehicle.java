/*
 * instance variables
String description // make-model for cars/suvs, length for trucks
String mpg
String num // represents something different in each class (num of seats, bench seats, of rooms of storage) String VIN
Reservation resv // Vehicle reserved if assigned to a Reservation object. If null, then vehicle not reserved
 methods
(appropriate constructor)
getDescription() // ABSTRACT METHOD – implemented in each subclass
// returns a string containing the information about a particular vehicle,
// as shown at the bottom of page 2 above isReserved() // returns true if reserved
reserve(reservation info)
- throws ReservedVehicleException (if try to reserve a vehicle already reserved)
cancelReservation() // sets reference to Reservation object to null
- throws UnreservedVehicleException (if try to cancel a reservation that doesn’t exist)
getVIN() // returns vehicle identification number
getReservation() // returns reference to associated reservation object
- throws UnreservedVehicleException (if try to retrieve a reservation that doesn’t exist)
 */
public abstract class Vehicle {
	String description,
		mpg,
		num,
		VIN;
	Reservation resv;
	
	public abstract String getDescription();
	public abstract double getRate(String rentPeriod);
	
	public boolean isReserved() { 
		return this.resv != null;
	}
	
	public void reserve(Reservation info) throws ReservedVehicleException {
		if(this.resv != null) {
			throw new ReservedVehicleException();
		}
		this.resv = info;
	}
	
	public void cancelReservation() throws UnreservedVehicleException {
		if(!isReserved()) {
			throw new UnreservedVehicleException();
		} else {
			this.resv = null;
		}
	}
	
	public String getVIN() {
		return this.VIN;
	}
	
	public Reservation getReservation() throws UnreservedVehicleException {
		if(!isReserved()) {
			throw new UnreservedVehicleException();
		} else {
			return this.resv;
		}
	}
}
