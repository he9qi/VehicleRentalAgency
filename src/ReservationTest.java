import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ReservationTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEmptyCreditCard() throws InvalidCreditCardException {
		thrown.expect(InvalidCreditCardException.class);
		
		new Reservation("BMW", "", "days", "3");
	}
	
	@Test
	public void testNonDigitCreditCard() throws InvalidCreditCardException {
thrown.expect(InvalidCreditCardException.class);
		
		new Reservation("BMW", "123IA", "days", "3");
	}
	
	@Test
	public void testInvalidLengthCreditCard() throws InvalidCreditCardException {
thrown.expect(InvalidCreditCardException.class);
		
		new Reservation("BMW", "4401102001", "days", "3");
	}
	
	@Test
	public void testCreditCardInfo() throws InvalidCreditCardException{
		Reservation reservation = new Reservation("BMW", "1234567890123456", "days", "2");
		
		assertEquals(reservation.getCompanyName(), "BMW");
		assertEquals(reservation.getCreditCardNum(), "1234567890123456");
		assertEquals(reservation.getRentalPeriodType(), "days");
		assertEquals(reservation.getRentalTime(), "2");
	}

}
