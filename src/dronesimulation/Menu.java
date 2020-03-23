package dronesimulation;

import java.util.ArrayList;

public class Menu {
	
	private ArrayList<Order> orderList;
	
	public Menu() {
		orderList = new ArrayList<Order>();
	}
	
	public void addOrder(Order a) {
		orderList.add(a);
	}
	
	public boolean validateProbability() {
		double totalProbability = 0;
		for(Order a : orderList) {
			if((a.getOrderProbability() > 1.0) || (a.getOrderProbability() < 0)) {
				return false;
			}
			else {
				totalProbability += a.getOrderProbability();
			}
		}
		if(totalProbability > 1.0) {
			return false;
		}
		return true;
	}
	
	public void printMenu() {
		for(Order a : orderList) {
			System.out.println("#burgers: " + a.getNumHamburgers());
			System.out.println("#fries: " + a.getNumFries());
			System.out.println("#drinks: " + a.getNumDrinks());
			System.out.println("Probability: " + a.getOrderProbability());
			System.out.println("Weight: " + a.getOrderWeight());
		}
		System.out.println("\n");
	}

}
