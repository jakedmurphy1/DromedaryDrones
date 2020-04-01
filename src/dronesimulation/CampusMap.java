package dronesimulation;

import java.util.HashMap;
import java.util.HashSet;

public class CampusMap {
	
	private HashMap<String, DeliveryPoint> campus;
	
	public CampusMap(String college) {
		
		campus = new HashMap<String, DeliveryPoint>();
		
		if(college == "Grove City College") {
			campus.put("SAC", new DeliveryPoint(0,0));
			campus.put("HAL", new DeliveryPoint(0,50));
			campus.put("Hoyt", new DeliveryPoint(500, -300));
			campus.put("Library", new DeliveryPoint(600, -200));
			campus.put("PLC", new DeliveryPoint(-200, -200));
			campus.put("STEM", new DeliveryPoint(0, -300));
			campus.put("Rockwell", new DeliveryPoint(0, -350));
			campus.put("Ketler", new DeliveryPoint(500, -600));
			campus.put("Lincoln", new DeliveryPoint(500, -300));
			campus.put("Hopeman", new DeliveryPoint(600, -400));
			campus.put("Memorial", new DeliveryPoint(600, -900));
			campus.put("Hicks", new DeliveryPoint(650, 200));
			campus.put("Crawford", new DeliveryPoint(550, -900));
			campus.put("MAP", new DeliveryPoint(-250, -600));
			campus.put("MEP", new DeliveryPoint(-250, -450));
			campus.put("Harker", new DeliveryPoint(-200, -240));
			campus.put("Zerbe", new DeliveryPoint(650, -800));
			campus.put("Apartments", new DeliveryPoint(650, -2900));
			campus.put("Football Field", new DeliveryPoint(650, -2700));
			campus.put("Tennis Courts", new DeliveryPoint(600, -2600));
			campus.put("PEW", new DeliveryPoint(650, 300));
			campus.put("Harbison", new DeliveryPoint(250, -700));
			campus.put("Alumni", new DeliveryPoint(650, -3000));
		}
	}

	public DeliveryPoint[] getPoints() {
		return campus.values().toArray(DeliveryPoint[]::new);
	}

	public void printCampusPoints() {
		for(String key: campus.keySet()) {
			System.out.println("Building: " + key + " points: (" + 
					campus.get(key).getX() + ", " + campus.get(key).getY() + ")");
		}
	}

}
