public class Location {
    private Product product;
    private int area;

    public Location(Product product, int area){
        this.product = product;
        this.area = area;
    }

    public Product getProduct() {
        return product;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        String str = "The location of the product is: " + area;
        //TODO
        return super.toString();
    }
}
