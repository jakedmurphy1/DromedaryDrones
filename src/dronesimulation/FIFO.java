package dronesimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIFO implements DeliveryScheme {
	LinkedList<Order> pendingOrders;
	
	LinkedList<Order> deliveredOrders;
	
	public FIFO() {
		pendingOrders = new LinkedList<>();
	}
	
	@Override
	public double fillDrone(final Drone drone) {
		if(pendingOrders.size() == 0) return 0;

		int weight = 0;
		List<Order> deliveries = new ArrayList<>();

		//Add orders until next order would make drone too heavy
		while(pendingOrders.getFirst() != null && weight + pendingOrders.getFirst().getMealWeight() < drone.getCargoWeight()) {
			Order order = pendingOrders.poll();
			
			deliveries.add(order);
			
			weight += order.getMealWeight();
		}
		//Make sure that the orders can be delivered
		double[] deliveryTimes = drone.getFlightTime(deliveries);
		while(deliveryTimes[deliveryTimes.length - 1] > drone.getMaxFlightTime()) {
			// Remove a point and see if the flight is now feasible
			Order removedOrder = deliveries.remove(deliveries.size() - 1);
			pendingOrders.addFirst(removedOrder);
			deliveryTimes = drone.getFlightTime(deliveries);
		}
		
		//Set delivery time for each order
		for(int orderNum = 0; orderNum < deliveryTimes.length - 1; orderNum++) {
			deliveries.get(orderNum).setTotalDeliveryTime(deliveryTimes[orderNum] - deliveries.get(orderNum).getOrderTime());
		}
		
		//Add orders delivered this time to list of all delivered orders for simulation
		deliveredOrders.addAll(deliveries);
		
		//Return total delivery time
		return deliveryTimes[deliveryTimes.length - 1];
	}
	
	@Override
	public void addOrder(Order order) {
		pendingOrders.add(order);
	}

	@Override
	public boolean isEmpty() { return pendingOrders.isEmpty(); }

	@Override
	public List<Order> getDeliveredOrders() {
		return deliveredOrders;
	}
}
