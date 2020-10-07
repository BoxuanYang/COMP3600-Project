public class Product {
    private String productName;
    private int productID;
    private double price;

    public Product(String itemName, double price){
        this.productName = itemName;
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
