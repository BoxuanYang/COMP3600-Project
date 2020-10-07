public class Linkedlist<T> {
    LL first, last;
    int elements;

    public Linkedlist(){
        first = last = null;
        elements = 0;
    }

    public class LL{
        T value;
        LL next;

        public LL(T value, LL next){
            this.value = value;
            this.next = next;
        }

        public LL(T value){
            this.value = value;
            this.next = null;
        }
    }

    public void add(T value){
        // TODO
    }

    public void remove(T value){
        //TODO
    }

    public int size(){
        return this.elements;
    }

    public T get(int index){
        // TODO
        return null;
    }
}
