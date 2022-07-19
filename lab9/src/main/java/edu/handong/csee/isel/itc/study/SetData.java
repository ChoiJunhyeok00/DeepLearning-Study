package edu.handong.csee.isel.itc.study;

import java.util.Random;

public class SetData {
    public double[][] data;
    public double[][] X;
    public double[][] Y;
    public double[][][] w;

    public SetData(double[][] data){
        this.data = data;
        setX();
        setY();
        setW();
    }
    public void setX(){
        double[][] X = new double[data.length][data[0].length];
        for(int i = 0; i < data.length; i++) {
            X[i][0] = 1;
            for(int j = 0; j < data[0].length-1; j++) {
                X[i][j + 1] = data[i][j];
            }
        }
        this.X = X;
    }
    public double[][] onehot(double[][] Y, double max){
        double[][] y = new double[Y.length][(int)max+1];
        for(int i=0; i < y.length; i++){
            for(int j=0; j < y[0].length; j++){
                if(Y[i][0] == j) y[i][j] = 1;
                else y[i][j] = 0;
            }
        }
        return y;
    }
    public void setY(){
        double[][] Y = new double[data.length][1];
        //double max = 0;
        for(int i = 0; i < data.length; i++) {
            Y[i][0] = data[i][data[0].length-1];
            //if(Y[i][0] > max) max = Y[i][0];
        }
        this.Y = Y;
        //this.Y = onehot(Y, max);
    }
    public void setW(){
        double[][][] w = new double[3][X[0].length][Y[0].length];
        Random rand = new Random();
        for(int i = 0; i < w.length; i++) {
            for(int j =0 ; j < w[0].length; j++){
                for(int z =0 ; z< w[0][0].length;z++){
                    w[i][j][z] = rand.nextDouble();
                }
            }
        }
        this.w = w;
    }
    public double[][] getX(){
        return X;
    }
    public double[][] getY(){
        return Y;
    }
    public double[][][] getW(){
        return w;
    }
}
