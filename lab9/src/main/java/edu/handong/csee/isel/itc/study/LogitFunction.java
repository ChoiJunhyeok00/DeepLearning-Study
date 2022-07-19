package edu.handong.csee.isel.itc.study;

public class LogitFunction {
    public static double[][] forward(double[][] x, double[][] w){
        return Matrix.matmul(x,w);
    }
    public static double[][] backward(double[][] x, double[][] back){
        return Matrix.matmul(x, back);
    }
    public static double[][] backward(double[][] x, double back){
        return Matrix.mul_c(back, x);
    }
}
