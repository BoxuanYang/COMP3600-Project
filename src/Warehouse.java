import javax.swing.text.html.HTMLDocument;
import java.util.LinkedList;

public class Warehouse<T> {
    /**
     * Contains locations of all products in warehouse.
     */
    final static double GROWTH_FACTOR = 4; // the expected number of elements in each bucket, # elements / buckets
    final private static int DEAFULT_BUKTS = 2; // default number of buckets
    private LinkedList<Location> allLocations;

    private LinkedList<Location>[] table;

    private int elements; // total number of elements in the hash table
    private double ratio; // #elements / #buckets

    public Warehouse(){
        this.table = new LinkedList[DEAFULT_BUKTS];
        this.elements = 0;
        this.ratio = 4;
        this.allLocations = new LinkedList<>();
    }

    /**
     *
     * @param product
     * @param roomIndex
     */
    public void add(Product product, int roomIndex){
        //TODO
        if(find(product) != -1) // if it is already in the warehouse
            return;


        int hashCode = hash(product);
        Location l = new Location(product, roomIndex);
        this.allLocations.add(l);

        if(this.table[hashCode] == null)
            this.table[hashCode] = new LinkedList<Location>();

        this.table[hashCode].add(l);
        elements++;

        /**
         * If average elements in each slot > GROWTH_FACTOR, then we need to double the current
         * slots by 2 and add all the Location objects into the new table.
         */
        if((double) elements / table.length > GROWTH_FACTOR){
            this.table = new LinkedList[table.length * 2];
            for(Location location : allLocations){

                int hash = hash(location.getProduct());

                if(this.table[hash] == null)
                    this.table[hash] = new LinkedList<Location>();

                this.table[hash].add(location);

            }
        }


    }

    public static double getGrowthFactor() {
        return GROWTH_FACTOR;
    }

    public static int getDeafultBukts() {
        return DEAFULT_BUKTS;
    }

    public LinkedList<Location> getAllLocations() {
        return allLocations;
    }

    public LinkedList<Location>[] getTable() {
        return table;
    }

    public int getElements() {
        return elements;
    }

    public double getRatio() {
        return ratio;
    }

    /**
     * Find the bucket that this product belongs to.
     * @param product
     * @return
     */
    public int hash(Product product){
        // TODO
        return product.getProductID() % table.length;
    }

    /**
     * Return the roomIndex of the product. If the product is not in the warehouse,
     * return -1.
     * @param product
     * @return
     */
    public int find(Product product){
        //TODO
        int hashCode = hash(product);
        int ID = product.getProductID();

        if(this.table[hashCode] == null)
            return -1;

        LinkedList<Location> ll = this.table[hashCode];


        for(int i = 0; i < ll.size(); i++){
            Location l = ll.get(i);
            Product p = l.getProduct();

            int id = p.getProductID();
            if(id == ID)
                return l.getRoomIndex();
        }

        return -1;
    }
}