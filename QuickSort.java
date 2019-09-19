package QuickSort;

import java.util.Arrays;

public class QuickSort {
    /**
     * 对外接口
     * @param arr 待排序数组
     */
    public static void qSort(int[] arr) {
        Sort(arr, 0, arr.length - 1);
    }

    private static void Sort(int[] arr, int left, int right) {

        if(left >= right)
            return;

        int key = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            //不论元素序列为何，在遍历后i指向大于等于key值的元素，j指向小于等于key值的元素
            while (i < j && arr[j] >= key) { //试图从数组尾部开始寻找一个小于key值的元素
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] < key) { //试图从数组头部开始寻找一个大于等于key值的元素
                i++;
            }
            arr[j] = arr[i];
        }
        //每次扫描一轮，都能将一个key值放入数组中正确的位置
        arr[i] = key;

        Sort(arr, left, i - 1);
        Sort(arr, j + 1, right);
    }
    public static void main(String[] args) {
//        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int[] arr = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
