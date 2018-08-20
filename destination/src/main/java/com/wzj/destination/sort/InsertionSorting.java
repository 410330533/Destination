package com.wzj.destination.sort;

import java.util.Arrays;

/**
 * Created by WZJ on 2018/4/10.
 */

public class InsertionSorting {
    //直接插入排序：每次将一个待排序的数据按照其关键字的大小插入到前面已经排序好的数据中的适当位置，直到全部数据排序完成。
    //时间复杂度（最好、最坏、平均）：O(n)、O(n2)、O(n2)
    //空间复杂度：O(1)
    //稳定性：稳定；每次都是在前面已经排序好的序列中找到适当的位置，只有小的数组会往前插入，所以原来相同的两个数组在排序后相对位置不变。

    //移动法
    public static void insertSort(int[] array){
        int preIndex, current;
        for(int i = 1; i < array.length; i++){
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
    }

    //in-place交换法
    public static void improvedInsertSort(int[] array){
        int preIndex;
        for(int i = 1; i < array.length; i++){
            preIndex = i - 1;
            //current = array[i];
            while (preIndex >= 0 && array[preIndex] > array[preIndex + 1]){
                inplaceOperation(array, preIndex, preIndex + 1);
                preIndex--;
            }
        }
    }


    //希尔排序：希尔排序根据增量值对数据按下表进行分组，对每组使用直接插入排序算法排序；
    //随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整体采用直接插入排序得到有序数组，算法终止。

    //时间复杂度（最好、最坏、平均）：O(n)、O(n2)、O(n1.3)
    //空间复杂度：O(1)
    //稳定性：不稳定；因为是分组进行直接插入排序，原来相同的两个数字可能会被分到不同的组去，可能会使得后面的数字会排到前面，使得两个相同的数字排序前后位置发生变化。

    //交换法
    public static void improvedShellSort(int[] array){
        int gap = array.length/2;   //增量
        for(; gap > 0; gap /= 2){
            //从第gap个元素逐步对其所在分组进行直接插入排序
            for(int i = gap; i < array.length; i++){
                int j = i;
                //某一分组内的插入排序
                while (j - gap >= 0 && array[j] < array[j - gap]){
                    inplaceOperation(array, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    //移动法
    public static void shellSort(int[] array){
        int gap = array.length/2;
        for( ; gap > 0; gap /= 2){
            for (int i = gap; i < array.length; i++){
                int current = array[i];
                int j = i;
                while (j - gap >= 0 && array[j - gap] > current){
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = current;
            }
        }
    }

    public static void inplaceOperation(int[] array, int i, int j){
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }


    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1,7,6,4,4,3,5,6,12,11,15,0};

        //insertSort(array);
        //improvedInsertSort(array);

        //shellSort(array);
        improvedShellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
