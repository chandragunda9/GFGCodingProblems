package binary_search;

public class SearchInsertPosition {
    static int searchInsertK(int Arr[], int N, int k) {
        int low = 0, high = N - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (Arr[mid] >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
