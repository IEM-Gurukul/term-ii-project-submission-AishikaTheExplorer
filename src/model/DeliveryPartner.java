package model;

public class DeliveryPartner {
    private int id;
    private String name;
    private double distance;
    private boolean available = true;

    public DeliveryPartner(int id, String name, double distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
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

    public int getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public void setAvailable(boolean available) {
    this.available = available;
}


}