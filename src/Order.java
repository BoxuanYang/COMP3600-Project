public class Order implements Comparable<Order>{
    /**
     * Each order can only contain 1 type of product, the quantity, remaining_time, customer address, a priority number.
     */
    private int ID;
    private Product product;
    private int quantity;
    private int address;
    // priority = quantity * price


    public Order(int ID, Product product, int quantity,  int address){
        this.ID = ID;
        this.product = product;
        this.quantity = quantity;

        this.address = address;

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



    public int getAddress() {
        return address;
    }

    public double getPriority(){
        return quantity * product.getPrice();
    }


    @Override
    public int compareTo(Order order) {
        if(this.getPriority() > order.getPriority()){
            return 1;
        }

        else if(this.getPriority() == order.getPriority())
            return 0;

        else return -1;
    }


    public boolean equals(Order order){ //int ID, Product product, int quantity,  int address

        return this.ID == order.getID() && this.product.getProductID() == order.getProduct().getProductID()
                && this.quantity == order.quantity && this.address == order.address;



    }
}
