public class Order implements Comparable<Order>{
    private int ID;
    private Item item;
    private int quantity;
    private double remaining_time;
    private Address address;
    // priority = a * quantity * price + b * remaining_time, it can be negative
    private double priority;
    private int a = 2;
    private int b = -1;

    public Order(int ID, Item item, int quantity, double remaining_time, Address address){
        this.ID = ID;
        this.item = item;
        this.quantity = quantity;
        this.remaining_time = remaining_time;
        this.address = address;
        this.priority = a * quantity * item.getPrice() + b * remaining_time;
    }

    public int getID() {
        return ID;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getRemaining_time() {
        return remaining_time;
    }

    public Address getAddress() {
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
}
