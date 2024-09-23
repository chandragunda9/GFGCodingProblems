package binary_search;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimiseMaxDistanceToGasStations {
    public static double method1(int stations[], int k) {
        int n = stations.length;
        int[] howManyPlaced = new int[n - 1];
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSecLen = 0;
            int maxInd = -1;
            for (int i = 0; i < n - 1; i++) {
                int diff = stations[i + 1] - stations[i];
                double secLen = (double) diff / (howManyPlaced[i] + 1);
                if (secLen > maxSecLen) {
                    maxSecLen = secLen;
                    maxInd = i;
                }
            }
            howManyPlaced[maxInd]++;
        }
        double max = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = stations[i + 1] - stations[i];
            double secLen = (double) diff / (howManyPlaced[i] + 1);
            max = Math.max(max, secLen);
        }
        return max;
    }

    static class Pair {
        double secLen;
        int ind;

        public Pair(double secLen, int ind) {
            this.secLen = secLen;
            this.ind = ind;
        }
    }

    public static double method2(int stations[], int k) {
        int n = stations.length;
        int[] howManyPlaced = new int[n - 1];
        Queue<Pair> q = new PriorityQueue<>((o1, o2) -> Double.compare(o2.secLen, o1.secLen));
        for (int i = 0; i < n - 1; i++) {
            q.add(new Pair(stations[i + 1] - stations[i], i));
        }
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            Pair p = q.poll();
            double secLen = p.secLen;
            int ind = p.ind;
            howManyPlaced[ind]++;
            double newSecLen = (double) (stations[ind + 1] - stations[ind]) / (howManyPlaced[ind] + 1);
            q.add(new Pair(newSecLen, ind));
        }
        return q.peek().secLen;
    }

    public static int noOfGasStationsReq(int[] stations, double mid) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            int noOfStationsInBetween = (int) ((stations[i] - stations[i - 1]) / mid);
            if (noOfStationsInBetween * mid == stations[i] - stations[i - 1]) {
                noOfStationsInBetween--;
            }
            count += noOfStationsInBetween;
        }
        return count;
    }

    public static double findSmallestMaxDist(int stations[], int k) {
        int max = 0, n = stations.length;
        double mod = 1e-6;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, stations[i + 1] - stations[i]);
        }
        double low = 0, high = max;
        while (high - low >= mod) {
            double mid = (low + high) / 2;
            int req = noOfGasStationsReq(stations, mid);
            if (req > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
