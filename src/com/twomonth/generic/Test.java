package com.twomonth.generic;

class Test{
    public static void main(String[] args) {
        int [] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int value : a) {
            System.out.println(value);
        }
        System.out.println("======");
        boolean b = true;
        int i = 0;
        while (b){
            if (i == a.length-i-1 || a.length-i*2-1 == 1){
                b = false;
            }else {
                int temp = a[i];
                a[i] = a[a.length-i-1];
                a[a.length-i-1] = temp;
                i++;
            }
        }

        for (int value : a) {
            System.out.println(value);
        }
    }

}