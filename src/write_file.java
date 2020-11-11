import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Random;

public class write_file {



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

                    else if(Math.random() < 0.1) { // 10% probability that these two points are not connected directly
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


    public static void main(String[] args) {
        String fileName = "Dijkstra test4";
        int V = 1000;
        creat(fileName);
        write(fileName, V);
    }



}
