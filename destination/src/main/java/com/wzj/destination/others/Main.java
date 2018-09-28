package com.wzj.destination.others;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        int[] flag = new int[m];

        int left = 0, res = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= m){
                if(flag[nums[i] - 1] == 0){
                    count++;
                }
                flag[nums[i] - 1]++;
                res++;
                //System.out.println(nums[i] +" "+ sum);
                if(res == m){
                    break;
                }
                while(count == m){

                    if(--flag[nums[i] - 1] == 0) count--;
                    res = Math.min(res, i - left + 1);
                    System.out.println(res);
                    left++;
                }

            }else{
                left = i + 1;
            }
        }
        //res = res == Integer.MAX_VALUE ? 0 : res;
        System.out.println(res);
    }
}
