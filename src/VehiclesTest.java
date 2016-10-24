import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VehiclesTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testGetVehicleByVIN() throws VINNotFoundException {
		Vehicles vs = new Vehicles();
		
		Car v1 = new Car("C300", "29", "3", "ABC");
		Car v2 = new Car("C301", "29", "3", "ABD");
		
		vs.add(v1);
		vs.add(v2);
		
		assertEquals(vs.getVehicle("ABC"), v1);
		assertEquals(vs.getVehicle("ABD"), v2);
	}
	
	@Test
	public void testGetVehicleByVINExceptionWithCars() throws VINNotFoundException {
		thrown.expect(VINNotFoundException.class);
		
		Vehicles vs = new Vehicles();
		
		Car v1 = new Car("C300", "29", "3", "ABC");
		
		vs.add(v1);
		vs.getVehicle("ABD");
	}
	
	@Test
	public void testGetVehicleByVINException() throws VINNotFoundException {
		thrown.expect(VINNotFoundException.class);
		
		Vehicles vs = new Vehicles();
		vs.getVehicle("ABD");
	}

	@Test
	public void testGetReservations() throws CompanyNotFoundException, InvalidCreditCardException, UnreservedVehicleException, ReservedVehicleException {
		Vehicles vs = new Vehicles();
		
		Car v1 = new Car("C300", "29", "3", "ABC");
		Car v2 = new Car("C301", "29", "3", "ABD");
		Car v3 = new Car("C302", "29", "3", "ABF");
		
		vs.add(v1);
		vs.add(v2);
		vs.add(v3);
		
		v1.reserve(new Reservation("BMW", "1234567890123456", "days", "2"));
		v2.reserve(new Reservation("BMW", "1234567890123456", "days", "3"));
		
		ArrayList<Vehicle> reservedVehicles = vs.getReservations("BMW");
		
		assertEquals(reservedVehicles.size(), 2);
		assertEquals(reservedVehicles.get(0), v1);
		assertEquals(reservedVehicles.get(1), v2);
	}
}
