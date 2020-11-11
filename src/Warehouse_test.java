import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Warehouse_test {

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
}
