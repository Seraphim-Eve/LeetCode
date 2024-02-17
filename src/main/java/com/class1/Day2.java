package com.class1;

public class Day2 {
    public static void main(String[] args) {
        int times = 100000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            //Math.random() -> [0,1)
            //Math.random() * 8 -> [0, 8)
            if (Math.random() < 0.6) {
                count++;
            }
        }
        System.out.println((double) count / (double) times);

        //测试
        int maxSize = 50;
        int maxValue = 1000;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = randomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSoft(arr1);
            insertSort(arr2);
            if (!isSorted(arr1)) {
                System.out.println("选择排序错了");
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * random an array
     *
     * @param maxSize  max size
     * @param maxValue max value
     * @return array
     */
    public static int[] randomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * maxSize);
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * copy an array to new array
     *
     * @param arr array
     * @return new array
     */
    public static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * equal
     *
     * @param arr1 arr1
     * @param arr2 arr2
     * @return
     */
    public static boolean equal(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * array是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
