package dronesimulation;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
>>>>>>> continued working in Simulation
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
=======
>>>>>>> Simulation now runs without errors. Needs more testing.
>>>>>>> Simulation now runs without errors. Needs more testing.
import java.util.Random;

public class Simulation {
	//Delivery schemes
	private FIFO fifo;

	//Drone
	private Drone drone;
	
	//Probabilities
	private MealProbability[] mealProbs;
	private int[] ordersPerHour;
	
	//List of all delivery points
	private DeliveryPoint[] points;
<<<<<<< HEAD
<<<<<<< HEAD

	private Random rand;
	
	public Simulation(CampusMap map, MealProbability[] mealProbs, int[] ordersPerHour) {
=======
=======
>>>>>>> Simulation now runs without errors. Needs more testing.
	
	//Drone
	private Drone drone;
	private boolean droneIsReady;
	private int droneReadyTime; //time after drone leaves that it will be back and ready to deploy again
		
	private Random rand;
	
	public Simulation(DeliveryPoint[] points, MealProbability[] mealProbs, int[] ordersPerHour, Drone drone) {
<<<<<<< HEAD
>>>>>>> continued working in Simulation
=======
=======

	private Random rand;
	
	public Simulation(CampusMap map, MealProbability[] mealProbs, int[] ordersPerHour) {
>>>>>>> Simulation now runs without errors. Needs more testing.
>>>>>>> Simulation now runs without errors. Needs more testing.
		fifo = new FIFO();
		drone = new Drone();
		rand = new Random();
		
		this.points = map.getPoints();
		this.mealProbs = mealProbs;
		this.ordersPerHour = ordersPerHour;
		this.drone = drone;
		
		droneIsReady = true;
	}
	
	public void run() {
		simulate(fifo);
	}
	
	public void simulate(DeliveryScheme scheme) {
		//Run 50 simulations
		for(int simCount = 1; simCount <= 50; simCount++) {
			//Keep simulating until 4 hours and the scheme is empty
			//4 hours = 240 minutes
			int minute = 0, hour = 0;
			// The next minute the drone is available to deliver orders
			int nextAvailableMinute = 0;
			double deliveryTime;
			double totalDeliveryTime = 0;
			int totalDeliveries = 0;
			while(minute < 240 || !scheme.isEmpty()) {
				//Check if order is generated
				hour = minute / 60;
				if(hour > 3) hour = 3;
				if(rand.nextDouble() < ordersPerHour[hour] / 60.0) {
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
<<<<<<< HEAD
<<<<<<< HEAD
				// Pack the drone if available
				if (nextAvailableMinute <= minute) {
					deliveryTime = scheme.fillDrone(drone);
					totalDeliveries++;
					totalDeliveryTime += deliveryTime;
				    nextAvailableMinute += Math.ceil(deliveryTime + drone.getTurnAroundTime());
				}
				minute++;
			} //minute loop
			System.out.println("One round complete, avg: " + totalDeliveryTime/totalDeliveries);
			System.out.println("total deliveries: " + totalDeliveries);
			System.out.println("time spent delivering: " + totalDeliveryTime);
			System.out.println();
		} //simulation loop
=======
=======
>>>>>>> Simulation now runs without errors. Needs more testing.
				
				//Check if drone is ready to deploy
				if(!droneIsReady && minute == droneReadyTime) {
					droneIsReady = true;
				}
				
				if(droneIsReady) {
					//Fill drone and set when drone will be ready again
					droneReadyTime = minute + drone.getFlightTime(scheme.fillDrone(drone.getCargoWeight())) + drone.getTurnAroundTime();
					droneIsReady = false;
				}
			}
		}
<<<<<<< HEAD
>>>>>>> continued working in Simulation
=======
=======
				// Pack the drone if available
				if (nextAvailableMinute <= minute) {
					deliveryTime = scheme.fillDrone(drone);
					totalDeliveries++;
					totalDeliveryTime += deliveryTime;
				    nextAvailableMinute += deliveryTime + drone.getTurnAroundTime();
				}
				minute++;
			} //minute loop
			System.out.println("One round complete, avg: " + totalDeliveryTime/totalDeliveries);
			System.out.println("total deliveries: " + totalDeliveries);
			System.out.println("time spent delivering: " + totalDeliveryTime);
			System.out.println();
		} //simulation loop
>>>>>>> Simulation now runs without errors. Needs more testing.
>>>>>>> Simulation now runs without errors. Needs more testing.
	}
}
