package edu.handong.csee.isel.itc.study;

public class GetCost {
    public static double forward(double[][] hypothesis, double[][] y){
        double[][] temp = Matrix.add(Matrix.matmul(y, Matrix.log(Matrix.add(-1e-9,hypothesis))),
                Matrix.matmul(Matrix.add(1,Matrix.mul_c(-1,y)), Matrix.log(Matrix.add(1.000000001,Matrix.mul_c(-1,hypothesis)))));
        double cost = - Matrix.reduce_mean(temp);

        return cost;
    }
    public static double backward(double[][] hypothesis, double[][] y){
        double[][] dervCostH = Matrix.add(    // 1 by 1
                Matrix.matmul(Matrix.transpose(y), Matrix.reciprocal(hypothesis)),
                Matrix.matmul(Matrix.transpose(Matrix.add(-1, y)), Matrix.reciprocal(Matrix.add(1, Matrix.mul_c(-1, hypothesis)))));
        System.out.println("cost back " +dervCostH.length + " " + dervCostH[0].length);
        return -dervCostH[0][0]/y.length;
    }
}
