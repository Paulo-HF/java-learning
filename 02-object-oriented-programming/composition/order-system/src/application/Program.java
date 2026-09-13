package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(),dtf);

        Client client = new Client(name, email, birthDate);

        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());

        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many items to this order? ");
        int N = sc.nextInt();
        for (int i = 1; i<=N; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productname = sc.nextLine();

            System.out.print("Product price: ");
            double productprice = sc.nextDouble();

            Product product = new Product(productname, productprice);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productprice, product);

            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY");
        System.out.println(order);

        sc.close();
    }
}