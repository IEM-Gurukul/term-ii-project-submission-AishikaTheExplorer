package service;

import model.*;
import exception.*;
import java.util.*;

public class OrderAssignmentManager {

    private PriorityQueue<Order> orders;
    private List<DeliveryPartner> partners;

    public List<DeliveryPartner> getPartners() {
    return partners;
} 

    public OrderAssignmentManager() {
        orders = new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority());
        partners = new ArrayList<>();
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void registerPartner(DeliveryPartner p) {
        partners.add(p);
    }

public void assignOrders() throws NoAvailablePartnerException {

    if (partners.isEmpty()) {
        throw new NoAvailablePartnerException("No delivery partners registered!");
    }

    if (orders.isEmpty()) {
        System.out.println("No orders to assign!");
        return;
    }

    boolean assignedAny = false;

    while (!orders.isEmpty()) {

        Order o = orders.peek(); // don't remove yet

        DeliveryPartner nearest = findNearestAvailablePartner(o);

        if (nearest == null) {
            System.out.println("All delivery partners are busy. Waiting...");
            break; // STOP assigning
        }

        // Now assign
        o = orders.poll();

        nearest.setAvailable(false); // mark busy
        o.setStatus("Assigned to " + nearest.getName());

        System.out.println(
            "Order ID: " + o.getOrderId() +
            " (" + o.getDistance() + " km)" +
            " -> Assigned to " + nearest.getName() +
            " (Distance: " + nearest.getDistance() + " km)"
        );

        assignedAny = true;
    }

    if (!assignedAny) {
        System.out.println("No assignments possible right now.");
    }
}


private DeliveryPartner findNearestAvailablePartner(Order o) {

    DeliveryPartner nearest = null;
    double minDistance = Double.MAX_VALUE;

    for (DeliveryPartner p : partners) {
        if (p.isAvailable()) {

            double diff = Math.abs(p.getDistance() - o.getDistance());

            if (diff < minDistance) {
                minDistance = diff;
                nearest = p;
            }
        }
    }

    return nearest;
}

}