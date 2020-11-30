import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PersonalDataTest {
    @Test
    public void personCreateTest(){
        PersonalData person = new PersonalData();
        assertEquals("untitled", person.getName());
        assertEquals("untitled", person.getAddress());
        assertEquals("0000000000", person.getNIP());
        assertEquals("00000000000000000000000000", person.getBankAccountNumber());
    }
    @Test
    public void setWrongNIPTest(){
        PersonalData person = new PersonalData();
        person.setNIP("123");
        assertEquals("0000000000", person.getNIP());
    }
    @Test
    public void setWrongBankAccountAccountTest(){
        PersonalData person = new PersonalData();
        person.setNIP("123");
        assertEquals("00000000000000000000000000", person.getBankAccountNumber());
    }
    @Test
    public void setWrongBankAccountAccountCharactersTest(){
        PersonalData person = new PersonalData();
        person.setNIP("11111111111111111111111111");
        assertEquals("00000000000000000000000000", person.getBankAccountNumber());
    }
}
