package edu.handong.csee.isel.itc.study;

public class Matrix {

    public static double[][] matmul(double[][] a, double[][] b){
        double[][] result = new double[a.length][b[0].length];
        for(int z=0; z < b[0].length;z++){
            for(int i = 0; i < a.length; i++){
                double temp = 0;
                for(int j = 0; j < a[0].length; j++){
                    temp +=  (a[i][j]*b[j][z]);
                }
                result[i][z] = temp;
            }
        }
        return result;
    }

    public static double[][] mul_c(double num, double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] *= num;
            }
        }
        return matrix;
    }
    public static double[][][] mul_c(double num, double[][][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for(int z = 0; z < matrix[i][j].length; z++){
                    matrix[i][j][z] *= num;
                }
            }
        }
        return matrix;
    }
    public static double[] mul_c(double num, double[] matrix){
        for(int i = 0; i < matrix.length; i++){
            matrix[i] *= num;
        }
        return matrix;
    }
    public static double[] sub(double[] a, double[] b){
        for(int i = 0; i < a.length; i++){
            a[i] -= b[i];
        }
        return a;
    }
    public static double[][] sub(double[][] a, double[][] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    public static double[][][] sub(double[][][] a, double[][][] b){
        double[][][] result = new double[a.length][a[0].length][a[0][0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                for(int z = 0; z < a[0][0].length; z++){
                    result[i][j][z] = a[i][j][z] - b[i][j][z];
                }
            }
        }
        return result;
    }
    public static double[][] add(double[][] a, double[][] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    public static double[][] add(double a, double[][] b){
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[0].length; j++){
                b[i][j] += a;
            }
        }
        return b;
    }
    public static double[] add(double a, double[] b){
        for(int i = 0; i < b.length; i++){
            b[i] += a;
        }
        return b;
    }
    public static double[][] div(double a, double[][] b){
        double[][] result = new double[b.length][b[0].length];
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[0].length; j++){
                result[i][j] = a / b[i][j];
            }
        }
        return result;
    }
    public static double[][] div(double[][] a, double[] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                result[i][j] = a[i][j] / b[i];
            }
        }
        return result;
    }
    public static double[][] log(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j] = Math.log(m[i][j]);
            }
        }
        return m;
    }

    public static double[][] exp(double[][] m){
        double[][] result = new double[m.length][m[0].length];
        for(int i=0; i< m.length;i++){
            for(int j=0; j < m[0].length; j++){
                result[i][j] = Math.exp(m[i][j]);
            }
        }
        return result;
    }
    public static double[][] transpose(double[][] m){
        double[][] result = new double[m[0].length][m.length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                result[j][i] = m[i][j];
            }
        }
        return result;
    }
    public static double[][] reciprocal(double[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                m[i][j] = 1/m[i][j];
            }
        }
        return m;
    }
    public static double[] argmax(double[][] a){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            double temp =0;
            for(int j=0; j<a[0].length; j++){
                if(temp < a[i][j]) temp = a[i][j];
            }
            result[i] = temp;
        }
        return result;
    }
    public static double[] reduced_sum(double[][] x){
        double[] result = new double[x.length];
        for(int i=0; i< x.length; i++){
            double temp = 0;
            for(int j=0;j< x[0].length; j++){
                temp += x[i][j];
            }
            result[i] = temp;
        }
        return result;
    }
    public static double reduced_sum(double[] x){
        double result = 0;
        for(int i = 0; i < x.length; i++){
            result += x[i];
        }
        return result;
    }
    public static double reduce_mean(double[] matrix) {
        double result = 0;
        for(int i = 0; i < matrix.length; i++){
            result += matrix[i];
        }
        result /= matrix.length;
        return result;
    }
    public static double reduce_mean(double[][] matrix) {
        double result = 0;
        for(int i=0;i< matrix.length;i++){
            result += matrix[i][0];
        }
        result /= matrix.length;
        result /= 2.;
        return result;
    }
}

