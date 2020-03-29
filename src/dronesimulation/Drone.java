package dronesimulation;

import java.util.HashSet;
import java.util.List;

import static dronesimulation.TravellingSalesman.travellingSalesman;

public class Drone {
    private double cargoWeight;    // in lbs
    private double speed;          // in miles per minute
    private double maxFlightTime;  // in minutes
    private double turnAroundTime; // in minutes, time between flights
    private double deliveryTime;   // in minutes, time unloading order

    // Default constructor uses the values
    // for the drone we plan to use
    public Drone() {
        cargoWeight = 12;
        speed = 20 / 60; // 20 mph
        maxFlightTime = 20;
        turnAroundTime = 3;
        deliveryTime = 30;
    }

    public Drone(double cargoWeight, double speed, double maxFlightTime,
                 double turnAroundTime, double deliveryTime) {
        this.cargoWeight = cargoWeight;
        this.speed = speed;
        this.maxFlightTime = maxFlightTime;
        this.turnAroundTime = turnAroundTime;
        this.deliveryTime = deliveryTime;
    }

    // Returns the time (minutes) required to deliver to all points in the list.
    public double getFlightTime(List<DeliveryPoint> points) {
        DeliveryPoint[] orderedPoints = travellingSalesman(new HashSet<DeliveryPoint>(points));
        double totalTime = 0.0; // in mins
        double flightTime = 0.0;
        double currentFlightTime;   // time to next point
        for(int i = 0; i < points.size(); i++) {
            currentFlightTime = points.get(i).getDistTo(points.get(i+1)) * this.speed;
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