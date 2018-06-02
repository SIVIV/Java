package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] carInput = readInput(reader.readLine());
        Vehicle car = new Car(carInput[0], carInput[1]);

        double[] truckInput = readInput(reader.readLine());
        Vehicle truck = new Truck(truckInput[0], truckInput[1]);

        int nLines = Integer.parseInt(reader.readLine());

        while (nLines-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String type = input[1];
            double parameter = Double.parseDouble(input[2]);
            try {
                switch (command) {
                    case "Drive":
                        if ("Car".equalsIgnoreCase(type)) {
                            car.drive(parameter);
                        } else {
                            truck.drive(parameter);
                        }
                        break;
                    case "Refuel":
                        if ("Car".equalsIgnoreCase(type)) {
                            car.refuel(parameter);
                        } else {
                            truck.refuel(parameter);
                        }
                        break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }

    public static double[] readInput(String input) {
        return Arrays
                .stream(input.split("\\s+"))
                .skip(1L)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
