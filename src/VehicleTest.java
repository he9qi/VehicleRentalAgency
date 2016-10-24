import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VehicleTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testVehicleInfo() {
		Car car = new Car("C300", "29", "3", "ABC");
		
		assertEquals(car.getDescription(), "C300");
		assertEquals(car.getVIN(), "ABC");
	}
	
	@Test
	public void testVehicleReservation() throws InvalidCreditCardException, UnreservedVehicleException, ReservedVehicleException {
		Car car = new Car("C300", "29", "3", "ABC");
		
		assertTrue(!car.isReserved());
		
		Reservation resv = new Reservation("AIR", "1234567890123456", "days", "3");
		car.reserve(resv);
		
		assertTrue(car.isReserved());
		assertEquals(car.getReservation(), resv);
		
		car.cancelReservation();
		assertTrue(!car.isReserved());
	}
	
	@Test
	public void testVehicleAlreadyReserved() throws UnreservedVehicleException, ReservedVehicleException, InvalidCreditCardException {
		thrown.expect(ReservedVehicleException.class);
		
		Car car = new Car("C300", "29", "3", "ABC");
		car.reserve(new Reservation("AIR", "1234567890123456", "days", "3"));
		car.reserve(new Reservation("AIR", "1234567890123456", "days", "3"));
	}
	
	@Test
	public void testVehicleNotReserved() throws UnreservedVehicleException {
		thrown.expect(UnreservedVehicleException.class);
		
		Car car = new Car("C300", "29", "3", "ABC");
		car.getReservation();
	}
	
	@Test
	public void testVehicleNotReservedCancelReservation() throws UnreservedVehicleException {
		thrown.expect(UnreservedVehicleException.class);
		
		Car car = new Car("C300", "29", "3", "ABC");
		car.cancelReservation();
	}

}
