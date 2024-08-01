package giorgiaipsaropassione;

import giorgiaipsaropassione.entities.Customer;
import giorgiaipsaropassione.entities.Order;
import giorgiaipsaropassione.entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    static List<Product> warehouse = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        initializeWarehouse();
        createCustomers();
        placeOrders();
        printList(orders);


        System.out.println("************* ESERCIZIO 1 *****************");

        getOrdersByClient().forEach((customer, orders) -> {
            System.out.println("Il cliente: " + customer + " ha fatto " + orders.size() + " ordini");
            System.out.println("Ordini: " + orders);
        });


    }

    // ESERCIZIO 1 --- Raggruppare gli ordini per cliente ---

    public static Map<Customer, List<Order>> getOrdersByClient() {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    // ESERCIZIO 2 --- Dato un elenco di ordini, calcolare il totale delle vendite di ogni cliente ---
    
    public static void printList(List<?> l) {
        for (Object obj : l) {
            System.out.println(obj);
        }
    }

    public static void initializeWarehouse() {
        Product iPhone = new Product("IPhone", "Smartphones", 2000.0);
        Product korBook = new Product("Il Signore degli anelli", "Books", 102);
        Product fightClubBook = new Product("Fight Club", "Books", 18);
        Product beatYouBook = new Product("Beautiful You", "Books", 15);
        Product diapers = new Product("Pampers", "Baby", 3);
        Product toyCar = new Product("Car", "Boys", 15);
        Product toyPlane = new Product("Plane", "Boys", 25);
        Product lego = new Product("Lego Star Wars", "Boys", 500);

        warehouse.addAll(Arrays.asList(iPhone, korBook, fightClubBook, beatYouBook, diapers, toyCar, toyPlane, lego));
    }

    public static void createCustomers() {
        Customer edward = new Customer("Edward Norton", 1);
        Customer penny = new Customer("Penny Harrigan", 2);
        Customer frodo = new Customer("Frodo Baggins", 3);
        Customer steve = new Customer("Steve Jobs", 2);

        customers.add(edward);
        customers.add(penny);
        customers.add(frodo);
        customers.add(steve);
    }

    public static void placeOrders() {
        Order edwardOrder = new Order(customers.get(0));
        Order pennyOrder = new Order(customers.get(1));
        Order frodoOrder = new Order(customers.get(2));
        Order steveOrder = new Order(customers.get(3));
        Order frodoOrder2 = new Order(customers.get(2));

        Product iPhone = warehouse.get(0);
        Product korBook = warehouse.get(1);
        Product fightClubBook = warehouse.get(2);
        Product beatYouBook = warehouse.get(3);
        Product diaper = warehouse.get(4);

        edwardOrder.addProduct(iPhone);
        edwardOrder.addProduct(korBook);
        edwardOrder.addProduct(diaper);

        pennyOrder.addProduct(fightClubBook);
        pennyOrder.addProduct(beatYouBook);
        pennyOrder.addProduct(iPhone);

        frodoOrder.addProduct(korBook);
        frodoOrder.addProduct(diaper);

        steveOrder.addProduct(diaper);

        frodoOrder2.addProduct(iPhone);

        orders.add(edwardOrder);
        orders.add(pennyOrder);
        orders.add(frodoOrder);
        orders.add(steveOrder);
        orders.add(frodoOrder2);

    }
}

