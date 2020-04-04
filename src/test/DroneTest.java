package test;

import dronesimulation.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DroneTest {
    @Test
    public void testGetFlightTime() throws Exception {
        // Get a list of orders to deliver
        FoodItem burger = new FoodItem(6);
        FoodItem fries = new FoodItem(4);
        FoodItem drink = new FoodItem(14);
        // Meal
        HashMap<FoodItem, Integer> items1 = new HashMap<FoodItem, Integer>();
        items1.put(burger, 1);
        items1.put(fries, 1);
        items1.put(drink, 1);
        Meal meal1 = new Meal(items1);

        List<Order> deliveries = new ArrayList<>();
        deliveries.add(new Order(meal1, new DeliveryPoint(0, 50)));
        deliveries.add(new Order(meal1, new DeliveryPoint(0, -350)));
        deliveries.add(new Order(meal1, new DeliveryPoint(0, -350)));

        Drone drone = new Drone();
        double[] ans = drone.getFlightTime(deliveries);

        Assert.assertEquals(ans[ans.length - 1], 2.49129, 0.01);
        Assert.assertEquals(ans.length, 4);
    }
}
