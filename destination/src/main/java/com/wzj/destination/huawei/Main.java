package com.wzj.destination.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Interval> intervals = new ArrayList<>();
        while(true){
            String str = in.nextLine();
            String[] array = str.split(",");
            if(array[0].equals("0") && array[1].equals("0")) break;
            Interval interval = new Interval(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            intervals.add(interval);
        }

        Collections.sort(intervals, new MyComparator());

        boolean[] visited = new boolean[13];
        ArrayList<Interval> res = new ArrayList<>();
        for(Interval interval : intervals){
            int s = interval.start, f = interval.end;
            if(s < 9) s = 9;
            boolean flag = true;
            for(int i = s - 9; i < f - 9; i++){
                if(visited[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int i = s - 9; i < f - 9; i++){
                    visited[i] = true;
                }
                res.add(interval);
            }
        }

        Collections.sort(res, new MyComparator1());
        for(Interval interval : res){
            System.out.println(interval.start +","+interval.end);
        }

    }

    public static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }

    private static class MyComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.end - o1.start == o2.end - o2.start){
                return o1.start - o2.start;
            }else{
                return (o2.end - o2.start) - (o1.end - o1.start);
            }

        }
    }

    private static class MyComparator1 implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.end - o2.end;
        }
    }
}