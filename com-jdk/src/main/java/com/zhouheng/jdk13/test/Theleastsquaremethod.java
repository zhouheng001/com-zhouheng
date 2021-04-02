package com.zhouheng.jdk13.test;

/**
 * 最小二乘法 y=ax+b
 * 
 * @author Administrator
 * 
 */
public class Theleastsquaremethod {
         
        private static double a;
 
        private static double b;
 
        private static int num;
 
        /**
         * 训练
         * 
         * @param x
         * @param y
         */
        public static void train(double x[], double y[]) {
                num = x.length < y.length ? x.length : y.length;
                calCoefficientes(x,y);
        }
 
        /**
         * a=(NΣxy-ΣxΣy)/(NΣx^2-(Σx)^2)
         * b=y(平均)-a*x（平均）
         * @param x
         * @param y
         * @return
         */
        public static void calCoefficientes (double x[],double y[]){
                double xy=0.0,xT=0.0,yT=0.0,xS=0.0;
                for(int i=0;i<num;i++){
                        xy+=x[i]*y[i];
                        xT+=x[i];
                        yT+=y[i];
                        xS+=Math.pow(x[i], 2.0);
                }
                a= (num*xy-xT*yT)/(num*xS-Math.pow(xT, 2.0));
                b=yT/num-a*xT/num;
        }
 
        /**
         * 预测
         * 
         * @param
         * @return
         */
        public static double predict() {
                System.out.println("a="+a);
                System.out.println("趋势值： b="+b);
                return b ;
        }
 
        public static void main(String args[]) {
                double[] x = { 1 , 2 , 3 , 4 } ;  //四个月份
        double[] y = {81,161,167,149} ; //对应每月M值(M、M-1、M-2、M-3)

        Theleastsquaremethod.train(x, y);
        Theleastsquaremethod.predict();
         
        
        }
        
}