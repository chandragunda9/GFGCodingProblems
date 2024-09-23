package binary_search;

public class Floor {
    static int findFloor(long arr[], int n, long x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
