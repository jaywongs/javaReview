package test;

/**
 * Created by jaywangs on 2019/3/16
 */
public class QuickSort {
//    private static int[] nums = {1,4,5,3,2,7,1,4,55,75,346,3,344,3333};
    public static void qSort(int[] nums, int head, int tail) {
        if (nums == null || nums.length == 0) return;
        sort(nums, head, tail);
    }

    private static void sort(int[] nums, int l, int h) {
        if (l >= h) return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l+1, j = h;
        int pivot = nums[l];
        while (true) {
            while (nums[i] < pivot && i < h) i++;
            while (nums[j] > pivot && j > l) j--;
            if (i >= j) break;
            swap(nums, i++, j--);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5,3,2,7,1,4,55,75,346,3,344,3333};
        qSort(nums, 0, nums.length - 1);
        String out = "";
        for (int digit : nums) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
