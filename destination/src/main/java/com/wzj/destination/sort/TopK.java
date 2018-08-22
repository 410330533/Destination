package com.wzj.destination.sort;

/**
 * Created by WZJ on 2018/8/20.
 */

public class TopK {
    //O(n)
    //对照着堆排的解法来看，partition函数会不断地交换元素的位置，所以它肯定会改变数据输入的顺序；
    //既然要交换元素的位置，那么所有元素必须要读到内存空间中，所以它会占用比较大的空间，至少能容纳整个数组；
    //数据越多，占用的空间必然越大，海量数据处理起来相对吃力。
    //但是，它的时间复杂度很低，意味着数据量不大时，效率极高
    public static int[] quickSortTopK(int[] nums, int k){
        quickSort(nums, k, 0, nums.length - 1);
        int[] res = new int[k];
        //System.arraycopy(nums, 0, res, 0, k);
        System.arraycopy(nums, nums.length - k, res, 0, k);
        return res;
    }
    private static void quickSort(int[] nums, int k, int left, int right){
        if(left < right){
            int pivot = partition(nums, left, right);
            if (pivot == nums.length - k){
                return;
            }else if (pivot > nums.length - k){
                quickSort(nums, k, left, pivot - 1);
            }else {
                quickSort(nums, k, pivot + 1, right);
            }
        }
    }
    private static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left;
        while (left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }

            while(left < right && nums[left] <= pivot){
                left++;
            }

            swap(nums, left, right);
        }
        nums[l] = nums[left];
        nums[left] = pivot;
        return left;
    }

    //O(n*logk)
    //实现的过程中，我们先用前K个数建立了一个堆，然后遍历数组来维护这个堆。这种做法带来了三个好处：
    // （1）不会改变数据的输入顺序（按顺序读的）；
    // （2）不会占用太多的内存空间（事实上，一次只读入一个数，内存只要求能容纳前K个数即可）；
    // （3）由于（2），决定了它特别适合处理海量数据。
    public static int[] topMaxK(int[] nums, int k){
        for (int i = (k / 2) - 1; i >= 0; i--){
            adjustMinHeap(nums, i, k);
        }

        for (int i = k; i < nums.length; i++){
            if(nums[i] > nums[0]){
                swap(nums, i, 0);
                adjustMinHeap(nums, 0, k);
            }
        }
        int[] res = new int[k];
        System.arraycopy(nums, 0, res, 0, k);
        return res;
    }
    private static void adjustMinHeap(int[] nums, int start, int end){
        for(int i = 2 * start + 1; i < end; i = 2 * i + 1){
            if(i + 1 < end && nums[i] > nums[i + 1]){
                i++;
            }
            if(nums[start] > nums[i]){
                swap(nums, start, i);
                start = i;
            }
        }
    }
    public static int[] topMinK(int[] nums, int k){
        for(int i = (k / 2) - 1; i >= 0; i--){
            adjustMaxHeap(nums, i, k);
        }

        for(int i = k; i < nums.length; i++){
            if(nums[i] < nums[0]) {
                swap(nums, 0, i);
                adjustMaxHeap(nums, 0, k);
            }
        }
        int[] res = new int[k];
        System.arraycopy(nums, 0, res, 0, k);
        return res;
    }

    private static void adjustMaxHeap(int[] nums, int start, int length){
        for(int i = 2 * start + 1; i < length; i = 2 * i + 1){

            if(i + 1 < length && nums[i] < nums[i + 1]){
                i++;
            }
            if(nums[start] < nums[i]){
                swap(nums, i, start);
                start = i;
            }

        }
    }

    private static void swap(int[] nums, int i, int j){
        if(nums[i] != nums[j]){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 3, 4, 5, 6, 7, 16, 9, 10, 11, 12, 13, 14, 15, 8 };
        //int[] res = TopK.topMinK(nums, 7);
        //int[] res = TopK.topMaxK(nums, 7);
        int[] res = TopK.quickSortTopK(nums, 7);
        for(int n : res){
            System.out.print(n + " ");
        }
    }
}
