package ShoppingCartSystem;

public class Product {
    private int productId;
    private  String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    public int getProductId() {return productId;}
    public String getProductName() {return productName;}
    public double getprice() {return price;}

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " Price: ₹" + String.format("%.2f", price);
    }

    public double getPrice() {
        return price;
    }
}
