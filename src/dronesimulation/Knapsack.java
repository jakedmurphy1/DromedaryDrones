package dronesimulation;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Knapsack implements DeliveryScheme{
	
	private int weight;
	private ArrayList<Order> orders;
	private ArrayList<Order> temp;
	private ArrayList<Order> deliveries;
	private ArrayList<Order> delivered;
	private ArrayList<Integer> toRemove = new ArrayList<Integer>();
	private ArrayList<Integer> toRemoveTemp = new ArrayList<Integer>();
	
	public Knapsack() {
		this.weight = 0;
		this.orders = new ArrayList<>();
		temp = new ArrayList<Order>();
		deliveries = new ArrayList<Order>();
		delivered = new ArrayList<Order>();
	}

	@Override
	public double fillDrone(final Drone drone, int currentMinute) {
		if(orders.size() == 0) return 0;
		sortOrders(orders);
		System.out.println("finished sort");
		
		int startIndex = 0;

		while(startIndex < orders.size()) {
			weight = 0;
			temp = new ArrayList<Order>();
			//Add as much weight to the drone as possible
			for(int i = startIndex; i < orders.size(); i++) {
				if((weight + orders.get(i).getMealWeight()) <= drone.getCargoWeight()) {
					weight += orders.get(i).getMealWeight();
					Order toAdd = orders.get(i);
					toRemoveTemp.add(i);
					temp.add(toAdd);
				}
			}
			
			if(getWeight(temp) == drone.getCargoWeight()) {
				break;
			}
			
			else {
				if(startIndex == 0) {
					deliveries = (ArrayList<Order>) temp.clone();
					toRemove = (ArrayList<Integer>) toRemoveTemp.clone();
					temp.clear();
					toRemoveTemp.clear();
				}
				else if(startIndex > 0){
					if(getWeight(temp) > getWeight(deliveries)) {
						deliveries = temp;
						temp.clear();
						
						toRemove = (ArrayList<Integer>) toRemoveTemp.clone();
						toRemoveTemp.clear();
					}
				}
			}
			
			temp.clear();
			toRemoveTemp.clear();
			
			startIndex++;
			
		}
	
		
		/*
		 * Add all orders to the delivered list indicating they have been delivered
		 */
		delivered.addAll(deliveries);

		
		/*
		 * Calculate the total time it will take the drone to deliver all orders
		 * If the time is too long, take off the last order
		 */
		double[] times = drone.getFlightTime(deliveries, currentMinute);
		while(times[times.length - 1] > drone.getMaxFlightTime()) {
			Order order = deliveries.remove(deliveries.size() - 1);
			orders.add(order);
			times = drone.getFlightTime(deliveries, currentMinute);
		}
		
		int buffer = 0;
		
		for(int i = 0; i < toRemove.size(); i++) {
			
			toRemove.set(i, toRemove.get(i) - buffer);
			
			deliveries.remove(toRemove.get(i));
	
		}
		
		/*
		 * Get the time that each order was delivered
		 */
		for(int i = 0; i < times.length - 1; i++) {
			deliveries.get(i).setTotalDeliveryTime(times[i] - deliveries.get(i).getOrderTime());
		}
		
		
		// Total delivery time
		System.out.println("finished knapsack");
		
		//orders.clear();
		
		return times[times.length - 1];
	}

	@Override
	public void addOrder(Order order) {
		orders.add(order);
		
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

	@Override
	public boolean isEmpty() {
		if(orders.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public int getWeight(List<Order> list) {
		int weight = 0;
		for(Order a : list) {
			weight += a.getMealWeight();
		}
		return weight;
	}

	@Override
	public List<Order> getDeliveredOrders() {
		
		return delivered;
	}

	@Override
	public void clearDeliveredOrders() {
		delivered.clear();
	}
	
	
	
	

}
