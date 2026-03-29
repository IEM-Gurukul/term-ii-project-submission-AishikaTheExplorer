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

    if (partners.isEmpty()) {
        throw new NoAvailablePartnerException("No delivery partners registered!");
    }

    if (orders.isEmpty()) {
        System.out.println("No orders to assign!");
        return;
    }

    int index = 0;

    while (!orders.isEmpty()) {
        Order o = orders.poll();

        DeliveryPartner p = partners.get(index);

        o.setStatus("Assigned to " + p.getName());

         System.out.println(
    "Order ID: " + o.getOrderId() +
    ", Distance: " + o.distance +
    " km -> Assigned to " + p.getName()
);
        index = (index + 1) % partners.size();
    }
}
}

 /*   private DeliveryPartner findAvailablePartner() {
        for (DeliveryPartner p : partners) {
            if (p.isAvailable()) return p;
        }
        return null;
    }
}*/