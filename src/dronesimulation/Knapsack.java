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
		
		int startIndex = 0;
		while(startIndex < orders.size()) {
			weight = 0;
			temp = new ArrayList<Order>();
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
					deliveries = temp;
					toRemove = toRemoveTemp;
					temp.clear();
					toRemoveTemp.clear();
				}
				else if(startIndex > 0){
					if(getWeight(temp) > getWeight(deliveries)) {
						deliveries = temp;
						temp.clear();
						
						toRemove = toRemoveTemp;
						toRemoveTemp.clear();
					}
				}
			}
			
			temp.clear();
			toRemoveTemp.clear();
			
			startIndex++;
			
		}
		
		int buffer = 0;
		
		for(int i = 0; i < toRemove.size(); i++) {
			if(toRemove.get(i) - buffer > 0) {
				orders.remove(toRemove.get(i) - buffer);
			} else {
				orders.remove(toRemove.get(i));
			}
			
			buffer++;
		}
		
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
		
		/*
		 * Get the time that each order was delivered
		 */
		for(int i = 0; i < times.length - 1; i++) {
			deliveries.get(i).setTotalDeliveryTime(times[i] - deliveries.get(i).getOrderTime());
		}
		
		/*
		 * Add all orders to the delivered list indicating they have been delivered
		 */
		for(Order a : deliveries) {
			delivered.add(a);
		}
		
		// Total delivery time
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
		
		return deliveries;
	}

	@Override
	public void clearDeliveredOrders() {
		deliveries.clear();
	}
	
	
	
	

}
