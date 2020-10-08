import java.util.LinkedList;

public class Warehouse<T> {
    /**
     * Contains locations of all products in warehouse.
     */
    final static double GROWTH_FACTOR = 4; // the expected number of elements in each bucket, # elements / buckets
    final private static int DEAFULT_BUKTS = 2; // default number of buckets

    private LinkedList<Location>[] table;

    private int elements; // total number of elements in the hash table
    private double ratio; // #elements / #buckets

    public Warehouse(){
        this.table = new LinkedList[DEAFULT_BUKTS];
        this.elements = 0;
        this.ratio = 0;

    }

    /**
     *  Add a product location to the hash table.
     * @param location
     */
    public void add(Location location){
        //TODO
    }

    /**
     * Find the bucket that this product belongs to.
     * @param product
     * @return
     */
    public int hash(Product product){
        // TODO
        return 0;
    }

    /**
     *
     * @param product
     * @return
     */
    public Location find(Product product){
        //TODO
        int hashCode = hash(product);
        return null;
    }
}

