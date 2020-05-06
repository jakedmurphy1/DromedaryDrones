package dronesimulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
	//Delivery schemes
	private FIFO fifo;
	private Knapsack knapsack;
	int totalNumOrders;	// for all simulations
	double worstFIFOTime;
	double totalFIFOTime;
	double worstKnapsackTime;
	double totalKnapsackTime;

	private ArrayList<Order> orders;

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

	public Simulation(CampusMap map, MealProbability[] mealProbs, int[] ordersPerHour) {
		fifo = new FIFO();
		knapsack = new Knapsack();
		drone = new Drone();
		rand = new Random();

		worstFIFOTime = 0;
		totalFIFOTime = 0;
		totalNumOrders = 0;
		worstKnapsackTime = 0;
		totalKnapsackTime = 0;

		this.points = map.getPoints();
		this.mealProbs = mealProbs;
		this.ordersPerHour = ordersPerHour;
	}
	
	public void run() {
		try {
			List<Order> deliveredOrders;

			tempOutputFile = File.createTempFile("droneSim", ".csv");
			FileWriter writer = new FileWriter(tempOutputFile);
			for(int simCount = 1; simCount <= 50; simCount++) {
				//Generate the orders to be delivered this simulation
				orders = generateOrders();
				totalNumOrders += orders.size();

				// Get the results from each scheme
				
				
				deliveredOrders = simulate(knapsack);
				// Update worst time and total time
				for(Order o : deliveredOrders) {
					totalFIFOTime += o.getTotalDeliveryTime();
					if(o.getTotalDeliveryTime() > worstFIFOTime) {
						worstFIFOTime = o.getTotalDeliveryTime();
					}
				}
				// Output each order to CSV
				
				for (Order deliveredOrder : deliveredOrders) {
					// Add scheme label
					writer.append("FIFO,");
					
					writer.append(simCount + "," + deliveredOrder.getMealWeight() + "," + deliveredOrder.getOrderTime() + "," + deliveredOrder.getTotalDeliveryTime() + ",");
					writer.append(deliveredOrder.getDeliveryPoint().getX() + "," + deliveredOrder.getDeliveryPoint().getY() + "\n");
				}
				
				
				deliveredOrders = simulate(fifo);
				for(Order o : deliveredOrders) {
					totalKnapsackTime += o.getTotalDeliveryTime();
					if(o.getTotalDeliveryTime() > worstKnapsackTime) {
						worstKnapsackTime = o.getTotalDeliveryTime();
					}
				}
				// Output each order to CSV
				for (Order deliveredOrder : deliveredOrders) {
					// Add scheme label
					writer.append("Knapsack,");
					// the time it was delivered, the place it was delivered to, etc.
					writer.append(simCount + "," + deliveredOrder.getMealWeight() + "," + deliveredOrder.getOrderTime() + "," + deliveredOrder.getTotalDeliveryTime() + ",");
					writer.append(deliveredOrder.getDeliveryPoint().getX() + "," + deliveredOrder.getDeliveryPoint().getY() + "\n");
				}

				writer.flush();
				// clear the orders
				fifo.clearDeliveredOrders();
				knapsack.clearDeliveredOrders();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Returns the orders delivered during this simulation
	public List<Order> simulate(DeliveryScheme scheme) {
		// The current index in property orders
		int currentOrderIndex = 0;

		//Keep simulating until 4 hours and the scheme is empty
		//4 hours = 240 minutes
		int minute = 0, hour = 0;
		// The next minute the drone is available to deliver orders
		int nextAvailableMinute = 0;
		double deliveryTime;
		while(minute < 240) {
		//while(minute < 240 || !scheme.isEmpty()) {
			// Add the next order if it has arrived
			if(currentOrderIndex < orders.size() && orders.get(currentOrderIndex).getOrderTime() == minute) {
				scheme.addOrder(orders.get(currentOrderIndex));
				currentOrderIndex++;
			}
			// Pack the drone if available
			if (nextAvailableMinute <= minute && !scheme.isEmpty()) {
				deliveryTime = scheme.fillDrone(drone, minute);
				nextAvailableMinute += Math.ceil(deliveryTime + drone.getTurnAroundTime());
			}
			minute++;
		} //minute loop

		// All of the orders from the current simulation
		List<Order> deliveredOrders = scheme.getDeliveredOrders();
		return deliveredOrders;
	}

	private ArrayList<Order> generateOrders() {
		ArrayList<Order> randomOrders = new ArrayList<>();
		int hour;
		for (int minute = 0; minute < 240; minute++) {
			//Check if order is generated
			hour = minute / 60;
			if (rand.nextDouble() < ordersPerHour[hour] / 60.0) {
				//Generate random meal
				double mealNum = rand.nextDouble();
				double probSum = mealProbs[0].getProbability();
				int mealIndex = 0;

				while (mealNum > probSum && probSum < 1) {
					mealIndex++;
					probSum += mealProbs[mealIndex].getProbability();
				}

				//Generate random point
				DeliveryPoint point = points[rand.nextInt(points.length)];

				//Enter order into order array
				Order order = new Order(mealProbs[mealIndex].getMeal(), point, minute);
				randomOrders.add(order);
			}
		}
		return randomOrders;
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

			// Statistics
            double fifoAvg = totalFIFOTime / totalNumOrders;
            double knapsackAvg = totalKnapsackTime / totalNumOrders;
            fw.append("Delivery Scheme,Average,Worst\n");
            fw.append("FIFO," + fifoAvg + "," + worstFIFOTime + "\n");
            fw.append("Knapsack," + knapsackAvg + "," + worstKnapsackTime + "\n\n");

			// The rest of the output
			fw.append("Delivery Scheme,Simulation,Weight,Initial Time,Total Time,X,Y\n");
			while(currentLine != null) {
				fw.append(currentLine + "\n");
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
