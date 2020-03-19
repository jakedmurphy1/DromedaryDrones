package test;

import dronesimulation.DeliveryPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

import static dronesimulation.TravellingSalesman.travellingSalesman;

class TravellingSalesmanTest {
    @Test
    public void testTravellingSalesman() throws Exception {
        HashSet<DeliveryPoint> points = new HashSet<DeliveryPoint>();
        points.add(new DeliveryPoint(0, 1));
        points.add(new DeliveryPoint(1, 1));
        points.add(new DeliveryPoint(2, 1));
        points.add(new DeliveryPoint(1, 0));
        points.add(new DeliveryPoint(2, 0));
        DeliveryPoint[] orderedPoints = travellingSalesman(points);
        Assertions.assertEquals(6, getCost(orderedPoints));
    }

    private double getCost(DeliveryPoint[] deliveryPoints) {
        double cost = 0;
        for(int i = 0; i < deliveryPoints.length - 1; i++) {
            cost += deliveryPoints[i].getDistTo(deliveryPoints[i + 1]);
        }
        return cost;
    }
}