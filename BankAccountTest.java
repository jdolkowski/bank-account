import org.junit.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    @Test
    public void addMoneyTest(){
        BankAccount test = new BankAccount();
        test.addMoney(200f);
        assertEquals(200f, test.getAccountBalance(), 0.0f);
    }
    @Test
    public void takeMoneyTest(){
        BankAccount test = new BankAccount();
        test.addMoney(200f);
        test.takeMoney(50f);
        assertEquals(150f, test.getAccountBalance(), 0.0f);
    }
    @Test
    public void transferTest(){
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount();
        a1.addMoney(500.0f);
        a1.transferToAccount(a2, 100.0f, "za mieszkanie");
        assertEquals(100.0f, a2.getAccountBalance(), 0.0f);
        assertEquals(400.0f, a1.getAccountBalance(), 0.0f);
    }
    @Test
    public void transferFailTest(){
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount();
        a2.addMoney(50);
        a1.transferToAccount(a2, 100.0f, "za mieszkanie");
        assertEquals(50, a2.getAccountBalance(), 0.0f);
        assertEquals(0, a1.getAccountBalance(), 0.0f);
    }
    @Test
    public void transferSearchTest(){
        BankAccount a1 = new BankAccount("Jan Kowalski");
        BankAccount a2 = new BankAccount("Adam Nowak");
        a1.addMoney(1000);
        a1.transferToAccount(a2, 250, "rachunki", new Date(2000, Calendar.JUNE, 18));
        a1.transferToAccount(a2, 50, "kino", new Date(2000, Calendar.JUNE, 19));
        a1.transferToAccount(a2, 30, "jedzenie", new Date(2000, Calendar.JUNE, 20));
        a2.transferToAccount(a1, 200, "leki", new Date(2000, Calendar.JUNE, 21));

        a1.seeHistory(new Date(2000, Calendar.JUNE, 19), new Date(2000, Calendar.JUNE, 20));

    }

}
