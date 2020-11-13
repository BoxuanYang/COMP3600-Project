import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dijkstra_empirical {
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

    public static void write(String fileName, int n){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(n + "");
            myWriter.write("\r\n");   // write new line

            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j){
                        int distance = 0;
                        myWriter.write(distance + " ");
                        continue;
                    }


                    else{
                        //distance is a value in [0, 1000]
                        Random random = new Random();
                        int distance = (int) ((Math.random() * (1000 - 0)) + 0);
                        myWriter.write(distance + " ");
                        continue;
                    }
                }
                myWriter.write("\r\n");   // write new line
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int[][] readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        System.out.println("Graph size is: " + n + " * " + n);
        scanner.nextLine();

        int[][] graph = new int[n][n];

        while(scanner.hasNextInt()) {
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    graph[i][j] = scanner.nextInt();
                }
                scanner.nextLine();
            }
        }


        return graph;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] size = new int[80];
        for(int i = 0; i < size.length; i++){
            size[i] = 1000 + 100 * i;
        }

        double[] time = new double[size.length];

        for(int i = 0; i < size.length; i ++){
            long average_time = 0;

            String fileName = "Dijkstra test6";
            write(fileName, size[i]);

            int[][] graph = readFile(fileName);
            Dijkstra dijkstra = new Dijkstra();
            long start = System.nanoTime();
            int[] shortestDistance = dijkstra.shortestDistance(graph);
            long timeElapsed = System.nanoTime() - start;
            average_time += timeElapsed * 0.01;

            time[i] = average_time;
        }

        creat("Dijkstra empirical");
        try {
            FileWriter myWriter = new FileWriter("Dijkstra empirical");
            myWriter.write(time.length + "");
            myWriter.write("\r\n");   // write new line

            for (int i = 0; i < time.length; i++){
                myWriter.write(time[i] + "");
                myWriter.write("\r\n");   // write new line
            }

            myWriter.close();
            System.out.println("Successfully wrote to the Dijkstra empirical file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(time));












    }
}
