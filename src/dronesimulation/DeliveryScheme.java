package dronesimulation;

import java.util.Queue;

public interface DeliveryScheme {
	//Fills drone with meals until it gets too close to weight capacity
	public double fillDrone(final Drone drone);
	
	public void addOrder(Order order);

	public boolean isEmpty();
}
