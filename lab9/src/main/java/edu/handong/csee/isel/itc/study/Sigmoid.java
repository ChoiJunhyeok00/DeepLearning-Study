package edu.handong.csee.isel.itc.study;

public class Sigmoid {
    public static double[][] forward(double[][] x){
        return Matrix.reciprocal((Matrix.add(1.0, Matrix.exp(Matrix.mul(-1, x)))));
    }
    public static double[][] backward(double[][] y, double[][] back){
        return Matrix.mul(back, Matrix.mul(y, Matrix.add(1, Matrix.mul(-1, y))));

    }
}
