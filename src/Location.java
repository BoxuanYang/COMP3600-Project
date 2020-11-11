public class Location {
    /**
     * This class is to store the location of product in the warehouse.
     */
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
