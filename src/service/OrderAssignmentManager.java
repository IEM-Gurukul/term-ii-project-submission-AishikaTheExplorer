package service;

import model.*;
import exception.*;
import java.util.*;

public class OrderAssignmentManager {

    private PriorityQueue<Order> orders;
    private List<DeliveryPartner> partners;

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
        while (!orders.isEmpty()) {
            Order o = orders.poll();
            DeliveryPartner p = findAvailablePartner();

            if (p == null) {
                throw new NoAvailablePartnerException("No partner available!");
            }

            p.assignOrder();
            o.setStatus("Assigned to " + p.getName());

            System.out.println(o.getDetails());
        }
    }

    private DeliveryPartner findAvailablePartner() {
        for (DeliveryPartner p : partners) {
            if (p.isAvailable()) return p;
        }
        return null;
    }
}