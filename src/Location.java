public class Location {
    private Product product;
    private int roomIndex;

    public Location(Product product, int roomIndex){
        this.product = product;
        this.roomIndex = roomIndex;
    }

    public Product getProduct() {
        return product;
    }

    public int getRoomIndex() {
        return roomIndex;
    }
}
