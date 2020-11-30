import org.junit.*;

import static org.junit.Assert.assertEquals;
public class ProductTest {
    @Test
    public void taxConvertFloatTest(){
        Product test = new Product();
        test.setTax(0.15f);
        assertEquals(0.15f, test.getTaxFloat(), 0.0f);
    }

    @Test
    public void taxConvertStringTest(){
        Product test = new Product();
        test.setTax("15%");
        assertEquals(0.15f, test.getTaxFloat(), 0.0f);
    }
    @Test
    public void getTaxStringTest(){
        Product test = new Product();
        test.setTax(0.15f);
        assertEquals("15.00%", test.getTaxString());
    }

    @Test
    public void floatTaxTest(){
        Product test = new Product("mleko", 5, 0.23f, 3.0f);
        assertEquals(2.31f, test.getProductNetPrice(), 0.01f);
    }
    @Test
    public void stringTaxTest(){
        Product test = new Product("mleko", 5, "23%", 3);
        assertEquals(2.31f, test.getProductNetPrice(), 0.01f);
    }
    @Test
    public void outOfBoundriesQuantityTest(){
        Product test = new Product("mleko", -1, "23%", 3);
        assertEquals(0, test.getQuantity());
    }

}



