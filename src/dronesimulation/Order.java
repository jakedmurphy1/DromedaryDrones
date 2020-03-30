package dronesimulation;

public class Order {
	//location this order is going to
	private DeliveryPoint point;
	
	//Meal being delivered
	private Meal meal;
	
	public Order(Meal meal, DeliveryPoint point) {
		this.meal = meal;
		this.point = point;
	}
	
	public double getMealWeight() {
		return meal.getWeight();
	}
<<<<<<< HEAD
<<<<<<< HEAD
	public DeliveryPoint getDeliveryPoint() { return point; }
=======
=======
>>>>>>> Simulation now runs without errors. Needs more testing.
	
	public DeliveryPoint getPoint() {
		return point;
	}
<<<<<<< HEAD
>>>>>>> continued working in Simulation
=======
=======
	public DeliveryPoint getDeliveryPoint() { return point; }
>>>>>>> Simulation now runs without errors. Needs more testing.
>>>>>>> Simulation now runs without errors. Needs more testing.
}
