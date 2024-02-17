package com.class1;

/**
 * 第8节 归并排序和快排排序
 */
public class Day8 {

    /**
     * 归并排序(递归版本)
     * 原理：
     * 数组：[41, 62, 30, 55, 85, 19, 48, 89, 44, 37]
     * 长度：10
     * 起始下标位置：0,
     * 中间下标位置：5,
     * 结束下标为止：9
     * 1. 对0~5的数进行切割，按照并记录起始，中间和结束下标。
     * 2. 对5+1~9的数进行切换，按照并记录起始，中间和结束下标。
     * 对1和2重复直接，一直持续到起始位置和结束位置相同，再开始merge
     */
    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);
    }

    public static void process(int[] arr, int start, int end) {
        //位置相同后，不在进行切割，并返回
        if (start == end) {
            return;
        }
        //数组中间位置
        int mid = start + ((end - start) >> 1);
        //无限切割数组
        process(arr, start, mid);
        process(arr, mid + 1, end);
        //不能切割后再进行merge
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        //记录临时数组下标位置
        int i = 0;
        //临时数组
        int[] help = new int[end - start + 1];
        //切割后的左边（起始下标）
        int p1 = start;
        //切割后的右边（起始下标）
        int p2 = mid + 1;
        //排序比数
        while (p1 <= mid && p2 <= end) {
            //开始比较左右两边数组中的数字大小
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //只会存在某一个数组下标越界，要么左边数组p1, 要么右边数组p2
        while (p1 <= mid) {
            //如果p1没有越界，把p1后续位置的数复制过来
            help[i++] = arr[p1++];
        }
        while (p2 <= end) {
            //如果p2没有越界，把p2后续位置的数复制过来
            help[i++] = arr[p2++];
        }
        //把临时排好序的数组复制到原来数组中
        System.arraycopy(help, 0, arr, start, help.length);
    }

    /**
     * 非递归排序
     * @param array
     */
    public static void mergeSort2(int[] array) {

    }


    public static void main(String[] args) {
        int[] array = new int[]{41, 62, 30, 55, 85, 19, 48, 89, 44, 37};
        mergeSort(array);;
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
