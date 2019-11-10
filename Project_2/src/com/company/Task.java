package com.company;

import java.util.Vector;

//Декомпозиция по данным
public class Task extends Thread {
    private double[] n;
    private Vector v;
    private double k;
    private double l;

    Task(double[] n, Vector v, double k, double l){
        this.n = n;
        this.v = v;
        this.k = k;
        this.l = l;
    }

    public void run(){
        double o;
        double p = 0;
        for (int i = (int) k; i < l; i++){
            for (int j = 0; j < v.size(); j++){
                o = n[i] / (double)v.get(j);
                if (o != (int)o){
                    p = n[i];
                }else{
                    j = v.size();
                    p = 0;
                }
            }
            if (p == n[i]){
                v.add(p);
            }
        }
    }
}