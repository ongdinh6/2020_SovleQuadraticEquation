package com.example.computeequation2;

public class SolveQuadraticEquation {

    public static String solve(double a, double b, double c){
        double delta = 0;
        String rs = "";

        delta = b*b - 4*a*c;

        if(delta < 0) rs = "The equation has zero solutions!";
        if(delta == 0) {
            double x = -b/2*a;
            rs = "The equation has one solution is: \nX1==X2="+x;
        }
        if(delta > 0){
            double x1 = (-b-Math.sqrt(delta))/2*a;
            double x2 = (-b+Math.sqrt(delta))/2*a;
            rs = "The quation has two solutions is: \nX1 = "+x1+"\nX2 = "+x2;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(SolveQuadraticEquation.solve(2, -7, 3));
    }
}
