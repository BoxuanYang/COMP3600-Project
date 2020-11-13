import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Warehouse_test {
    static LinkedList<Location> locations = new LinkedList<>();
    static int maxRoomIndex = 99999;


    /**
     * Create n Location objects
     * @param n
     */
    public static void createLocations(int n){

        Random r = new Random();
        for(int i = 0; i < n; i++){
            double price = 0 + (200 - 0) * r.nextDouble();
            Product product = new Product("product" + i, i, price);
            locations.add(new Location(product, maxRoomIndex - i));
        }
    }

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

    public static void writeLocations(String fileName, int n){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(n + "");
            myWriter.write("\r\n");   // write new line

            for (int i = 0; i < n; i++){
                /**
                 * Write products here
                 */
                Location location = locations.get(i);
                Product product = location.getProduct();

                myWriter.write(product.getProductName() + " " + product.getProductID() + " "
                        + product.getPrice() + " " + location.getRoomIndex());

                myWriter.write("\r\n");   // write new line
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        System.out.println("Size of hashtable is: " + n);
        scanner.nextLine();



        while(scanner.hasNext()) {
            for(int i = 0; i < n; i++){
                String productName = scanner.next();
                int productID = scanner.nextInt();
                double price = scanner.nextDouble();
                int roomIndex = scanner.nextInt();
                Location location = new Location(new Product(productName, productID, price), roomIndex);
                locations.add(location);
                scanner.nextLine();
            }
        }
    }

    public static void test(){
        /**
         * Before we add a product, this product cannot be found in the warehouse
         * After we add it, it must be found in the warehouse.
         */
        Warehouse warehouse = new Warehouse();

        for(Location location : locations){

            Product product = location.getProduct();
            int roomIndex = location.getRoomIndex();

            if(warehouse.find(product) != -1){
                System.out.println("Test failed!");
                return;
            }

            warehouse.add(product, roomIndex);

            if(warehouse.find(product) == -1){
                System.out.println("Test failed!");
                return;
            }
        }
        System.out.println("Test passed!");
    }

    public static void main(String[] args) throws FileNotFoundException {
        int size = 9000;

        String fileName = "Warehouse test1";
        readFile(fileName);
        test();
    }


}
