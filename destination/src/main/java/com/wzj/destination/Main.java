package com.wzj.destination;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();

        int complete=s.nextInt();

        int other=s.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
//   System.out.println(arr[i]);
        }
        int res=f(n,complete,other,arr);
        System.out.println(res);
    }

    private static int f(int n, int complete, int other, int[] arr) {
        // TODO Auto-generated method stub
        if(n<=0)
            return 0;
        int res=0;
        ArrayList<Integer>list=new ArrayList<Integer>();
        for(int a:arr)
            if(a>0)
                list.add(a);
        int brr[]=new int[list.size()];
        for(int i=0;i<brr.length;i++)
            brr[i]=list.get(i);
        while(brr.length!=0){
            int index=0;
            for(int i=1;i<brr.length;i++)
                if(brr[index]<brr[i])
                    index=i;
            for(int i=0;i<brr.length;i++){
                if(index==i)
                    brr[i]-=complete;
                else
                    brr[i]-=other;
            }
            list=new ArrayList<Integer>();
            for(int a:brr)
                if(a>0)
                    list.add(a);
            brr=new int[list.size()];
            for(int i=0;i<brr.length;i++)
                brr[i]=list.get(i);
            res++;
        }
        return res;
    }
}