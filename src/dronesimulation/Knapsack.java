package dronesimulation;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Knapsack implements DeliveryScheme{
	
	private ArrayList<Order> pending;	/* Arraylist of orders still to be delivered */
	private ArrayList<Order> delivered; /* Arraylist of orders that have been delivered */
	private ArrayList<Order> skipped;	/* Arraylist of orders that have been skipped */
	
	
	public Knapsack() {
		pending = new ArrayList<Order>();	/* Initialize pending */
		delivered = new ArrayList<Order>(); /* Initialize delivered */
		skipped = new ArrayList<Order>();	/* Initialize skipped */	
	}

	@Override
	public double fillDrone(Drone drone, int currentMinute) {
		
		/* If there are no orders waiting to be delivered */
		if(pending.size() == 0) {
			return 0;
		}
		
		/* Sort orders from heaviest to lightest */
		sortOrders(pending);
		
		int weight = 0; /* Total weight of delivery */
		
		ArrayList<Order> deliveries = new ArrayList<Order>(); /* Orders to be "packed" onto drone */
		
		/* Add orders that have previously been skipped first */
		while(!skipped.isEmpty()) {
			if(weight + skipped.get(0).getMealWeight() <= drone.getCargoWeight()) {
				 Order add = skipped.remove(0);
				 deliveries.add(add);
				 weight += add.getMealWeight();
			}
			else {
				break;
			}
		}
		
		/* Maximize weight of drone by adding as many orders as will fit */
		for(int i = 0; i < pending.size(); i++) {
			if(weight + pending.get(i).getMealWeight() <= drone.getCargoWeight()) {
				Order packed = pending.remove(i);
				deliveries.add(packed);
				weight += packed.getMealWeight();
			}
		}
		
		double[] times = drone.getFlightTime(deliveries, currentMinute);
		/* While the time it would take to deliver the orders is greater than max flight time, remove orders */
		while(times[times.length - 1] > drone.getMaxFlightTime()) {
			Order removed = deliveries.remove(deliveries.size() - 1);
			skipped.add(removed);
			times = drone.getFlightTime(deliveries, currentMinute);
		} /* End while */
		
		/* Set the delivery time for each order */
		for(int i = 0; i < times.length - 1; i++) {
			deliveries.get(i).setTotalDeliveryTime(times[i] - deliveries.get(i).getOrderTime());
		}
		
		delivered.addAll(deliveries);
		
		return times[times.length - 1];

	}

	@Override
	public void addOrder(Order order) {
		pending.add(order);
	}

	@Override
	public boolean isEmpty() {
		return pending.isEmpty();
	}

	@Override
	public List<Order> getDeliveredOrders() {
		return delivered;
	}

	@Override
	public void clearDeliveredOrders() {
		delivered.clear();
	}
	
	public void sortOrders(ArrayList<Order> a) {
		for(int i = 0; i < a.size()-1; i++) {
			if(a.get(i).getMealWeight() < a.get(i+1).getMealWeight()) {
				Order temp = a.get(i);
				a.set(i, a.get(i+1));
				a.set(i+1, temp);
			}
		}
	}
	
	
	

}
