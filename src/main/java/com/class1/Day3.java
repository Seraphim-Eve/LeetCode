package com.class1;

public class Day3 {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        int times = 1;
        for (int i = 0; i < times; i++) {
            int[] arr = randomArray2(maxSize, maxValue);
            /*Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            int nearLeft = findNearRight(arr, value);
            if (nearLeft == -1) {
                print(arr);
                System.out.println("num: " + value);
            } else {
                print(arr);
                System.out.println("num: " + value + ", index: " + nearLeft);
            }*/
            System.out.println("测试开始");
            int minIndex = findMinIndex(arr);
            print(arr);
            System.out.println(minIndex);
            System.out.println("测试结束");
        }
    }

    /**
     * 从有序的数组arr中，找到 >= num 最左的位置（index）
     * [1, 2, 2, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9]
     * num = 2, 最左位置的index = 1
     *
     * @param arr 有序数组
     * @param num 需要查找的num
     * @return -1：未找到
     */
    public static int findNearLeft(int[] arr, int num) {
        int ans = -1;
        if (arr == null || arr.length == 0) {
            return ans;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    /**
     * 从有序的数组arr中，找到 <= num 最右的位置（index）
     * [1, 2, 2, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9]
     * num = 2, 最右位置的index = 3
     *
     * @param arr 有序数组
     * @param num 需要查找的num
     * @return -1：未找到
     */
    public static int findNearRight(int[] arr, int num) {
        int ans = -1;
        if (arr == null || arr.length == 0) {
            return ans;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static int[] randomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    //生成array，并且左右两边的数不能相同
    public static int[] randomArray2(int maxSize, int maxValue) {
        int len = (int) (Math.random() * maxSize);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * 从一个无需数组中查找局部最小值的index
     *
     * @param arr
     * @return
     */
    public static int findMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return 0;
        }

        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid + 1] > mid) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return arr[l] < arr[r] ? l : r;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
