import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;


public class Product {
    private String name;
    private int quantity;
    private float tax;
    private float productNetPrice;
    private float productGrossPrice;

    public Product(){
        this.name = null;
        this.quantity = 0;
        this.tax = 0;
        this.productGrossPrice = 0;
        this.productNetPrice = 0;
    }
    public Product(String name, int quantity, String tax, float productGrossPrice) {
        this(name, quantity, taxStringToFloat(tax) / 100.0f, productGrossPrice);
    }

    public Product(String name, int quantity, float tax, float productGrossPrice) {
        if(quantity > 0) {
            this.name = name;
            this.quantity = quantity;
            this.tax = tax;
            this.productGrossPrice = productGrossPrice;
            this.productNetPrice = grossToNetPrice(productGrossPrice, tax);
        } else {
            System.out.println("Niepoprawna ilosć");
        }
    }

    public String getName() {
        return name;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity > 0){
            this.quantity = quantity;
        } else {
            System.out.println("niepoprawna ilość");
        }
    }

    public float getTaxFloat() {
        return tax;
    }

    public String getTaxString() {
        BigDecimal bd = new BigDecimal(Float.toString(this.getTaxFloat() * 100));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.toString() + "%";
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
    public void setTax(String tax) {
        this.tax = taxStringToFloat(tax) / 100.0f;
    }

    public float getProductNetPrice() {
        return productNetPrice;
    }

    public void setProductNetPrice(float productNetPrice) {
        this.productNetPrice = productNetPrice;
    }

    public float getProductGrossPrice() {
        return productGrossPrice;
    }

    public void setProductGrossPrice(float productGrossPrice) {
        this.productGrossPrice = productGrossPrice;
    }
    public static float taxStringToFloat(String taxString){
        taxString = taxString.replace("%", "");
        return Float.parseFloat(taxString);
    }
    public static float grossToNetPrice(float grossPrice, float tax){
        return grossPrice - (tax * grossPrice);
    }
    public static float netToGrossPrice(float netPrice, float tax){
        return netPrice + (tax * netPrice);

    }

}
