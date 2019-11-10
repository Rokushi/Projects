package com.company;

import java.util.Vector;

//Пулл потоков
public class Task1 extends Thread {
    private Vector vector;
    private double a;
    private int t;

    Task1(Vector vector, double a, int t){
        this.vector = vector;
        this.a = a;
        this.t = t;
    }

    public void run(){
        double o;
        for (int j = t; j < vector.size(); j++){
            o = (double)vector.get(j) / a;
            if (o == (int)o){
                vector.remove(j);
                j--;
            }
        }
    }
}