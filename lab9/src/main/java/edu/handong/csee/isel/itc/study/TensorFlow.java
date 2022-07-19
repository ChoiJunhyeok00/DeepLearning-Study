package edu.handong.csee.isel.itc.study;

import sun.misc.SignalHandler;

import java.util.Random;

public class TensorFlow {
    private double[][] x;
    private double[][] y;
    private double[][][] w;
    private double[][] new_x;
    private double[][] hypothesis;
    private double[][][] grad;
    private double learning_rate = 0.001;
    public TensorFlow(double[][] x, double[][] y, double[][][] w){
        this.x = x;
        this.y = y;
        this.w = w;
        setHypothesis();
    }
    public void setHypothesis(){
        this.new_x = FirstLayer.forward(x, w);
        this.hypothesis = SecondLayer.forward(x, w);
    }
    public double[][] getHypothesis(){
        return hypothesis;
    }
    public void grad_fn(){
        System.out.println(w.length + " " + w[0].length + " " + w[0][0].length);
        double[][][] grad = new double[w.length][w[0].length][w[0][0].length];
        double[][] dervCostNewXW = Sigmoid.backward(hypothesis, GetCost.backward(hypothesis, y));
        grad[2] = LogitFunction.backward(new_x, dervCostNewXW[0][0]);

        double[][] dervCostNewX = LogitFunction.backward(w[2], dervCostNewXW[0][0]);
        double[][] dervCostXW = Sigmoid.backward(new_x, dervCostNewX);

        System.out.println(dervCostNewXW.length + " " + dervCostNewXW[0].length);
        System.out.println(x.length + " " + x[0].length);
        double[][] dervCostW = LogitFunction.backward(x, dervCostXW);
        for(int i = 0; i < grad[0].length; i++){
            grad[0][i][0] = dervCostW[i][0];
            grad[1][i][0] = dervCostW[i][1];
        }
        this.grad = grad;
    }
    public double[][][] optimize() {
        grad_fn();
        return Matrix.sub(w, Matrix.mul_c(learning_rate, grad));
    }

    public double prediction(){
        double temp = 0;
        for(int i = 0; i < hypothesis.length; i++){
            if(hypothesis[i][0]  > 0.5 && y[i][0] == 1) temp++;
            else if(hypothesis[i][0]  < 0.5 && y[i][0] == 0) temp++;
        }
        return temp/hypothesis.length;
    }
}

