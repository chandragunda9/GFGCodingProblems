package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
    static int minRemoval(int N, int Intervals[][]) {
        Arrays.sort(Intervals, (a, b) -> a[1] - b[1]);
        int count = 1, lastEndTime = Intervals[0][1];
        for (int i = 1; i < N; i++) {
            if (Intervals[i][0] >= lastEndTime) {
                count++;
                lastEndTime = Intervals[i][1];
            }
        }
        return N - count;
    }
}
