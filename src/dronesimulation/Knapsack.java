package dronesimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Knapsack implements DeliveryScheme{
	
	private int weight;
	private ArrayList<Order> orders;
	private ArrayList<Order> temp;
	private ArrayList<Order> deliveries;
	
	private ArrayList<Integer> toRemove = new ArrayList<Integer>();
	private ArrayList<Integer> toRemoveTemp = new ArrayList<Integer>();
	
	public Knapsack(ArrayList<Order> order) {
		this.weight = 0;
		this.orders = order;
		temp = new ArrayList<Order>();
		deliveries = new ArrayList<Order>();
	}

	@Override
	public double fillDrone(final Drone drone) {
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
			orders.remove(toRemove.get(i) - buffer);
			buffer++;
		}
		
		//Make sure that the orders can be delivered
		//double flightTime = drone.getFlightTime(deliveries);
		double flightTime = 0;
		// Calculate the flight time for all deliveries to be fulfilled
		for(int i = 0; i < drone.getFlightTime(deliveries).length; i++) {
			flightTime += drone.getFlightTime(deliveries)[i];
		}
		
		//If the flight time is too long, remove the last order and try again
		while(flightTime > drone.getMaxFlightTime()) {
			flightTime = 0;
			// Remove a point and see if the flight is now feasible
			Order order = deliveries.remove(deliveries.size() - 1);
			//Put the order back in the orders array so it is still delivered
			orders.add(order);
			for(int i = 0; i < drone.getFlightTime(deliveries).length; i++) {
				flightTime += drone.getFlightTime(deliveries)[i];
			}
		}

		return flightTime;
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
	
	
	
	

}
