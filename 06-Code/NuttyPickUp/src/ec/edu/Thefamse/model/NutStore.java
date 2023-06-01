package ec.edu.Thefamse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author narvaez leonardo
 */
public class NutStore {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
    int option;
    NutProduct product = null;
    Reservation reservation = null;
    List<NutCustomer> customers = new ArrayList<>();

        do {
            System.out.println("Menu de opciones: ");
            System.out.println("1. Crear nuevo usuario.");
            System.out.println("2. Agregar nuevo producto.");
            System.out.println("3. Comprar producto.");
            System.out.println("4. Editar compra.");
            System.out.println("5. Estado de compra.");
            System.out.println("6. Reporte.");
            System.out.println("7. Salir.");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    NutCustomer customer = NutCustomer.createAccount();
                    System.out.println("Cuenta creada.");
                    break;
                case 2:
                    product = NutProduct.addProduct();
                    System.out.println("Producto agregado.");
                    break;
                case 3:
                    if (product == null) {
                        System.out.println("No se ha seleccionado ningun producto.");
                    } else {
                        if (reservation == null) {
                            reservation = new Reservation(product);
                        }

                        if (reservation.isPurchased()) {
                            System.out.println("Ya realizo la compra.");
                        } else {
                            reservation.purchase();
                        }
                    }
                    break;
                case 4:
                       if (reservation == null) {
                         System.out.println("No se ha realizado ninguna compra.");
                         } else {
                         PurchaseModifier purchaseModifier = new PurchaseModifier(reservation);
                            purchaseModifier.modifyPurchase();
                         }
                break;
                case 5:
                       if (reservation == null) {
                           System.out.println("No se ha realizado ninguna compra.");
                           } else {
                           State state = new State(reservation);
                           state.viewState();
                           }
                    break;
                case 6:

                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción incorrecta, ingrese de nuevo: ");
                    break;
            }
        } while (option != 7);

    }
}
