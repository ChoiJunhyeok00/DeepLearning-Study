package edu.handong.csee.isel.itc.study;

public class SecondLayer {
    public SecondLayer(double[][] new_x, double[][][] w){

    }
    public static double[][] forward(double[][] x, double[][][] w){
        return Sigmoid.forward(Matrix.dot(x, w[2]));
    }
    public static double[][] backward(double[][] hypothesis, double[][] y, double[][] new_x){
        double[][] dervCostNewXW = Sigmoid.backward(hypothesis, GetCost.backward(hypothesis, y));
        return Matrix.dot(Matrix.transpose(new_x), dervCostNewXW);
    }
}
