package com.class2;

import java.util.Arrays;
import java.util.Random;

public class Day3 {

    public static void main(String[] args) {
        int[] nums = generateArray(5, 20);
        System.out.println(Arrays.toString(nums));
        //merge sort
        process(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void process(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        process(nums, left, mid);
        process(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }

        //the left array will go to the end
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }

        //the right array will go to the end
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }

        //copy sorted array back to the nums array
        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }

    public static int[] generateArray(int size, int maxValue) {
        int[] nums = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * maxValue) + 1;
        }
        return nums;
    }

    public static void mergeSort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        int mergeSize = 1;
        while (mergeSize < length) {
            int left = 0;
            while (left < length) {
                int mid = left + mergeSize - 1;
                if (mid >= length) {
                    break;
                }
                int right = Math.min(mid + mergeSize, length - 1);
                merge(nums, left, mid, right);
                left = right + 1;
            }
            if (mergeSize > length / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * small sum
     * @param nums the nums array need to be sorted
     * @return small sum
     */
    public static int smallSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process2(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums the nums array need to be sorted
     * @param left start index
     * @param right end index
     * @return sum
     */
    public static int process2(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return  process2(nums, left, mid)
                +
                process2(nums, mid + 1, right)
                +
                merge2(nums, left, mid, right);
    }

    public static int merge2(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += nums[p1] < nums[p2] ? (right - p2 + 1) * nums[p1] : 0;
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }

        //the left array will go to the end
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }

        //the right array will go to the end
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }

        //copy sorted array back to the nums array
        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }

        return res;
    }

    /**
     *
     * @param nums num array
     * @param left start index
     * @param right end index
     * @return the index range of the nums[right]
     */
    public static int[] netherlandsFlag(int[] nums, int left, int right) {
        if (left > right) {
            return new int[] {-1, -1};
        }
        if (left == right) {
            return new int[] {left, right};
        }

        //the area that nums[right] less than
        int less = left - 1;
        //the area that nums[right] greater than
        int more = right;
        int index = left;
        while (index < more) {
            if (nums[index] == nums[right]) {
                index++;
            } else if (nums[index] < nums[right]) {
                //less than
                swap(nums, index++, ++less);
            } else {
                //greater than
                swap(nums, index, --more);
            }
        }
        swap(nums, right, more);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] nums, int oldIndex, int newIndex) {
        int temp = nums[oldIndex];
        nums[oldIndex] = nums[newIndex];
        nums[newIndex] = temp;
    }


    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
    }

    public static void process3(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        process3(nums, left, mid - 1);
        process3(nums, mid + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        return -1;
    }
}
