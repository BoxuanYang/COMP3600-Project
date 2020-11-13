import org.w3c.dom.ls.LSOutput;

public class Orders {
    /**
     * This is a class which stores all orders in a max heap data structure
     */

    private int maximumSize;
    private Order[] heap;
    private int size;



    public Orders(int maximumSize){
        this.maximumSize = maximumSize;
        this.size = 0;
        this.heap = new Order[maximumSize];
    }


    public Order getMax(){
        Order maxOrder = heap[0];
        deleteRoot();
        return maxOrder;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public void deleteRoot(){
        if(size == 0)
            return;

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        this.size--;
        heapifyRoot();
    }

    public int size(){
        return this.size;
    }

    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex){

        return 2 * parentIndex + 2;
    }



    private int getParentIndex(int childIndex){
        assert childIndex >= 0 && childIndex < size: "Invalid index";

        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChildIndex(int index){
        assert index >= 0 && index < size: "Invalid index";

        int leftIndex = getLeftChildIndex(index);

        if(leftIndex >= size)
            return false;

        return heap[leftIndex] != null;
    }

    private boolean hasRightChildIndex(int index){
        assert index >= 0 && index < size: "Invalid index";

        int rightIndex = getRightChildIndex(index);

        if(rightIndex >= size)
            return false;

        return heap[rightIndex] != null;
    }

    private boolean hasParent(int index){
        assert index >= 0 && index < size: "Invalid index";

        if(index <= 0)
            return false;

        int parentIndex = getParentIndex(index);

        return heap[parentIndex] != null;


    }

    private Order parent(int childIndex){
        assert childIndex >= 0 && childIndex < size: "Invalid index";

        return heap[getParentIndex(childIndex)];

    }

    private Order leftChild(int parentIndex){
        assert parentIndex >= 0 && parentIndex < size: "Invalid index";

        return heap[getLeftChildIndex(parentIndex)];
    }

    private Order rightChild(int parentIndex){
        assert parentIndex >= 0 && parentIndex < size: "Invalid index";

        return heap[getRightChildIndex(parentIndex)];
    }

    private void swap(int index1, int index2){
        assert index1 >= 0 && index1 < size: "Invalid index";
        assert index2 >= 0 && index2 < size: "Invalid index";

        Order tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    public void add(Order order){
        if(this.size == maximumSize){
            System.out.println("Maximum number of orders reached, cannot accept more!");
            return;
        }

        heap[size] = order;
        this.size++;
        heapify();
    }

    private void heapify(){
        int index = size - 1;

        while(hasParent(index) && parent(index).getPriority() < heap[index].getPriority()){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    private void heapifyRoot(){
        int index = 0;

        while(hasLeftChildIndex(index)){
            int largestChildIndex = getLeftChildIndex(index);

            if(hasRightChildIndex(index) && rightChild(index).getPriority() > leftChild(index).getPriority()){
                largestChildIndex = getRightChildIndex(index);
            }

            if(heap[index].getPriority() < heap[largestChildIndex].getPriority()){
                swap(index, largestChildIndex);
            }

            else
                break;

            index = largestChildIndex;
        }
    }


}
