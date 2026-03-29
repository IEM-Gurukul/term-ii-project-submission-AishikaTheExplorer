package model;

public abstract class Order {
    protected int orderId;
    protected String customerName;
    protected String address;
    protected double distance;
    protected int priority;
    protected String status;

    public Order(int orderId, String customerName, String address, double distance) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
        this.distance = distance;
        this.status = "Pending";
    }

    public abstract int calculatePriority();

    public int getPriority() {
        return priority;
    }

    public int getOrderId() {
    return orderId;
}

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return orderId + " - " + customerName + " (" + status + ")";
    }
}