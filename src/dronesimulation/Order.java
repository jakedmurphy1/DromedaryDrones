package dronesimulation;

import java.util.ArrayList;

public class Order {
	
	private int numHamburgers;
	private int numFries;
	private int numDrinks;
	private double orderProbability;
	private int orderWeight;
	
	public Order(int numHamburgers, int numFries, int numDrinks, 
			double orderProbability, int orderWeight) {
		
		this.numHamburgers = numHamburgers;
		this.numFries = numFries;
		this.numDrinks = numDrinks;
		this.orderProbability = orderProbability;
		this.orderWeight = orderWeight;
		
	}

	public int getNumHamburgers() {
		return numHamburgers;
	}

	public int getNumFries() {
		return numFries;
	}

	public int getNumDrinks() {
		return numDrinks;
	}

	public double getOrderProbability() {
		return orderProbability;
	}

	public int getOrderWeight() {
		return orderWeight;
	}
	
	

}
