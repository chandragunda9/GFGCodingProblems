package greedy;

public class Candy {
    static int minCandy(int N, int ratings[]) {
        int i = 1, sum = 1;
        while (i < N) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while (i < N && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while (i < N && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }
            if (down > peak) {
                sum = sum - (down - peak);
            }
        }
        return sum;
    }

    static int method2(int N, int ratings[]) {
        int[] l = new int[N], r = new int[N];
        l[0] = 1;
        r[N - 1] = 1;
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 0;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += Math.max(l[i], r[i]);
        }
        return count;
    }
}
