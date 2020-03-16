package dronesimulation;

import java.util.HashSet;

public class TravellingSalesman {
    public static DeliveryPoint[] travellingSalesman(HashSet<DeliveryPoint> points) {
        // TODO: complete this algorithm
        DeliveryPoint[] deliveryPoints = points.toArray(new DeliveryPoint[points.size()]);
        int numPoints = points.size();
        double distMatrix[][] = new double[numPoints][numPoints];

        // Populate the distance matrix
        for(int row = 0; row < numPoints; row++) {
            for(int col = row + 1; col < numPoints; col++) {
                if(row == col) {
                    distMatrix[row][col] = 0;
                } else {
                    distMatrix[row][col] = deliveryPoints[row].getDistTo(deliveryPoints[col]);
                    distMatrix[col][row] = distMatrix[col][row];
                }
            }
        }

        // call tspRecursive with the correct parameters
        boolean[] visited = new boolean[numPoints];
        visited[0] = true;
        double ans = Double.MAX_VALUE;

        ans = tspRecursive(distMatrix, visited, 0, numPoints, 1, 0, ans);

        return deliveryPoints;
    }

    // Recursive function that traverses the tree
    public static double tspRecursive(double[][] distMatrix, boolean[] visited,
                                    int currPos, int numPoints, int count, double cost, double ans) {
        if(count == numPoints && distMatrix[currPos][0] > 0) {
            ans = Math.min(ans, cost + distMatrix[currPos][0]);
            return ans;
        }

        for(int i = 0; i < numPoints; i++) {
            if(visited[i] == false && distMatrix[currPos][i] > 0) {
                visited[i] = true;
                ans = tspRecursive(distMatrix, visited, i, numPoints, count + 1, cost + distMatrix[currPos][i], ans);
                visited[i] = false;
            }
        }
        return ans;
    }
}
