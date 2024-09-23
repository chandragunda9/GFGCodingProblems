package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccurrences {
    ArrayList<Integer> find(int arr[], int n, int x) {
        int first = lowerBound(arr, n, x);
        if (first == n || arr[first] != x) {
            return new ArrayList<>(Arrays.asList(-1, -1));
        }
        int last = upperBound(arr, n, x);
        return new ArrayList<>(Arrays.asList(first, last - 1));
    }

    int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int upperBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
