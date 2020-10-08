public class Address {
    /**
     * This is a data structure which stores user address, represented as a (x, y) tuple.
     */
    private int x;
    private int y;

    public Address(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
