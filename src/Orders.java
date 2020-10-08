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
}
