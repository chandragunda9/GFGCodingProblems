package greedy;

public class JumpGame1 {
    static int canReach(int[] A, int N) {
        if (N == 1)
            return 1;
        if (A[0] == 0)
            return 0;
        int maxInd = 0;
        for (int i = 0; i < N; i++) {
            if (i > maxInd)
                return 0;
            maxInd = Math.max(maxInd, i + A[i]);
            if (maxInd >= N - 1)
                return 1;
        }
        return 1;
    }
}
