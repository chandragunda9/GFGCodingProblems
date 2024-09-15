package sliding_window;

public class MaximumPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, maxScore = 0, rightIndex = cardPoints.length - 1;
        int i = 0;
        while (i < k) {
            lsum += cardPoints[i];
            i++;
        }
        maxScore = Math.max(maxScore, lsum);
        for (int j = k - 1; j >= 0; j--) {
            lsum -= cardPoints[j];
            rsum += cardPoints[rightIndex];
            rightIndex--;
            maxScore = Math.max(maxScore, lsum + rsum);
        }
        return maxScore;
    }
}
