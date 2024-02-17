package com.x;

public class Day2Practice {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 30;
        int maxValue = 3000;
        int[] arr = randomArray(maxSize, maxValue);
        print(arr);
        //insertSort(arr);
        //selectionSort(arr);
        bubbleSort(arr);
        print(arr);
    }

    public static int[] randomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * maxSize);
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = (int) (Math.random() * maxValue);
        }
        return tmp;
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--)
                swap(arr, j, j + 1);
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < len; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
