package QuickSort;

import java.util.Arrays;

class Range {
    int start = 0, end = 0;
    Range(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Sort {
    public static void qSort(int[] arr) {

         if(arr.length <= 0)
             return;

         Range[] ranges = new Range[arr.length];
         int p = 0;
         ranges[p++] = new Range(0, arr.length - 1);

         while (p != 0) {
             Range r = ranges[--p];

             if (r.start >= r.end)
                 continue;
             int key = arr[r.start];
             int i = r.start;
             int j = r.end;

             while (i < j) {
                 while (i < j && arr[j] > key)
                     j--;
                 arr[i] = arr[j];
                 while (i < j && arr[i] <= key)
                     i++;
                 arr[j] = arr[i];
             }
             arr[i] = key;
             ranges[p++] = new Range(r.start, i - 1);
             ranges[p++] = new Range(i + 1, r.end);
         }
    }

    public static void main(String[] args) {
//        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int[] arr = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
