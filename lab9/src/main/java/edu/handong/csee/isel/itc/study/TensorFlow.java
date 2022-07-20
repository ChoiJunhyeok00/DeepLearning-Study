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
    private double learning_rate = 0.01;
    public TensorFlow(double[][] x, double[][] y, double[][][] w){
        this.x = x;
        this.y = y;
        this.w = w;
        setHypothesis();
    }
    public void setHypothesis(){
        this.new_x = FirstLayer.forward(x, w);
        this.hypothesis = SecondLayer.forward(new_x, w);
    }
    public double[][] getHypothesis(){
        return hypothesis;
    }
    public void grad_fn(){
        double[][][] grad = new double[w.length][w[0].length][w[0][0].length];
        double[][] dercCostH = GetCost.backward(hypothesis, y);
        double[][] dervCostNewXW = Sigmoid.backward(hypothesis, dercCostH);
        grad[2] = Matrix.dot(Matrix.transpose(new_x), dervCostNewXW);

        double[][] dervCostNewX = Matrix.dot(dervCostNewXW, Matrix.transpose(w[2]));
        double[][] dervCostXW = Sigmoid.backward(new_x, dervCostNewX);
        double[][] dervCostW = Matrix.dot(Matrix.transpose(x), dervCostXW);
        for(int i = 0; i < grad[0].length; i++){
            grad[0][i][0] = dervCostW[i][1];
            grad[1][i][0] = dervCostW[i][2];
        }
        this.grad = grad;
    }
    public double[][][] optimize() {
        grad_fn();
        return Matrix.sub(w, Matrix.mul(learning_rate, grad));
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

