package dronesimulation;

import java.util.HashMap;
import java.util.HashSet;

public class CampusMap {
	
	private HashMap<String, DeliveryPoint> campus;
	private DeliveryPoint dispatchPoint;
	
	public CampusMap(String college) {
		
		campus = new HashMap<String, DeliveryPoint>();
		
		if(college.equals("Grove City College")) {
			// TODO: use this in TSP during sprint 2
		    dispatchPoint = new DeliveryPoint(0, 0);
			//campus.put("SAC", new DeliveryPoint(0,0));
			campus.put("HAL", new DeliveryPoint(0,15));
			campus.put("Hoyt", new DeliveryPoint(152, -91));
			campus.put("Library", new DeliveryPoint(183, -61));
			campus.put("PLC", new DeliveryPoint(-61, -61));
			campus.put("STEM", new DeliveryPoint(0, -91));
			campus.put("Rockwell", new DeliveryPoint(0, -106));
			campus.put("Ketler", new DeliveryPoint(152, -183));
			campus.put("Lincoln", new DeliveryPoint(152, -91));
			campus.put("Hopeman", new DeliveryPoint(183, -121));
			campus.put("Memorial", new DeliveryPoint(183, -274));
			campus.put("Hicks", new DeliveryPoint(198, 61));
			campus.put("Crawford", new DeliveryPoint(167, -274));
			campus.put("MAP", new DeliveryPoint(-76, -183));
			campus.put("MEP", new DeliveryPoint(-76, -137));
			campus.put("Harker", new DeliveryPoint(-61, -240));
			campus.put("Zerbe", new DeliveryPoint(198, -243));
			campus.put("Apartments", new DeliveryPoint(198, -883));
			campus.put("Football Field", new DeliveryPoint(198, -822));
			campus.put("Tennis Courts", new DeliveryPoint(183, -792));
			campus.put("PEW", new DeliveryPoint(198, 91));
			campus.put("Harbison", new DeliveryPoint(76, -213));
			campus.put("Alumni", new DeliveryPoint(198, -914));
		}
	}

	public DeliveryPoint[] getPoints() {
		DeliveryPoint[] points = new DeliveryPoint[campus.values().size()];
		int i = 0;
		for(DeliveryPoint a : campus.values()) {
			points[i] = a;
			i++;
		}
		return points;
	}

	public void printCampusPoints() {
		for(String key: campus.keySet()) {
			System.out.println("Building: " + key + " points: (" + 
					campus.get(key).getX() + ", " + campus.get(key).getY() + ")");
		}
	}

}
