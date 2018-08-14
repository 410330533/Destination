package com.wzj.destination.sort;

import java.util.Arrays;

/**
 * Created by WZJ on 2018/4/10.
 */

public class ExchangingSorting {
    //冒泡排序：对待排序元素的关键字从后往前进行多遍扫描，遇到相邻两个关键字次序与排序规则不符时，就将这两个元素进行交换。
    //这样关键字较小的那个元素就像一个泡泡一样，从最后面冒到最前面来。

    //时间复杂度（最坏、最好、平均）：O(n2)、O(n)、O(n2)
    //空间复杂度：O(1)（此处采用的in-place方式无额外的空间开销）
    //稳定；相邻的关键字两两比较，如果相等则不交换。所以排序前后的相等数字相对位置不变
    public static void bubbleSort(int[] array){
        boolean flag; //判断该轮排序是否有交换操作，若没有则表示已经排好
        for(int i = 0; i < array.length; i++){
            flag = false;
            for(int j = array.length - 1; j >= i + 1; j--){ //从后往前进行扫描
                if(array[j] < array[j - 1]){
                    //交换
                    array[j] = array[j] ^ array[j - 1];
                    array[j - 1] = array[j] ^ array[j - 1];
                    array[j] = array[j] ^ array[j - 1];
                    flag = true;
                }
            }
            if(!flag){
                break; //该轮排序没有交换操作，排序完成，退出该方法
            }
        }
    }


    //快速排序：该算法是分治算法，首先选择一个基准元素,根据基准元素将待排序列分成两部分,一部分比基准元素小,
    //一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
    //基准元素的选择对快速排序的性能影响很大，所有一般会想打乱排序数组选择第一个元素或则随机地从后面选择一个元素替换第一个元素作为基准元素。
    //时间复杂度（最坏、最好、平均）：O(n2)、O(nlogn)、O(nlogn)

    //空间复杂度：O(lgn)用于方法栈
    //稳定性：不稳定；快排将大于等于基准的元素放到左侧
    public static void quickSort(int[] array){
        qSort(array, 0, array.length - 1);
    }

    private static void qSort(int[] array, int left, int right){
        if(left < right){
            int pivotIndex = partition1(array, left, right);//以pivot为基准，将数组分成两部分
            qSort(array, left, pivotIndex - 1); //递归排序左子数组
            qSort(array, pivotIndex + 1, right); //递归排序右子数组
        }
    }

    //右移动 —— 右交换 —— 左移动 —— 左交换
    private static int partition(int[] array, int left, int right){
        int pivot = array[left]; //选择基准（最左侧元素）
        while (left < right){
            while (left < right && pivot <= array[right]){   //基准在左，则右侧先走（保证最终停下的位置的元素小于等于pivort）
                right--;
            }

            if(left < right){
                array[left++] = array[right];           //交换比基准小的元素到左边
            }

            while (left < right && pivot >= array[left]){
                left++;
            }

            if(left < right){
                array[right--] = array[left];   //交换比基准大的到右边
            }
        }
        array[left] = pivot; //基准归位
        return left; //返回基准的位置
    }
    //左右先移动，最后交换
    private static int partition1(int[] array, int left, int right){
        int initialLeft = left;
        int pivot = array[left];
        while (left < right){
            while (left < right && array[right] >= pivot){
                right--;
            }
            while (left < right && array[left] <= pivot){
                left++;
            }
            //左右搜索均停止，即right小于基准且left大于基准，此时需要进行交换
            if(left < right){
                array[left] = array[left] ^ array[right];
                array[right] = array[left] ^ array[right];
                array[left] = array[left] ^ array[right];
            }
        }
        array[initialLeft] = array[left];
        array[left] = pivot;

        return left;
    }
    public static void main(String[] args) {

        int[] array = {10,9,8,7,6,5,4,3,2,1,7,6,4,4,3,5,6,12,11,15,0};
        //bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));

    }
}
