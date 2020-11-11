public class Order implements Comparable<Order>{
    /**
     * Each order can only contain 1 type of product.
     */
    private int ID;
    private Product product;
    private int quantity;
    private double remaining_time;
    private String address;
    // priority = quantity * price
    private double priority;
    private int a = 2;
    private int b = -1;

    public Order(int ID, Product product, int quantity,  String address){
        this.ID = ID;
        this.product = product;
        this.quantity = quantity;

        this.address = address;
        this.priority = a * quantity * product.getPrice() ;
    }

    public int getID() {
        return ID;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }



    public String getAddress() {
        return address;
    }

    public double getPriority(){
        return this.priority;
    }


    @Override
    public int compareTo(Order order) {
        if(this.priority > order.getPriority()){
            return 1;
        }

        else if(this.priority == order.getPriority())
            return 0;

        else return -1;
    }

    @Override
    public String toString() {
        // TODO
        return super.toString();
    }
}
