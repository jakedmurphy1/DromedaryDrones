package dronesimulation;

import java.util.HashSet;

public class TravellingSalesman {
    private static class TSPAnswer {
        double cost;
        int[] order;

        public TSPAnswer(int numPoints, double cost) {
            this.cost = cost;
            order = new int[numPoints];
        }
    }

    // points is a set of delivery points that the drone should visit.
    // The function returns an array of delivery points in an order that minimizes
    // travel distance. The array includes the home point at the beginning and end.
    public static DeliveryPoint[] travellingSalesman(HashSet<DeliveryPoint> points) {
        int numPoints = points.size() + 1;
        DeliveryPoint[] deliveryPointsFromSet = points.toArray(new DeliveryPoint[0]);
        DeliveryPoint[] deliveryPoints = new DeliveryPoint[numPoints];  // make array with room for home point
        double[][] distMatrix = new double[numPoints][numPoints];

        // Initialize deliveryPoints
        deliveryPoints[0] = new DeliveryPoint(0.0, 0.0);    // the home coordinate TODO: should read from map class
        // copy the rest of the set into the array
        System.arraycopy(deliveryPointsFromSet, 0, deliveryPoints, 1, numPoints - 1);

        // Initialize the distance matrix
        for(int row = 0; row < numPoints; row++) {
            for(int col = row + 1; col < numPoints; col++) {
                if(row == col) {
                    distMatrix[row][col] = 0;
                } else {
                    distMatrix[row][col] = deliveryPoints[row].getDistTo(deliveryPoints[col]);
                    distMatrix[col][row] = distMatrix[row][col];
                }
            }
        }

        // call tspRecursive with the correct parameters
        boolean[] visited = new boolean[numPoints];
        visited[0] = true;  // start at the first point
        TSPAnswer currentAns = new TSPAnswer(numPoints, 0.0);
        TSPAnswer bestAns = new TSPAnswer(numPoints, Double.MAX_VALUE);
        bestAns = tspRecursive(distMatrix, visited, 0, numPoints, 1,
                currentAns, bestAns);

        // use order to rearrange deliveryPoints
        DeliveryPoint[] retVal = new DeliveryPoint[numPoints + 1];
        for(int i = 0; i < numPoints; i++) {
            retVal[i] = deliveryPoints[bestAns.order[i]];
        }
        retVal[numPoints] = deliveryPoints[0];
        return retVal;
    }

    // Recursive function that traverses the tree
    private static TSPAnswer tspRecursive(double[][] distMatrix, boolean[] visited, int currPos, int numPoints,
                                          int count, TSPAnswer currentAns, TSPAnswer bestAns) {
        // Found a better path
        if((count == numPoints) && (distMatrix[currPos][0] > 0)
                && (bestAns.cost > (currentAns.cost + distMatrix[currPos][0]))) {
            bestAns.order = currentAns.order.clone();
            bestAns.cost = currentAns.cost + distMatrix[currPos][0];
            return bestAns;
        }

        // Backtracking
        for(int i = 0; i < numPoints; i++) {
            if(!visited[i] && (distMatrix[currPos][i] > 0)) {
                visited[i] = true;
                currentAns.order[count] = i;
                currentAns.cost += distMatrix[currPos][i];

                // Pruning: only recurse if cost is still lower than the best
                if(!(bestAns.cost < currentAns.cost))
                    bestAns = tspRecursive(distMatrix, visited, i, numPoints, count + 1, currentAns, bestAns);

                currentAns.cost -= distMatrix[currPos][i];
                visited[i] = false;
            }
        }
        return bestAns;
    }
}
