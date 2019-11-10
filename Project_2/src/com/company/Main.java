package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = in.nextInt() - 1;
        double[] num = new double[n];
        Vector vector = new Vector();
        Vector vector1 = new Vector();
        int i, t = 1, y = (int)(Math.round(Math.sqrt(n)));
        double p = 0, o;
        long dt1, dt2;

        for (i = 0; i < n; i++){
            num[i] = i + 2;
            vector1.add(num[i]);
        }
        vector.add(num[0]);

        //Декомпозиция по данным==========================================
        System.out.println("Декомпозиция по данным=====================");
        System.out.print("Введите количество потоков: ");
        int k = in.nextInt();

        for (i = 1; i < y; i++){
            for (int j = 0; j < vector.size(); j++){
                if ((num[i] / (double)vector.get(j)) != (int)(num[i] / (double)vector.get(j))){
                    p = num[i];
                }else{
                    j = vector.size();
                    p = 0;
                }
            }
            if (p == num[i]){
                vector.add(p);
            }
        }
        Task[] task = new Task[k];
        int a = 0;
        double b = n - Math.round(Math.sqrt(n)) + 1;

        while (a < k){
            task[a] = new Task(num, vector, Math.round((b * a) / k + Math.round(Math.sqrt(n))), Math.round((b * (a + 1)) / k + Math.round(Math.sqrt(n))));
            a++;
        }

        dt1 = System.currentTimeMillis();
        for (i = 0; i < k; i++){
            task[i].start();
            try {
                task[i].join();
            } catch (InterruptedException e) {}
        }
        dt2 = System.currentTimeMillis();
        System.out.println(dt2 - dt1);
        System.out.println(vector.size());
        //================================================================

        //Пулл потоков====================================================
        System.out.println("Пулл потоков===============================");
        for (i = 0; i < y; i++){
            for (int j = t; j < vector1.size(); j++){
                o = (double)vector1.get(j) / (double)vector1.get(i);
                if (o == (int)o){
                    vector1.remove(j);
                    j--;
                }
            }
            t++;
        }
        Task1[] task1 = new Task1[y];

        for (i = 0; i < y; i++){
            task1[i] = new Task1(vector1, (double)vector1.get(i), y);
        }

        dt1 = System.currentTimeMillis();
        for (i = 0; i < y; i++){
            task1[i].start();
            try {
                task1[i].join();
            } catch (InterruptedException e) {}
        }
        dt2 = System.currentTimeMillis();
        System.out.println(dt2 - dt1);
        //================================================================
        System.out.println(vector1.size());
    }
}
