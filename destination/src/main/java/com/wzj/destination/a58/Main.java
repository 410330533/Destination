package com.wzj.destination.a58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.jiguchuanhua(7,6));
        //System.out.println(main.jifenduihuan(100, new int[]{14, 55, 39}));

    }
    public int share(int child){
        if(child == 10) return 2;
        return (share(child + 1) + 1) << 1;
    }

    public List jifenduihuan(int total, int[] prices){
        LinkedList<Integer> res = new LinkedList<>();
        Arrays.sort(prices);
        for(int i = prices.length - 1; total > 0 && i >= 0; i--){
            while(prices[i] <= total){
                total -= prices[i];
                res.offerFirst(prices[i]);
            }
        }
        return total == 0 ? res : null;
    }

    public List<Integer> jiguchuanhua(int totalNum, int countNum){
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> total = new LinkedList<>();
        for(int i = 1; i <= totalNum; i++){
            total.offerLast(i);
        }
        for(int i = 1; i <= totalNum; i++){
            int size = total.size();
            int r = countNum % size;
            for(int j = size - 1; j > r - 1; j--){
                total.offerFirst(total.removeLast());
            }
            res.add(total.removeLast());
        }
        return res;
    }

}
