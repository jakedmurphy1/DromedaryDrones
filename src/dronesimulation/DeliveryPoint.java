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

}
