package com.wzj.destination.sort;

import java.util.Arrays;

/**
 * Created by WZJ on 2018/4/11.
 */

public class MergingSorting {

    /*
    * 归并排序
    * 思想：归并排序采用了分治算法，首先递归将原始数组划分为若干子数组，
    *      对每个子数组进行排序。然后将排好序的子数组递归合并成一个有序的数组。
    * 时间复杂度：均为O(nlogn)
    * 空间复杂度：O(n)  (n + logn(递归时压入栈的数据所占用空间))
    * 稳定性：稳定
    *
    * */

    public static void mergeSort(int[] array){
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right){
        int mid = (left + right) >> 1;
        if(left < right){ //结束时，right = left + 1,即子数组中含有两个元素，两个元素进行merge
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int low, int mid, int high){
        int[] temp = new int[array.length];  //临时数组

        int left = low;  //第一个子数组开始的索引
        int right = mid + 1;  //第二个子数组开始的索引
        int tempIndex = low;

        while (left <= mid && right <= high){  //比较两个子数组最前面的两个元素，选择小的加入到临时数组中，并在相应数组中跳过该元素（索引++）
            if (array[left] < array[right]){   //若某一个子数组元素全部比较完，则结束该循坏
                temp[tempIndex++] = array[left++]; //将另一个数组中的剩余元素加入到临时数组中
            }else {
                temp[tempIndex++] = array[right++];
            }
        }
        //处理剩余未合并的部分
        while (left <= mid)
            temp[tempIndex++] = array[left++];

        while (right <= high)
            temp[tempIndex++] = array[right++];

        //将临时数组的内容复制到原数组
        System.arraycopy(temp, low, array, low, high - low + 1);
    }
    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1,7,6,4,4,3,5,6,12,11,15,0};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
