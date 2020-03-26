package dronesimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Knapsack implements DeliveryScheme{
	
	private int weight;
	private ArrayList<Order> orders;
	
	public Knapsack(ArrayList<Order> order) {
		this.weight = 0;
		this.orders = order;
	}

	@Override
	public Queue<Order> fillDrone(int weightCap) {
		Queue<Order> deliveries = new LinkedList<>();
		sortOrders(orders);
		for(int i = 0; i < orders.size(); i++) {
			if(this.weight + orders.get(i).getMealWeight() <= weightCap) {
				deliveries.add(orders.remove(i));
			}
		}
		return deliveries;
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
	
	
	
	

}
