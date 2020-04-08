package dronesimulation;

import java.io.*;
import java.util.List;
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

	private Random rand;

	//A temporary CSV file containing output
	private File tempOutputFile;
	private BufferedWriter writer;
	
	public Simulation(CampusMap map, MealProbability[] mealProbs, int[] ordersPerHour) {
		fifo = new FIFO();
		drone = new Drone();
		rand = new Random();
		try {
			tempOutputFile = File.createTempFile("droneSim", ".csv");
			writer = new BufferedWriter(new FileWriter(tempOutputFile));
		} catch (IOException e) {
			// TODO: proper error handling
			e.printStackTrace();
		}
		
		this.points = map.getPoints();
		this.mealProbs = mealProbs;
		this.ordersPerHour = ordersPerHour;
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
					Order order = new Order(mealProbs[mealIndex].getMeal(), point, minute);

					scheme.addOrder(order);
				}
				// Pack the drone if available
				if (nextAvailableMinute <= minute && !scheme.isEmpty()) {
					deliveryTime = scheme.fillDrone(drone);
					totalDeliveries++;
					totalDeliveryTime += deliveryTime;
				    nextAvailableMinute += Math.ceil(deliveryTime + drone.getTurnAroundTime());
				}
				minute++;
			} //minute loop

			// All of the orders from the current simulation
			List<Order> deliveredOrders = scheme.getDeliveredOrders();

			// Output to CSV file
			try {
				for (Order deliveredOrder : deliveredOrders) {
					// TODO: add initial order timestamp as well as
					// the time it was delivered, the place it was delivered to, etc.
					writer.write(simCount + "," + deliveredOrder.getMealWeight());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} //simulation loop
	}

	// Intended to be used after the simulation
	// has been run and a file has been chosen
	// via .showSaveDialog in the GUI
	public void saveCSV(File fileToSave) {
		try {
			// Copy the contents of tempOutputFile to fileToSave
			FileReader fr = new FileReader(tempOutputFile);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(fileToSave);
			String currentLine = br.readLine();

			while(currentLine != null) {
				fw.write(currentLine);
				currentLine = br.readLine();
			}
			fw.flush();
			fw.close();
			br.close();
		} catch(IOException e) {
			// TODO: proper error handling
            e.printStackTrace();
		}
	}
}
