package Vehicles;

public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }


    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    protected void drive(double distance) {
        double fuelNeeded = super.getFuelConsumption() * distance;
        if (fuelNeeded > super.getFuelQuantity()) {
            throw new FuelQuantityException("Car needs refueling");
        }
        double remainingFuel = super.getFuelQuantity() - fuelNeeded;
        super.setFuelQuantity(remainingFuel);
        System.out.printf("Car travelled %.2f km%n", distance);
    }

    @Override
    protected void refuel(double litres) {
        super.setFuelQuantity(super.getFuelQuantity() + litres);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
