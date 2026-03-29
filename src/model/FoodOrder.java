package model;

// Inheritance
public class FoodOrder extends Order {

    public FoodOrder(int id, String name, String address, double distance) {
        super(id, name, address, distance);
        this.priority = calculatePriority();
    }

    @Override
    public int calculatePriority() {
        return (int)(100 - distance);
    }
}