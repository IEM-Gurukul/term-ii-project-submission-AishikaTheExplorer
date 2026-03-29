package model;

public class GroceryOrder extends Order {

    public GroceryOrder(int id, String name, String address, double distance) {
        super(id, name, address, distance);
        this.priority = calculatePriority();
    }

    @Override
    public int calculatePriority() {
        return (int)(80 - distance);
    }
}