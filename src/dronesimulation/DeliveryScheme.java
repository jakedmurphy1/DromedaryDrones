package dronesimulation;

import java.util.Queue;

public interface DeliveryScheme {
	//Fills drone with meals until it gets too close to weight capacity
	public Queue<Order> fillDrone(int weightCap);
	
	public void addOrder(Order order);
}
