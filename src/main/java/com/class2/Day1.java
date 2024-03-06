package com.class2;

import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        int times = 500000;
        /*for (int i = 0; i < times; i++) {
            int[] nums = createArray(5, 30);
            System.out.println(Arrays.toString(nums));

            //insertSort(array);
            selectionSort(nums);
            System.out.println(Arrays.toString(nums));
        }*/

        int[] test = {1, 2, 3, 3, 3, 4, 4, 4};
        System.out.println(nearestIndex(test, 3));
    }

    /**
     * insert sort
     * @param nums the array
     */
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        //[18, 25, 15]
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1] ; j--) {
                swap(nums, j, j + 1);
            }
        }
    }

    /**
     * swap the num from array
     * @param arr array
     * @param i index name
     * @param j index name
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * swap2 when i != j(rarely use)
     * @param arr array
     * @param i index i
     * @param j index j
     */
    public static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * selection sort
     * @param nums array
     */
    public static void selectionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }
            swap(nums, i, minIndex);
        }
    }

    /**
     * default sort
     * @param nums array
     */
    public static void sort(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * create an array
     * @param maxSize the length of the array
     * @param maxValue the max value of the element that in the array
     * @return array
     */
    public static int[] createArray(int maxSize, int maxValue) {
        int len = (int) ((Math.random() * maxSize) + 1);
        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * maxValue);
        }
        return nums;
    }

    /**
     * find the nearest index of a num
     * @param nums nums the array need to sort before using it
     * @param num the num
     */
    public static int nearestIndex(int[] nums, int num) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
