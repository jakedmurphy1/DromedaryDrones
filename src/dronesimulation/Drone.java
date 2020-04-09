package dronesimulation;

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

    // For each order in deliveries, a time is returned
    // that represents how long it took to get to the person
    // who ordered the meal.
    // Another time at the end of the list is included
    // that indicates the total time it took to get
    // back home, so the return value is of length
    // deliveries.size() + 1
    public double[] getFlightTime(List<Order> deliveries, int currentMinute) {
        // The return value, + 1 to accommodate the time to get back
        // to the home point
        double[] deliveryTimes = new double[deliveries.size() + 1];

        // Get the answer to TSP
        // Has a length of deliveries + 2
        DeliveryPoint[] orderedPoints = travellingSalesman(
                deliveries.stream()
                .map(order -> order.getDeliveryPoint())
                .collect(Collectors.toCollection(HashSet::new)));

        // Calculate the time to each point
        double totalTime = 0.0; // in mins
        double timeToNextPoint;   // time to next point
        for(int i = 0; i < orderedPoints.length - 1; i++) {
            timeToNextPoint = orderedPoints[i].getDistTo(orderedPoints[i+1]) / this.speed;

            // If going back home, do not add in deliveryTime
            if(i == orderedPoints.length - 2) {
                totalTime += timeToNextPoint;

                // Set the extra index at the end to indicate
                // the total time it took to do all delivering
                deliveryTimes[deliveries.size()] = totalTime;
            }
            // Otherwise, add in deliveryTime and add the time
            // for each order
            else {
                totalTime += timeToNextPoint + deliveryTime;
                // Store the time it took to get to this point
                // in all the deliveries at this point
                for(int j = 0; j < deliveries.size(); j++) {
                    if(orderedPoints[i+1].equals(deliveries.get(j).getDeliveryPoint())) {
                        deliveryTimes[j] = totalTime + currentMinute;
                    }
                }
            }
        }
        return deliveryTimes;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }
    public double getMaxFlightTime() { return maxFlightTime; }
    public double getTurnAroundTime() { return turnAroundTime; }
}