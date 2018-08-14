package com.wzj.destination.sort;

import java.util.Arrays;

/**
 * Created by WZJ on 2018/4/11.
 */

public class SelectionSorting {


    //直接选择排序：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
    //然后每次从剩余未排序元素中继续寻找最小（大）元素放到已排序序列的末尾。以此类推，直到所有元素均排序完毕

    //时间复杂度（最好、最坏、平均）：均为O(n2)
    //空间复杂度：O(1)
    //稳定性：不稳定
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){ //若i = minIdex 自身与自身inplace操作为0。所以需要进行判断，否则出错
                array[i] = array[minIndex] ^ array[i];
                array[minIndex] = array[minIndex] ^ array[i];
                array[i] = array[minIndex] ^ array[i];
            }
        }
    }

    /*堆排序
    *思想：堆排序是利用堆的性质进行的一种选择排序，先将排序元素构建一个最大堆,每次堆中取出最大的元素并调整堆。
    *     将该取出的最大元素放到已排好序的序列前面。这种方法相对选择排序，时间复杂度更低，效率更高。
    *
    *时间复杂度：均为O(nlogn)
    *空间复杂度：O(1)
    *稳定性：不稳定
    * */
    public static void heapSort(int[] array){
        //1.构建大根堆（升序采用大根堆、降序采用小根堆）
        for(int i = array.length/2 - 1; i >= 0; i--){ //array.lenght/2 - 1为第一个非叶子节点
            //从最后一个非叶子节点自下至上调整；数组中自右至左调整
            adjustHeap(array, i, array.length);
        }

        //2.交换堆顶元素与末尾元素+调整堆结构
        for(int j = array.length - 1; j > 0; j--){
            inplaceSwap(array, 0, j);
            adjustHeap(array, 0, j);
        }
    }

    private static void adjustHeap(int[] array, int i, int length){
        for(int k = 2*i + 1; k < length; k = 2*k + 1){//从左子节点开始调整；若左子节点存在子节点，则继续调整左子节点的子节点（递增条件）
            if(k + 1 < length && array[k] < array[k + 1]){ //先对左右子节点进行比较,选出其中最大的
                k++;
            }
            if(array[i] < array[k]){ //子节点与其父节点比较
                inplaceSwap(array, i, k);
                i = k; //不要遗漏！！此时，原来i位置上的元素已经交换到位置k
            }
        }
    }

    private static void inplaceSwap(int[] array, int i, int j){
        /*int temp = array[i];
        array[i] = array[j];
        array[j] = temp;*/
        if(i != j){
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }
    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1,7,6,4,4,3,5,6,12,11,15,0};

        //selectSort(array);

        heapSort(array);
        System.out.println(Arrays.toString(array));

        int[] a = {4,4};
        inplaceSwap(a, 0, 1);
        System.out.println(Arrays.toString(a));
    }
}
