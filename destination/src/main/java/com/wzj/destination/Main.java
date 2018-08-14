package com.wzj.destination;

public class Main{
    public static void main(String[] args){

       /* Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        String s1 = ss[0], s2 = ss[1];
        StringBuilder res = new StringBuilder();
        int bit = 0, m = s1.length(), n = s2.length();
        for(int i = m - 1; i >= 0; i--){
            int length = res.length();
            for(int j = n - 1; j >= 0; j--){
                int val = (s1.charAt(i) - '0') * (s2.charAt(j) - '0') + bit;
                int cur = val % 10;
                bit = val / 10;
                int index = (m - 1 - i) + (n - 1 - j);
                if(index < length){
                    val = cur + (int)(res.charAt(index) - '0');
                    cur = val % 10;
                    bit += val / 10;
                    res.setCharAt(index, (char)(cur + '0'));
                }else{
                    res.append((char)(cur + '0'));
                }
            }
            if(bit > 0){
                res.append((char)(bit + '0'));
                bit = 0;
            }
        }
        System.out.println(res.reverse().toString());*/



        try {
            Main main = new Main();
            Teacher teacher1 = main.new Teacher ("wzj", 25);
            Teacher teacher2 = (Teacher) teacher1.clone();
            teacher2.name = "waa";
            System.out.println();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }





    public class Teacher implements Cloneable{
        String name;
        int age;

        public Teacher(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}