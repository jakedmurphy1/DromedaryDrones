package dronesimulation;

public class MealProbability {
	private Meal meal;
	private double probability;
	
	public MealProbability(Meal meal, double probability) {
		this.meal = meal;
		this.probability = probability;
	}
	
	public Meal getMeal() {
		return meal;
	}
	
	public double getProbability() {
		return probability;
	}
}
