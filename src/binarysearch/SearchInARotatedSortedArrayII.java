package binarysearch;

import java.util.ArrayList;

public class SearchInARotatedSortedArrayII {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int low = 0, high = nums.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid).equals(k)) {
                return true;
            }
            if (nums.get(low).equals(nums.get(mid)) && nums.get(mid).equals(nums.get(high))) {
                low++;
                high--;
                continue;
            }
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) <= k && k < nums.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums.get(mid) < k && k <= nums.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
