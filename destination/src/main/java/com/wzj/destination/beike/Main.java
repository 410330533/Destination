package com.wzj.destination.beike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Interval> intervals = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            intervals.add(new Interval(i + 1, in.nextInt(), in.nextInt()));
        }

        Collections.sort(intervals, new MyComparator());

        int count = Interval.checkCollision(intervals);
        if(count == 0){
            System.out.println(n);
            for(int i = 0; i < n; i++){
                System.out.print((i+1)+" ");
            }
            System.out.println();
        }else{
            count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(Interval.checkCollision(intervals, i)){

                    count++;
                    list.add(intervals.get(i).id);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            for (Integer integer : list){
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }

    public static class Interval{
        int id;
        int start;
        int end;

        public Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public static int checkCollision(List<Interval> intervals){
            int count = 0, n = intervals.size();

            Interval cur = intervals.get(0);
            for (int i = 1; i < n; i++){
                Interval next = intervals.get(i);
                if(cur.end > next.start){
                    count++;
                }
                cur = next;
            }
            return count;
        }

        public static boolean checkCollision(List<Interval> intervals, int index){
            int n = intervals.size(), i = 0;
            Interval cur = null;
            if(index == 0){
                cur = intervals.get(1);
                i = 2;
            }else{
                cur = intervals.get(0);
                i = 1;
            }

            for (; i < n; i++){
                if (i == index) continue;
                //System.out.println(index);
                Interval next = intervals.get(i);
                if(cur.end > next.start){
                    return false;
                }
                cur = next;
            }
            return true;
        }
    }

    private static class MyComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}
