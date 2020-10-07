import java.lang.Math;

public class Main {
    static int n = 1000; // the number of orders
    static int m = 800; //  the number of products we sell
    static double min = 0.0; // min value of the product price
    static double max = 1000.0; // max value of the product price

    public static void main(String[] args) {
        /**
         * The code below is to generate m products with the product name P0, P1...Pm.
         * Their price is a random number of type double between (min, max), values of min and max are specified above.
         * Also, each product has a DISTINCT productID, in this case, the productID's are 0, 1, 2...m.
         */
        Product[] products = new Product[m];
        for(int i = 0; i < m; i ++){
            double price = Math.random() * (max - min + 1) + min;
            products[i] = new Product("P" + i, i, price); // Product(String productName, int productID, double price)
        }

        /**
         * The code below generates the area index at which the product is stored.
         */
        Location[] locations = new Location[m];
        for(int i = 0; i < m; i++){
            locations[i] = new Location(products[i], m-1 - i);
        }

        /**
         * The code below is to generate n orders, store them in a heap Orders object. Each order contains:
         * 1. A unique orderID. In this case, their IDs are 0, 1, 2...n.
         * 2. The product object. In this case, the product is a random object from the product array above.
         * 3. The number of products to be delivered. In this case, this a random integer between [1, 10].
         * 4. The remaining delivery time of the order. In this case, this a random double between (0, 30).
         * 5. Address of the order, represented by an address object. In this case, X and Y are random ints in [1, 20].
         */

        Orders orders = new Orders();
        for(int i = 0; i < n; i++){
            //public Order(int ID, Product product, int quantity, double remaining_time, Address address){
            int productIndex = (int) (Math.random() * (m - 0 + 1) + 0);
            int quantity = (int) (Math.random() * (10 - 1 + 1) + 1);
            double remaining_time = Math.random() * (30 - 0 + 1) + 0;
            int x = (int)(Math.random() * (20 - 1 + 1) + 1);
            int y = (int)(Math.random() * (20 - 1 + 1) + 1);
            Order order = new Order(i, products[productIndex], quantity, remaining_time, new Address(x, y));
            orders.add(order);
        }

        /**
         * The code below is to process all the orders we receive-extract the order with highest priority.
         */
        for(int i = 0; i < n; i++){
            Order order = orders.process();
        }




    }
}
