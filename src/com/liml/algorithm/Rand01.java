package com.liml.algorithm;

/**
 * Created by bright on 16-7-29.
 */
public class Rand01 {
    public static double rand(double[] rand){
        final double a = 7;
        final double b = 25;
        final double m = 256;

        double temp = (a*rand[0]+b) % m;
        rand[0] = temp;
        double p = temp / m;
        return p;
    }

    public static void main(String[] args){
        double[] rand = {5.0};
        for(int i=0;i<20;i++){
            System.out.println(rand(rand));
        }
    }
}
