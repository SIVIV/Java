package Vehicles;

public class Truck extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;
    private static final double TRUCK_FUEL_FACTOR = 0.95;

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelQuantity(double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    protected void drive(double distance) {
        double fuelNeeded = super.getFuelConsumption() * distance;
        if (fuelNeeded > super.getFuelQuantity()) {
            throw new FuelQuantityException("Truck needs refueling");
        }
        double remainingFuel = super.getFuelQuantity() - fuelNeeded;
        super.setFuelQuantity(remainingFuel);
        System.out.printf("Truck travelled %.2f km%n", distance);
    }

    @Override
    protected void refuel(double litres) {
        super.setFuelQuantity(super.getFuelQuantity() + litres * TRUCK_FUEL_FACTOR);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }

}
