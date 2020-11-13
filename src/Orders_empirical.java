import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Orders_empirical {
    static LinkedList<Order> allOrders;
    static Orders orders; // heap structure

    public static void createOrders(int n){
        allOrders = new LinkedList<>();
        orders = new Orders(120000); // heap structure

        Random r = new Random();

        for(int i = 0; i < n; i++){
            double price = 0 + (2000 - 0) * r.nextDouble();
            Product product = new Product("product" + i, n - i, price);
            int quantity = 1 + (int)(Math.random() * ((200 - 1) + 1));
            Order order = new Order(i, product, quantity, i+1);//ID, product, quantity, address
            orders.add(order);
            allOrders.add(order);
        }
    }





    public static void creatFile(String fileName){
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeOrders(String fileName, int n){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(n + "");
            myWriter.write("\r\n");   // write new line

            for (int i = 0; i < n; i++){
                /**
                 * Write products here
                 */
                Order order = allOrders.get(i);
                int orderID = order.getID();
                myWriter.write(orderID + " ");

                //Product(String productName, int productID, double price)
                Product product = order.getProduct();
                String productName = product.getProductName();
                myWriter.write(productName + " ");

                int productID  = product.getProductID();
                myWriter.write(productID + " ");

                double price = product.getPrice();
                myWriter.write(price + " ");

                int quantity = order.getQuantity();
                myWriter.write(quantity + " ");

                int address = order.getAddress();
                myWriter.write(address + " ");

                myWriter.write("\r\n");   // write new line
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int size = 120000;


        double[] average_time = new double[80];
        int[] sizes = new int[80];



        /**
         * Create size[i] orders and add them all to the heap
         */
        createOrders(size);


        for(int i = 0; i < size; i++){
            double time = 0;

            for(int j = 0; j < 50; j++) {
                long start = System.nanoTime();
                Order order = orders.getMax();
                long timeElapsed = System.nanoTime() - start;
                time += (double) timeElapsed /50;

                orders.add(order);
            }

            orders.deleteRoot();

            if(i % 1500 == 0) {
                average_time[i / 1500] = time;
                sizes[i / 1500] = orders.size();
                System.out.println("Iteration-" + i + " finished.");
            }


        }



        creatFile("Heap empirical");
        try {
            FileWriter myWriter = new FileWriter("Heap empirical");

            for (int i = 0; i < average_time.length; i++) {
                myWriter.write(average_time[i] + " " + sizes[i]);
                myWriter.write("\r\n");   // write new line
            }

            myWriter.close();
            System.out.println("Successfully wrote to the Dijkstra empirical file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


}
