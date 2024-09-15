package greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int totalTime = 0, totalWaitingTime = 0;
        for (int i = 0; i < bt.length; i++) {
            totalWaitingTime += totalTime;
            totalTime += bt[i];
        }
        return totalWaitingTime / bt.length;
    }
}
