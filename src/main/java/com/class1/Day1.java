package com.class1;

/**
 * Sun Aug 27 17:44:20 CDT 2023
 */
public class Day1 {

    /**
     * 打印一个数的二进制（32位）
     *
     * @param num 数
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    /**
     * swap
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        /*int num = 4;
        //左移一位：num * 2， 左移两位：num * 4
        System.out.println(num << 1);
        //右移一位：num / 2，右移两位：num / 4
        //>> 拿符号位的数来补左侧
        System.out.println(num >> 1);
        //>>> 拿0来补左侧
        System.out.println(num >>> 1);
        print(num);*/

        //取反
        /*int a = 5;
        int d = -5;
        System.out.println(d);
        d = (~a + 1);
        System.out.println(d);

        System.out.println(f(2));*/

        long f = factorial(3);
        System.out.println(f);

        int[] arr = {3, 6, 1, 5, 8, 9, 3, 4, 1};
        print(arr);
        //selectionSoft(arr);
        //bubbleSort(arr);
        insertSort(arr);
        print(arr);
    }

    /**
     * num的阶层计算
     *
     * @param num
     * @return
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
     *
     * @param arr
     */
    public static void selectionSoft(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0 - N - 1
        //1 - N - 1
        //2 - N - 1
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * bubble sort
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index = arr.length;
        for (int i = index - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index = arr.length;
        for (int i = 1; i < index; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
