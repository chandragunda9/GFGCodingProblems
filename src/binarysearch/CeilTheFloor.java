package binarysearch;

public class CeilTheFloor {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int floorVal = Integer.MIN_VALUE, ceilVal = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x && arr[i] > floorVal) {
                floorVal = arr[i];
            }
            if (arr[i] >= x && arr[i] < ceilVal) {
                ceilVal = arr[i];
            }
        }
        if (floorVal == Integer.MIN_VALUE)
            floorVal = -1;
        if (ceilVal == Integer.MAX_VALUE)
            ceilVal = -1;
        return new int[]{floorVal, ceilVal};
    }
}
