package edu.handong.csee.isel.itc.study;

public class FirstLayer {
    public static double[][] forward(double[][] x, double[][][] w){
        double[][] y1 = Sigmoid.forward(LogitFunction.forward(x, w[0]));
        double[][] y2 = Sigmoid.forward(LogitFunction.forward(x, w[1]));

        double[][] new_x = new double[y1.length][y1[0].length + y2[1].length + 1];

        for(int i = 0;i < new_x.length; i++){
            new_x[i][0] = 1;
            for(int j = 0; j < y1[0].length; j++){
                new_x[i][j+1] = y2[i][j];
            }
            for(int j = 0; j < y2[1].length; j++){
                new_x[i][j+y1[0].length + 1] = y2[i][j];
            }
        }
        return new_x;
    }

}
