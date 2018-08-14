package com.wzj.destination.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by WZJ on 2018/4/15.
 */

public class LinearNoncomparison {
    /*
    * 计数排序：计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
    * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
    * 时间复杂度：均为O(n+k)
    * 空间复杂度：O(n+k)
    * 稳定性：稳定
    * */
    public static int[] countingSort(int[] array, int maxVlaue){
        int[] countingArray = new int[maxVlaue + 1];
        int[] result = new int[array.length];
        int sortedIndex = 0;

        //统计次数
        for (int i = 0;i < array.length; i++){
            countingArray[array[i]]++;
        }
        //所有计数累计，计算每个数字在排序后所处的位置（result数组中的位置）
        for (int i = 1; i < maxVlaue + 1; i++){
            countingArray[i] += countingArray[i - 1];
        }
        /*int j = 0;
        while (j < maxVlaue + 1){
            if(countingArray[j] != 0){
                array[sortedIndex++] = j;
                countingArray[j]--;
            }else {
                j++;
            }
        }*/

        //反向填充目标数组
        for (int i = array.length - 1; i >= 0; i--){
            int element = array[i];
            result[--countingArray[element]] = element;
        }
        return result;
    }


    /*
    * 基数排序
    * 时间复杂度：均为O(n*k)      （O(k(n+r))）    r为关键字分量的最大个数
    * 空间复杂度：O(n+k)  k为桶的个数（关键码的个数）     (O(n+kr))
    *
    * */

    public static int[] radixSort(int[] array){
        int maxDigit = maxDigit(array);
        return sortCore(array, 0, maxDigit);
    }
    private static int[] sortCore(int[] array, int digit, int maxDigit){
        if (digit >= maxDigit){
            return array;
        }

        final int radix = 10; //基数
        int arrayLength = array.length;
        int[] bucket = new int[radix]; //bucket中存计数，也可以存储实际元素，但这需要bucket为二维结构
        int[] sortedArray = new int[arrayLength];

        //分配，将数组中的数字分配到桶中
        for (int i = 0; i < arrayLength; i++){
            int number = (array[i] / (int)Math.pow(10, digit)) % radix; //求某一位上的数字
            bucket[number]++;
        }
        //将各个桶中的数字个数，转化为各个桶中最后一个数字的下标索引（未采用二维数组的bucket）
        for (int i = 1; i < radix; i++){
            bucket[i] += bucket[i - 1];  //若bucket[0] = 2 (0, 10)，则在该桶中的最后一个数字（10）的实际索引为2-1=1
        }
        //收集，将桶中所盛数据按照编号从小到大，桶中由顶至低依次重新收集串起来（稳定），得到新的序列
        for (int i = arrayLength - 1; i >= 0; i--){
            int element = array[i];
            int number = (array[i] / (int)Math.pow(10, digit)) % radix;  //找到元素所在的桶
            sortedArray[bucket[number] - 1] = element; //将元素放到sortedArray中的指定位置上
            bucket[number]--;
        }

        //对剩余的高位进行递归操作
        return sortCore(sortedArray, digit + 1, maxDigit);
    }
    private static int maxDigit(int[] array){
        int maxDigit = 1;
        for (int i = 0; i < array.length; i++){
            int currentDigit = String.valueOf(array[i]).length();
            if(currentDigit > maxDigit){
                maxDigit = currentDigit;
            }
        }
        return maxDigit;
    }

    //桶排序
    public static void bucketSort(int[] num){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int n : num){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        int bucketLength = (max - min) / num.length + 1;
        int bucketSize = (max - min) / bucketLength + 1;
        List<List<Integer>> list = new ArrayList<>(bucketSize);
        for(int i = 0; i < bucketSize; i++){
            list.add(new ArrayList<>());
        }
        for(int n : num){
            int index = (n - min) / bucketLength;
            list.get(index).add(n);
        }
        for (List<Integer> l : list){
            Collections.sort(l);
        }
        int j = 0;
        for(List<Integer> l : list){
            for(Integer i : l){
                num[j++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1,7,6,4,4,3,5,6,12,11,15,0};
        //array = countingSort(array, 15);
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }
}
