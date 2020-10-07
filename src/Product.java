public class Product {
    private String productName;
    private int productID;
    private double price;

    public Product(String productName, int productID, double price){
        this.productName = productName;
        this.productID = productID;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
