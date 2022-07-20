package edu.handong.csee.isel.itc.study;

public class Main {
    public static void main(String[] args) {
        Matrix mt = new Matrix();
        double[][] data = {{0,0,0},{0,1,1},{1,0,1},{1,1,0}};
        SetData sd = new SetData(data);
        double[][] x = sd.getX();
        double[][] y = sd.getY();
        double[][][] w = sd.getW();

        int epoch = 10;

        for(int i = 0; i <= epoch; i++){
            TensorFlow tf = new TensorFlow(x,y,w);
            double cost = GetCost.forward(tf.getHypothesis(), y);
            double accuracy = tf.prediction();
            w = tf.optimize();
            if(i % 1 == 0)
                System.out.println("epoch = " + i + "\tcost = " + cost + "\tAccuracy = " + accuracy);
        }
    }
}