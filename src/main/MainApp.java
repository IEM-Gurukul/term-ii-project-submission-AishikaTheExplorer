package main;

import model.*;
import service.*;
import exception.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderAssignmentManager manager = new OrderAssignmentManager();

        System.out.println("=== Smart Food Delivery System ===");

        while (true) {
            System.out.println("\n1. Add Delivery Partner");
            System.out.println("2. Add Food Order");
            System.out.println("3. Add Grocery Order");
            System.out.println("4. Assign Orders");
            System.out.println("5. Complete Delivery");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
    System.out.print("Enter Partner ID: ");
    int pId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Partner Name: ");
    String pName = sc.nextLine();

    System.out.print("Enter Partner Distance from location: ");
    double pDist = sc.nextDouble();

    manager.registerPartner(new DeliveryPartner(pId, pName, pDist));
    System.out.println("Delivery Partner Added!");
    break;

                case 2:
                    System.out.print("Enter Order ID: ");
                    int fId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String fName = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String fAddress = sc.nextLine();

                    System.out.print("Enter Distance: ");
                    double fDist = sc.nextDouble();

                    manager.addOrder(new FoodOrder(fId, fName, fAddress, fDist));
                    System.out.println("Food Order Added!");
                    break;

                case 3:
                    System.out.print("Enter Order ID: ");
                    int gId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String gName = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String gAddress = sc.nextLine();

                    System.out.print("Enter Distance: ");
                    double gDist = sc.nextDouble();

                    manager.addOrder(new GroceryOrder(gId, gName, gAddress, gDist));
                    System.out.println("Grocery Order Added!");
                    break;

                case 4:
                    try {
                        manager.assignOrders();
                    } catch (NoAvailablePartnerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
case 5:
    System.out.print("Enter Partner ID to mark available: ");
    int id = sc.nextInt();

    boolean found = false;

    for (DeliveryPartner p : manager.getPartners()) {
        if (p.getId() == id) {
            p.setAvailable(true);
            System.out.println("Partner is now available!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Partner not found!");
    }
    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}