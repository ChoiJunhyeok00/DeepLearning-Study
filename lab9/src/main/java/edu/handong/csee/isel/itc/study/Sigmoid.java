package edu.handong.csee.isel.itc.study;

public class Sigmoid {
    public static double[][] forward(double[][] x){
        return Matrix.div(1,(Matrix.add(1.0, Matrix.exp(x))));
    }
    public static double[][] backward(double[][] y, double[][] back){
        return Matrix.matmul(Matrix.matmul(Matrix.transpose(y), Matrix.add(1,Matrix.mul_c(-1,y))), back);
    }
    public static double[][] backward(double[][] y, double back){
        return Matrix.mul_c(back, Matrix.matmul(Matrix.transpose(y), Matrix.add(1,Matrix.mul_c(-1,y))));
    }
}
