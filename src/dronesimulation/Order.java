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
	
	public int getMealWeight() {
		return meal.getWeight();
	}
	public DeliveryPoint getDeliveryPoint() { return point; }
}
