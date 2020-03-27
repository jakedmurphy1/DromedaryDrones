package dronesimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Simulation {
	//Delivery schemes
	private FIFO fifo;
	
	//Probabilities
	private HashMap<Meal, Double> mealProbs;
	private int[] ordersPerHour;
	
	//List of all delivery points
	private ArrayList<DeliveryPoint> points;
	
	private Random rand;
	
	public Simulation(ArrayList<DeliveryPoint> points, HashMap<Meal, Double> mealProbs, int[] ordersPerHour) {
		fifo = new FIFO();
		
		this.points = points;
		this.mealProbs = mealProbs;
		this.ordersPerHour = ordersPerHour;
	}
	
	public void run() {
		//Run FIFO
		for(int simCount = 1; simCount <= 50; simCount++) {
			//4 hours = 240 minutes
			for(int minute = 0; minute < 240; minute++) {
				//Check if order is generated
				if(rand.nextDouble() < ordersPerHour[minute / 60] / 60.0) {
					//Generate random order at random point
					double mealNum = rand.nextDouble();
					int probSum = 0;
					Meal meal;
					
					while(mealNum < probSum) {
						
					}
				}
			}
		}
	}
}
