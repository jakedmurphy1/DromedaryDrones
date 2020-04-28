package dronesimulation;

import java.lang.Math;

public class DeliveryPoint {
    private double x;
    private double y;

    public DeliveryPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistTo(DeliveryPoint dp) {
        return Math.sqrt(Math.pow(this.x - dp.x, 2) + Math.pow(this.y - dp.y, 2));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    
    public void setX(double x) {
    	this.x = x;
    }
    
    public void setY(double y) {
    	this.y = y;
    }

    // Adapted from https://www.geeksforgeeks.org/overriding-equals-method-in-java/
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof DeliveryPoint)) {
            return false;
        }

        DeliveryPoint dp = (DeliveryPoint) o;

        return (dp.x == this.x) && (dp.y == this.y);
    }

    // Adapted from https://www.codexpedia.com/java/java-set-and-hashset-with-custom-class/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x);
        result = prime * result + Double.hashCode(y);
        return result;
    }

}
