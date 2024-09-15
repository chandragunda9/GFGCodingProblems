package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    public static int maxMeetings(int n, int start[], int end[]) {
        int[][] meeting = new int[n][3];
        for (int i = 0; i < meeting.length; i++) {
            meeting[i][0] = start[i];
            meeting[i][1] = end[i];
            meeting[i][2] = i;
        }
        List<Integer> seq = new ArrayList<>();
        Arrays.sort(meeting, Comparator.comparingInt(a -> a[1]));
        int count = 1, lastEndTime = meeting[0][1];
        seq.add(meeting[0][2]);
        for (int i = 1; i < n; i++) {
            int startTime = meeting[i][0];
            int endTime = meeting[i][1];
            int ind = meeting[i][2];
            if (startTime > lastEndTime) {
                count++;
                seq.add(ind);
                lastEndTime = endTime;
            }
        }
        System.out.println(seq);
        return count;
    }

    public static void main(String[] args) {
//        int[] start = {1, 4, 6, 9};
//        int[] end = {2, 5, 7, 12};
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start.length, start, end));
    }
}
