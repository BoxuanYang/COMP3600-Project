import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Warehouse_empirical {
    public static void creat(String fileName){
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

    static LinkedList<Product> products = new LinkedList<>();
    static Warehouse warehouse = new Warehouse();

    /**
     * Create n Product objects
     * @param n
     */
    public static void createProducts(int n){

        Random r = new Random();

        for(int i = 0; i < n; i++){
            double price = 0 + (200 - 0) * r.nextDouble();
            Product product = new Product("product" + i, i, price);
            products.add(product);
        }
    }

    public static void main(String[] args) {
       int[] size = new int[100];
       for(int i = 0; i < size.length; i++){
           size[i] = 1000 + 1000 * i;
       }
        System.out.println(Arrays.toString(size));

       double average_time[] = new double[size.length];

       for(int i = 0; i < size.length; i++) {
           createProducts(size[i]);

           /**
            * Add all the products in the warehouse.
            */
           for (int j = 0; j < size[i]; j++) {
               int productID = size[i] - j;
               warehouse.add(products.get(j), productID);
           }

           double time = 0;

           for (int j = 0; j < 300; j++) {
               Product product = products.get(j);
               long start = System.nanoTime();
               warehouse.find(product);
               long timeElapsed = System.nanoTime() - start;
               time += (double) timeElapsed / 300;
           }

           average_time[i] = time;
           System.out.println("Iteration-" + i + " finished.");
       }

           creat("Hash empirical");
           try {
               FileWriter myWriter = new FileWriter("Hash empirical");



               for (int i = 0; i < average_time.length; i++) {
                   myWriter.write(average_time[i] + " " + size[i]);
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
