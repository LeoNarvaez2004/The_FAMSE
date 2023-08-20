package ec.edu.Thefamse.model;

import java.time.LocalDate;
/**
 *
 * @author Team 5, "THE FAMSE"
 */
public class InvoiceGenerator {
    public static void generateInvoice(NutProduct product, Reservation reservation, NutCustomer customer) {
        System.out.println("Generando factura...");
        System.out.println("------------------------------");
        System.out.println("Detalles de la factura:");
        System.out.println("Cliente: " + customer.getName());
        System.out.println("Producto: " + product.getName());
        System.out.println("Precio: $" + product.getPrice());
        System.out.println("Fecha de compra: " + LocalDate.now());
        System.out.println("------------------------------");
        System.out.println("Factura generada exitosamente.");
    }
}


