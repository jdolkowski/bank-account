import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class FvatTest {
    @Test
    public void invoiceCreateTest() {
        Product p1 = new Product("mleko", 5, "23%", 4f);
        Product p2 = new Product("chleb", 3, 0.23f, 2.50f);
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        listOfProducts.add(p1);
        listOfProducts.add(p2);


        PersonalData buyer = new PersonalData("Jan Kowalski", "Złota 23/7", "1234567890", "12345612345612345612345611");
        PersonalData seller = new PersonalData("Kuba Nowak", "Piękna 5", "1231231230", "09876543210987654321098765");

        Fvat invoice = new Fvat(listOfProducts, buyer, seller);
        assertEquals(8, invoice.getInvoiceQuantity());
        assertEquals(27.5f, invoice.getInvoiceGrossPrice(), 0.0f);
        assertEquals("3,85 * 4 + 2,31 * 3", 21.175, invoice.getInvoiceNetPrice(), 0.01f);

        invoice.printInvoice();
    }

    @Test
    public void invoiceNumberTest() {
        Product p1 = new Product("mleko", 5, "23%", 4f);
        Product p2 = new Product("chleb", 3, 0.23f, 2.50f);
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        listOfProducts.add(p1);
        listOfProducts.add(p2);


        PersonalData buyer = new PersonalData("Jan Kowalski", "Złota 23/7", "1234567890", "12345612345612345612345611");
        PersonalData seller = new PersonalData("Kuba Nowak", "Piękna 5", "1231231230", "09876543210987654321098765");

        Fvat invoice2 = new Fvat(listOfProducts, buyer, seller);
        Fvat invoice3 = new Fvat(listOfProducts, buyer, seller);
        Fvat invoice4 = new Fvat(listOfProducts, buyer, seller);

        assertEquals(4,invoice3.getInvoiceNumber());
    }
}
