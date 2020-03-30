package dronesimulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIFO implements DeliveryScheme {
	Queue<Order> orders;
	
	public FIFO() {
		orders = new LinkedList<>();
	}
	
	@Override
<<<<<<< HEAD
<<<<<<< HEAD
	public double fillDrone(final Drone drone) {
		if(orders.size() == 0) return 0;

		int weight = 0;
		List<Order> deliveries = new LinkedList<>();
=======
	public List<DeliveryPoint> fillDrone(final double weightCap) {
		int weight = 0;
		List<DeliveryPoint> deliveries = new LinkedList<>();
>>>>>>> continued working in Simulation
=======
	public List<DeliveryPoint> fillDrone(final double weightCap) {
		int weight = 0;
		List<DeliveryPoint> deliveries = new LinkedList<>();
=======
	public double fillDrone(final Drone drone) {
		if(orders.size() == 0) return 0;

		int weight = 0;
		List<Order> deliveries = new LinkedList<>();
>>>>>>> Simulation now runs without errors. Needs more testing.
>>>>>>> Simulation now runs without errors. Needs more testing.
		
		//Add orders until next order would make drone too heavy
		while(orders.peek() != null && weight + orders.peek().getMealWeight() < drone.getCargoWeight()) {
			Order order = orders.poll();
			
			deliveries.add(order.getPoint());
			
			weight += order.getMealWeight();
		}
		//Make sure that the orders can be delivered
		double flightTime = drone.getFlightTime(deliveries);
		while(flightTime > drone.getMaxFlightTime()) {
			// Remove a point and see if the flight is now feasible
			deliveries.remove(deliveries.size() - 1);
			flightTime = drone.getFlightTime(deliveries);
		}

		return flightTime;
	}
	
	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public boolean isEmpty() { return orders.isEmpty(); }
}
