import java.util.ArrayList;
import java.util.Date;

public class Fvat {
    private final ArrayList<Product> products;
    private int invoiceQuantity;
    private float invoiceNetPrice;
    private float invoiceGrossPrice;
    private final PersonalData buyerPersonalData;
    private final PersonalData sellerPersonalData;
    private final Date invoiceDate;
    private final Date sellDate;
    private static int invoiceNumber;

    public Fvat(ArrayList<Product> _products, PersonalData _buyerPersonalData, PersonalData _sellerPersonalData) {
        products = new ArrayList<>(_products);
        buyerPersonalData =  new PersonalData(_buyerPersonalData);
        sellerPersonalData = new PersonalData(_sellerPersonalData);
        invoiceDate = new Date();
        sellDate = new Date();
        invoiceNumber++;

            for(Product i : products){
                this.invoiceQuantity += i.getQuantity();
                this.invoiceNetPrice += i.getProductNetPrice() * i.getQuantity();
                this.invoiceGrossPrice += i.getProductGrossPrice() * i.getQuantity();
            }
    }

    public int getInvoiceQuantity() {
        return invoiceQuantity;
    }

    public float getInvoiceNetPrice() {
        return invoiceNetPrice;
    }

    public float getInvoiceGrossPrice() {
        return invoiceGrossPrice;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }


    public void printInvoice(){
        int count = 1;
        for(Product i : products){
            System.out.println(count + ". " + " Nazwa: "+ i.getName() + " Ilość: " + i.getQuantity() + " Cena Netto: " + i.getProductNetPrice()
                    + " Cena Brutto: " + i.getProductGrossPrice() + " VAT: " + i.getTaxString());
            count++;
        }

        System.out.println("łączna ilość: " + this.getInvoiceQuantity() + " łączna cena neto: " + this.getInvoiceNetPrice() + " łączna cena brutto: "
        + this.getInvoiceGrossPrice());

        System.out.println("Dane klienta: " + buyerPersonalData.getName() + " adres: " + buyerPersonalData.getAddress() + " NIP: " + buyerPersonalData.getNIP()
        + " numer konta: " + buyerPersonalData.getBankAccountNumber());

        System.out.println("Dane sprzedającego: " + sellerPersonalData.getName() + " adres: " + sellerPersonalData.getAddress() + " NIP: " + sellerPersonalData.getNIP()
                + " numer konta: " + sellerPersonalData.getBankAccountNumber());
        System.out.println("data zakupu: " + this.getSellDate() + " data wystawienia faktury: " + this.getInvoiceDate());
        System.out.println("Numer faktury: " + this.getInvoiceNumber());
    }
}
