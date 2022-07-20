package edu.handong.csee.isel.itc.study;

public class GetCost {
    public static double forward(double[][] hypothesis, double[][] y){
        double[][] temp = Matrix.add(
                Matrix.dot(y, Matrix.log(Matrix.add(1e-9,hypothesis))),
                Matrix.dot(Matrix.add(1, Matrix.mul(-1,y)), Matrix.log(Matrix.add(1.000000001,Matrix.mul(-1,hypothesis)))));
        double cost = - Matrix.reduce_mean(temp);

        return cost;
    }
    public static double[][] backward(double[][] hypothesis, double[][] y){
        double[][] dervCostH = Matrix.mul(-1.0/ hypothesis.length, Matrix.add(
                Matrix.mul(y, Matrix.reciprocal(hypothesis)),
                Matrix.mul(Matrix.add(1, Matrix.mul(-1, y)), Matrix.reciprocal( Matrix.add(1, Matrix.mul(-1, hypothesis))))
        ));
        return dervCostH;
    }
}
