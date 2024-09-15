package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequenceProblem {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] JobScheduling(Job arr[], int n) {
//        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));
        Arrays.sort(arr, Comparator.comparingInt((Job a) -> a.profit).reversed());
        int[] hash = new int[n + 1];
        Arrays.fill(hash, -1);
        int maxProfit = 0, count = 0;
        for (int i = 0; i < n; i++) {
            int deadline = arr[i].deadline;
            int id = arr[i].id;
            int profit = arr[i].profit;
            for (int j = deadline; j >= 1; j--) {
                if (hash[j] == -1) {
                    hash[j] = id;
                    count++;
                    maxProfit = maxProfit + profit;
                    break;
                }
            }
        }
        return new int[]{count, maxProfit};
    }
}
