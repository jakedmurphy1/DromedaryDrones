package dronesimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public interface DeliveryScheme {
	//Fills drone with meals until it gets too close to weight capacity
	public double fillDrone(final Drone drone, int currentMinute);

	public void addOrder(Order order);

	public boolean isEmpty();

	public List<Order> getDeliveredOrders();

	public void clearDeliveredOrders();
}
