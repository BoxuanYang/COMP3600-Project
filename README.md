# COMP3600-Project


The user interface is the Main class. This class comprises of 2 parts, the setup part and the
functionality part. 

In the setup part, the company defines all the products available using the class Product. For each 
product, they also need to specify its location using the class Location, then store that Location
object into the Warehouse object, which is a Hash table structure. In my implementation, all the 
products are trivial, they have the name P0, P1, P2 etc. Their price is a random number.

It is worth pointing out that we also generate the orders that needs to be processed. That is for
demonstration purpose only. If we have a txt file which stores all orders info, we can generate 
orders based on that file.

For the functionality part, it is fairly simple. We have 2 functionalities here: 1: Select the order
with highest priority and 2: Find the location of the corresponding product in the warehouse.
Functionality 1 is implemented using: 
```
Order order = orders.process();
System.out.println("The order with highest priority is: " + order.toString());
```

Functionality 2 is implemented with:
```
Product product = order.getProduct();
Location location = warehouse.find(product);
System.out.println("The location of the product in warehouse is area" + location.getArea());
```

To run the code, you only need to click the run button(if you are using IDE). Or you can use the
command line:
```
javac Main.java
java Main
```

