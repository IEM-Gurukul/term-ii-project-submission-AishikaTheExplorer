package model;

public class DeliveryPartner {
    private int id;
    private String name;
    private boolean available = true;

    public DeliveryPartner(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignOrder() {
        available = false;
    }

    public void completeOrder() {
        available = true;
    }

    public String getName() {
        return name;
    }
}