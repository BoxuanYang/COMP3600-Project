public class Orders {
    //This is a class which stores all orders in a max heap data structure

    private Node root;

    public Orders(Order order){
        this.root = new Node(order);
    }

    public Orders(){
        this.root = null;
    }

    /**
     * Return the order with highest priority, then delete that.
     * @return The order object with highest priority.
     */
    public Order process(){
        Order order = root.getOrder();
        root.delete(order);
        return order;
    }

    /**
     * Add an order to the heap
     * @param order
     */
    public void add(Order order){
        if(this.root == null)
            this.root = new Node(order);

        else
            root.add(order);
    }



    public static class Node implements Comparable<Node>{
        private Order order;
        Node left;
        Node right;

        public Node(Order order){
            this.order = order;
            this.left = null;
            this.right = null;
        }

        public Order getOrder(){
            return this.order;
        }

        public void add(Order order){
            //TODO
        }

        public void delete(Order order){
            //TODO
        }


        @Override
        public int compareTo(Node node) {
            return this.getOrder().compareTo(node.getOrder());
        }
    }

    public static void main(String[] args) {
        Order order1 = new Order(0, new Product("iPhone",01, 22), 3, 11.2, new Address(0,1));
        Order order2 = new Order(0, new Product("Apple",02, 2), 1, 20, new Address(0,1));

        Node node1 = new Node(order1);
        Node node2 = new Node(order2);
        System.out.println(order1.getPriority());
        System.out.println(order2.getPriority());
        System.out.println(node2.compareTo(node1));
    }

}
