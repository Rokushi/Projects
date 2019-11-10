package com.company;

import java.util.Vector;

public class Multiplication extends Thread {
    private Vector v;
    private int n;
    private int k;
    private int l;

    Multiplication(Vector v, int n, int k, int l){
        this.v = v;
        this.n = n;
        this.k = k;
        this.l = l;
    }

    public void run(){
        for (int i = k; i < l; i++){
            v.set(i, (int)v.get(i) * n);
        }
    }
}