package main;

import model.*;
import service.*;
import exception.*;

public class MainApp {
    public static void main(String[] args) {

        OrderAssignmentManager manager = new OrderAssignmentManager();

        manager.registerPartner(new DeliveryPartner(1, "Rahul"));
        manager.registerPartner(new DeliveryPartner(2, "Amit"));

        manager.addOrder(new FoodOrder(101, "John", "A Street", 5));
        manager.addOrder(new GroceryOrder(102, "Sara", "B Street", 10));
        manager.addOrder(new FoodOrder(103, "Mike", "C Street", 2));

        try {
            manager.assignOrders();
        } catch (NoAvailablePartnerException e) {
            System.out.println(e.getMessage());
        }
    }
}