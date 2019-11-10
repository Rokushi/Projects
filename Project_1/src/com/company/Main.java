package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector();
        Vector vector1;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер вектора: ");
        int n = in.nextInt();

        //System.out.println("Введите элементы вектора: ");
        //for (int i = 0; i < n; i++){
        //    vector.addElement(in.nextInt());
        //}

        for (int i = 0; i < n; i++){
            vector.addElement((int)(Math.random()*100));
        }
        vector1 = vector;

        System.out.print("Введите число: ");
        int m = in.nextInt();
        //int m = 5;

        System.out.print("Введите количество потоков: ");
        int k = in.nextInt();

        Multiplication[] mult = new Multiplication[1];
        mult[0] = new Multiplication(vector, m, 0, n);
        long dt1 = System.currentTimeMillis();

        mult[0].start();
        try {
            mult[0].join();
        } catch (InterruptedException e) {}

        long dt2 = System.currentTimeMillis();
        long dt = dt2 - dt1;
        System.out.println("Последовательно: " + dt);

        Multiplication[] mult1 = new Multiplication[k];

        int a = 0, b = a + 1;
        while (a < k){
            mult1[a] = new Multiplication(vector1, m, (n * a) / k, (n * b) / k);
            a++;
        }

        //mult1[0] = new Multiplication(vector1, m, 0, n / 4);
        //mult1[1] = new Multiplication(vector1, m, n / 4, n / 2);
        //mult1[2] = new Multiplication(vector1, m, n / 2, n * 3 / 4);
        //mult1[3] = new Multiplication(vector1, m, n * 3 / 4, n);
        dt1 = System.currentTimeMillis();

        for (int i = 0; i < k; i++){
            mult1[i].start();
            try {
                mult1[i].join();
            } catch (InterruptedException e) {}
        }

        dt2 = System.currentTimeMillis();
        dt = dt2 - dt1;

        System.out.println("Параллельно: " + dt);
        in.close();
    }
}
