package dronesimulation;

import javax.crypto.spec.DESedeKeySpec;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static dronesimulation.TravellingSalesman.travellingSalesman;

public class Drone {
    private int cargoWeight;    // in ozs
    private double speed;          // in meters per minute
    private double maxFlightTime;  // in minutes
    private double turnAroundTime; // in minutes, time between flights
    private double deliveryTime;   // in minutes, time unloading order

    // Default constructor uses the values
    // for the drone we plan to use
    public Drone() {
        cargoWeight = 12 * 16;
        speed = 536.448;
        maxFlightTime = 20;
        turnAroundTime = 3;
        deliveryTime = 0.5;
    }

    public Drone(int cargoWeight, double speed, double maxFlightTime,
                 double turnAroundTime, double deliveryTime) {
        this.cargoWeight = cargoWeight;
        this.speed = speed;
        this.maxFlightTime = maxFlightTime;
        this.turnAroundTime = turnAroundTime;
        this.deliveryTime = deliveryTime;
    }

    // Returns the time (minutes) required to deliver to all points in the list.
    public double getFlightTime(List<Order> deliveries) {
        DeliveryPoint[] orderedPoints = travellingSalesman(
                deliveries.stream()
                .map(order -> order.getDeliveryPoint())
                .collect(Collectors.toCollection(HashSet::new)));
        double totalTime = 0.0; // in mins
        double flightTime = 0.0;
        double currentFlightTime;   // time to next point
        for(int i = 0; i < orderedPoints.length - 1; i++) {
            currentFlightTime = orderedPoints[i].getDistTo(orderedPoints[i+1]) / this.speed;
            totalTime += currentFlightTime + deliveryTime;
            flightTime += currentFlightTime;
        }
        return totalTime;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }
    public double getMaxFlightTime() { return maxFlightTime; }
    public double getTurnAroundTime() { return turnAroundTime; }
}