package dronesimulation;

public class Order {
	//location this order is going to
	private DeliveryPoint point;
	
	//Meal being delivered
	private Meal meal;
	
	//minute order was placed
	private int orderTime;
	
	//time from ordering to delivery
	private double totalDeliveryTime;
	
	public Order(Meal meal, DeliveryPoint point, int time) {
		this.meal = meal;
		this.point = point;
		orderTime = time;
	}
	
	public double getMealWeight() {
		return meal.getWeight();
	}

	public DeliveryPoint getDeliveryPoint() { return point; }
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public void setTotalDeliveryTime(double time) {
		totalDeliveryTime = time;
	}
	
	public double getTotalDeliveryTime() { return totalDeliveryTime; }
}
