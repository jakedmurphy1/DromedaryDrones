package dronesimulation;

import java.util.List;
import java.util.Queue;

public interface DeliveryScheme {
	//Fills drone with meals until it gets too close to weight capacity
<<<<<<< HEAD
<<<<<<< HEAD
	public double fillDrone(final Drone drone);
=======
	public List<DeliveryPoint> fillDrone(double weightCap);
>>>>>>> continued working in Simulation
=======
	public List<DeliveryPoint> fillDrone(double weightCap);
=======
	public double fillDrone(final Drone drone);
>>>>>>> Simulation now runs without errors. Needs more testing.
>>>>>>> Simulation now runs without errors. Needs more testing.
	
	public void addOrder(Order order);

	public boolean isEmpty();
}
