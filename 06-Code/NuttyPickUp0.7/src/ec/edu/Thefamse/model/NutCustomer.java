package ec.edu.Thefamse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
 * @author narvaez leonardo
 */
public class NutCustomer {
    private int id;
    private String name;
    private String contact;
    private String orderHistory;
    
    public NutCustomer(String name, String contact) {
        this.id = generateId();
        this.name = name;
        this.contact = contact;
        this.orderHistory = "";
    }
    
    public static NutCustomer createAccount() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese su nombre:");
    String name = scanner.nextLine();
    if (name.isEmpty()) {
        throw new IllegalArgumentException("El nombre no debe estar vacio.");
    }
    if (containsNumbers(name)) {
        throw new IllegalArgumentException("El nombre no debe contener numeros.");
    }

    System.out.println("Ingrese su contacto:");
    String contact = scanner.nextLine();
    if (contact.isEmpty()) {
        throw new IllegalArgumentException("El contacto no debe estar vacio.");
    }
    if (containsLetters(contact) || isNegativeNumber(contact)) {
        throw new IllegalArgumentException("El contacto no debe contener letras ni numeros negativos.");
    }

    return new NutCustomer(name, contact);
}


    private static int generateId() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese su ID:");
        int id = scanner.nextInt();
        if (id < 0) {
            throw new IllegalArgumentException("El ID no debe ser negativo.");
        }
        
        return id;
    }
    
    private static boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }

    private static boolean containsLetters(String input) {
        return input.matches(".*[a-zA-Z].*");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    private static boolean isNegativeNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "NutCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", orderHistory='" + orderHistory + '\'' +
                '}';
    }

}
