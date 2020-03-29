package dronesimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Simulation {
	//Delivery schemes
	private FIFO fifo;
	
	//Probabilities
	private MealProbability[] mealProbs;
	private int[] ordersPerHour;
	
	//List of all delivery points
	private DeliveryPoint[] points;
		
	private Random rand;
	
	public Simulation(DeliveryPoint[] points, MealProbability[] mealProbs, int[] ordersPerHour) {
		fifo = new FIFO();
		
		this.points = points;
		this.mealProbs = mealProbs;
		this.ordersPerHour = ordersPerHour;
	}
	
	public void run() {
		simulate(fifo);
	}
	
	public void simulate(DeliveryScheme scheme) {
		//Run 50 simulations
		for(int simCount = 1; simCount <= 50; simCount++) {
			//4 hours = 240 minutes
			for(int minute = 0; minute < 240; minute++) {
				//Check if order is generated
				if(rand.nextDouble() < ordersPerHour[minute / 60] / 60.0) {
					//Generate random meal
					double mealNum = rand.nextDouble();
					double probSum = mealProbs[0].getProbability();
					int mealIndex = 0;
					
					while(mealNum > probSum && probSum < 1) {
						mealIndex++;
						probSum += mealProbs[mealIndex].getProbability();
					}
					
					//Generate random point
					DeliveryPoint point = points[rand.nextInt(points.length)];
					
					//Give order to delivery scheme
					Order order = new Order(mealProbs[mealIndex].getMeal(), point);
					
					scheme.addOrder(order);
				}
			}
		}
	}
}
