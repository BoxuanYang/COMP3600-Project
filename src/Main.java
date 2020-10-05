public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(0, new Item("iPhone", 22), 3, 11.2, new Address(0,1));
        Order order2 = new Order(0, new Item("Apple", 2), 1, 20, new Address(0,1));

        System.out.println(order1.getPriority());
        System.out.println(order2.getPriority());
        System.out.println(order2.compareTo(order1));
    }
}
