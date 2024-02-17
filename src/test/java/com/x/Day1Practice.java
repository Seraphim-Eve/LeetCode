package com.x;

public class Day1Practice {

    public static void main(String[] args) {
        //System.out.println(factorial(3));
        int[] arr = {3, 5, 2, 1, 6, 7, 4, 5, 3};
        print(arr);
        selectionSort(arr);
        print(arr);
    }

    /**
     * 阶层练习
     */
    public static long factorial(int num) {
        int res = 0;
        int cur = 1;
        for (int i = 1; i <= num; i++) {
            cur = cur * i;
            res += cur;
        }
        return res;
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //数组总index
        int index = arr.length;
        //最小数的index
        int minValueIndex;
        for (int i = 0; i < index; i++) {
            minValueIndex = i;
            for (int j = i + 1; j < index; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
