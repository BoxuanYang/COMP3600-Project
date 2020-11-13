import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Orders_test {
    static Order[] allOrders;
    static Orders orders = new Orders(10000);



    /**
     * This method is from here:
     * For testing purpose only
     * https://www.baeldung.com/java-merge-sort
     */
    public static void mergeSort(Order[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Order[] l = new Order[mid];
        Order[] r = new Order[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * This method is from here: https://www.baeldung.com/java-merge-sort
     * For testing purpose only
     */
    public static void merge(Order[] a, Order[] l, Order[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i].getPriority() >= r[j].getPriority()) {
                a[k++] = l[i++];
            }

            else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void test(){
        mergeSort(allOrders, allOrders.length);

        for(int i = 0; i < orders.size(); i++){

            double priority = orders.getMax().getPriority();

            if(priority != allOrders[i].getPriority()){
                System.out.println("Test failed!");
                return;
            }
        }
        System.out.println("Test passed!");
    }



    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        allOrders = new Order[n];

        System.out.println("Size of order heap is: " + n);
        scanner.nextLine();


        while(scanner.hasNext()) {

            for(int i = 0; i < n; i++){
                int orderID = scanner.nextInt();
                String productName = scanner.next();
                int productID = scanner.nextInt();
                double price = scanner.nextDouble();
                int quantity = scanner.nextInt();
                int address = scanner.nextInt();

                Product product = new Product(productName, productID, price);

                Order order = new Order(orderID, product, quantity, address);
                allOrders[i] = order;
                orders.add(order);
                scanner.nextLine();
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Heap test4";
        System.out.println("We are running test on file: " + fileName);
        readFile(fileName);
        test();
    }


}
