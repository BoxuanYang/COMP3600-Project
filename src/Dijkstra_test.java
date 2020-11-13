import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_test {
    final static int M = Integer.MAX_VALUE;

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


    public static void test(String fileName) throws FileNotFoundException {
        int[][] graph = readFile(fileName);



        Dijkstra dijkstra = new Dijkstra();
        int[] shortestDistance = dijkstra.shortestDistance(graph);


       ShortestPath shortestPath = new ShortestPath();
       int[] shortest = shortestPath.dijkstra(graph, 0);


       for(int i = 0; i < graph.length; i++){
           if(shortestDistance[i] != shortest[i]) {
               System.out.println("Test failed!");
               return;
           }
       }

        System.out.println("Test passed! Congratulation!");


    }



    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        test(fileName);
    }
}
