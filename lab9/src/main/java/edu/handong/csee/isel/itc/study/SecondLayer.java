package edu.handong.csee.isel.itc.study;

public class SecondLayer {
    public static double[][] forward(double[][]x, double[][][] w){
        return Sigmoid.forward(LogitFunction.forward(x, w[2]));
    }
}
