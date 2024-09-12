package arrays;

import java.util.ArrayList;
import java.util.List;

public class CountReversePairs {
    public int countRevPairs(int N, int arr[]) {
        return mergeSort(0, arr.length - 1, arr);
    }

    void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    int countPairs(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int count = 0;
        while (left <= mid) {
            while (right <= high && arr[left] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
            left++;
        }
        return count;
    }

    int mergeSort(int l, int r, int[] arr) {
        if (l >= r)
            return 0;
        int count = 0;
        int mid = (l + r) / 2;
        count += mergeSort(l, mid, arr);
        count += mergeSort(mid + 1, r, arr);
        count += countPairs(arr, l, mid, r);
        merge(arr, l, mid, r);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        CountReversePairs obj = new CountReversePairs();
        System.out.println(obj.countRevPairs(arr.length, arr));
    }
}
