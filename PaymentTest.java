import org.junit.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentTest {
    @Test
    public void createPaymentTest(){
        Payment payment = new Payment();
        assertEquals("untitled", payment.getTitle());
        assertNull(payment.getDate());
        assertEquals(0.f, payment.getAmount(), 0.0f);
        assertEquals("", payment.getFrom());
        assertEquals("", payment.getTo());
        payment.printPayment();
    }
    @Test
    public void createPaymentFillTest(){
        Date date = new Date(1999, Calendar.JUNE, 28);
        Payment payment = new Payment("za mieszkanie", date, 500 , "00000000000000000000000000", "11100000000000000000000000" );
        assertEquals("za mieszkanie", payment.getTitle());
        //assertEquals(); jak sprawdzic date?
        assertEquals(500.f, payment.getAmount(), 0.0f);
        assertEquals("00000000000000000000000000", payment.getFrom());
        assertEquals("11100000000000000000000000", payment.getTo());
        payment.printPayment();
    }
}
