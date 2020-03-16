package dronesimulation;

import java.util.HashSet;

public class TravellingSalesman {
    public static DeliveryPoint[] travellingSalesman(HashSet<DeliveryPoint> points) {
        DeliveryPoint[] deliveryPoints = points.toArray(new DeliveryPoint[points.size()]);
        return deliveryPoints;
    }
}
