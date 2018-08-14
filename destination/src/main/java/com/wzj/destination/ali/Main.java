package com.wzj.destination.ali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int maxWorkinghourGap(int[] workinghours) {
        if(workinghours==null||workinghours.length<2)
        {
            return 0;
        }

        int []result=bucketsort(workinghours);


        int res = 0;
        for(int i=0;i<result.length-1;i++)
        {
            if((result[i+1]-result[i])>res)
            {
                res=(result[i+1]-result[i]);
            }

        }

        return res;

    }
    static int[] bucketsort(int []nums){
        int []result=new int[nums.length];
        int max=nums[0];
        int min=nums[0];


        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }

            if(nums[i]>max)
            {
                max=nums[i];
            }
        }

        int bucketlength=(max-min)/(nums.length-1)+1;
        int bucketcount=(max-min)/bucketlength+1;

        List list[]=new ArrayList[bucketcount];

        for(int i=0;i<nums.length;i++)
        {
            int number=(int)(Math.floor((nums[i]-min)/bucketlength));
            if(list[number]==null)
            {
                list[number]=new ArrayList();
            }

            list[number].add(nums[i]);
        }

        for(int i=0;i<bucketcount;i++)
        {
            if(list[i]!=null) {
                Collections.sort(list[i]);
            }
        }

        int k=0;
        for(int i=0;i<bucketcount;i++)
        {
            if(list[i]!=null) {
                for (int j = 0; j < list[i].size(); j++) {
                    result[k] = (int) list[i].get(j);
                    k++;
                }
            }
        }

        return result;

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String inputData;
        try {
            inputData = in.nextLine();
        } catch (Exception e) {
            return;
        }

        String[] strs = inputData.split(",");
        int[] workinghours = new int[strs.length];
        for (int i=0;i<strs.length;i++) {
            workinghours[i] = Integer.parseInt(strs[i]);
        }

        int res = maxWorkinghourGap(workinghours);
        System.out.println(String.valueOf(res));

    }
}