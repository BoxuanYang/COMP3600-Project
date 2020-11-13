import java.util.Arrays;

public class Dijkstra {

    private static int n; // |V|

    public int[] shortestDistance(int[][] distances){
        assert distances.length == distances[0].length: "Invalid graph!";

        n = distances.length;
        /**
         * Shortest path array. shortest_path[i] represents the shortest path from Node 0 to Node i.
         * By default, shortest_path[0] = 0. If shortest_path[i] = 0, then there does nor exist a
         * path from Node 0 to Node i.
         */
        int[] shortest_path = new int[n];
        /**
         * This is an array used to record that whether an Node has been used as smallest index.
         * If used, it is 1 and is 0 otherwise. checked[0] is always 0.
         * In java, default value is 0 for new array.
         */
        int[] checked = new int[n];
        /**
         * Initialization
         */
        for(int i = 0; i < n; i++){
            if(i == 0) {
                shortest_path[i] = distances[0][i];
                continue;
            }

            else if(distances[0][i] == 0) {
                shortest_path[i] = Integer.MAX_VALUE;
                continue;
            }

            else {
                shortest_path[i] = distances[0][i];
                continue;
            }
        }



        for(int i = 1; i < n; i++){
            /**
             * Get the index of the node which has smallest distance
             */
            int smallest_index = 1; // index of Node with smallest distance
            int smallest = Integer.MAX_VALUE;

            for(int j = 1; j < n; j++){
                if(checked[j] == 1)
                    continue;

                else if(shortest_path[i] == 0)
                    continue;

                if(shortest_path[j] < smallest){
                    smallest = shortest_path[j];
                    smallest_index = j;
                }
            }
            checked[smallest_index] = 1;

            /**
             * Update the shortest_path array.
             */
            for(int j = 1; j < n; j++){
                if(distances[smallest_index][j] == Integer.MAX_VALUE || distances[smallest_index][j] == 0)
                    continue;

                if(shortest_path[smallest_index] + distances[smallest_index][j] < shortest_path[j]){
                    shortest_path[j] = shortest_path[smallest_index] + distances[smallest_index][j];
                }
            }


//            System.out.println(Arrays.toString(shortest_path));
        }

        return shortest_path;
    }



    public static void main(String[] args) {
        int M = Integer.MAX_VALUE;



        //test case 5
        int[][] distances = {
                {0, 10,15, 0,  0,  0},
                {0, 0, 0,  15, 12, 0},
                {0, 0, 0,  0,  0,  10},
                {0, 0, 0,  0,  0,  5},
                {0, 0, 0,   1,  0,  2},
                {0, 0, 0,   0,  0,  0}
        };

        Dijkstra dijkstra = new Dijkstra();
        int[] shortestDistance = dijkstra.shortestDistance(distances);

        System.out.println(Arrays.toString(shortestDistance));

    }
}
