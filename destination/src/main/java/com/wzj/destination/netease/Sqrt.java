package com.wzj.destination.netease;

public class Sqrt {
    private static double sqrt(double n, double l){
        double left = 1, right = n, mid = left + (right - left) / 2;
        while (Math.abs(mid * mid - n) > l){
            System.out.println(mid * mid);
            if(mid > n / mid){
                right = mid;
            }else if(mid < n / mid){
                left = mid;
            }else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(Sqrt.sqrt(3, 0.1));
    }
}
