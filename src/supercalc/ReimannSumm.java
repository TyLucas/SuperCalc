/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalc;


/**
 *
 * @author andreas lees
 */
public class ReimannSumm {
    public static double myFunct(double n) {
         double ans;
         //outputs radians
         //ans = (Math.cos(n) / n);
         ans = 1 / (1 + (n * n));
         return ans;
    }    
    
    public static double leftSum(double lowerBound, double upperBound, int rectangleCount) {
        //left endpoint
         double rectWidth = (upperBound - lowerBound) / rectangleCount;
         double myVal = 0.0;
         int counter;
         double z = lowerBound;
         for (counter = 0; counter < rectangleCount; ++counter) {
             myVal = myVal + (rectWidth * myFunct(z));
             z = z + rectWidth;
             //System.out.println("Left funct" + counter + ". " + myVal);
         }
         return myVal;
    }    
    
    public static double rightSum(double lowerBound, double upperBound, int rectangleCount) {
        //right endpoint
         double rectWidth = (upperBound - lowerBound) / rectangleCount;
         double myVal = 0.0;
         int counter;
         double z = lowerBound + rectWidth;
         for (counter = 1; counter <= rectangleCount; ++counter) {
             myVal = myVal + (rectWidth * myFunct(z));
             z = z + rectWidth;
             //System.out.println("Left funct" + counter + ". " + myVal);
         }
         return myVal;
    }
    //trapezoid summ is (right+left endpoint)/2
    public static double trapezoidSum(double lowerBound, double upperBound, int rectangleCount) {
        //trapezoid sum
        double myVal = (rightSum(lowerBound, upperBound, rectangleCount) + leftSum(lowerBound, upperBound, rectangleCount))/2;
        /* old code
         double rectWidth = (upperBound - lowerBound) / rectangleCount;
         double myVal = 0.0;
         int counter;
         double z = lowerBound;
         for (counter = 0; counter <= rectangleCount; ++counter) {
             if (counter == 0 || counter == rectangleCount) {
                myVal = myVal + ((rectWidth / 2) * myFunct(z));
             } else {
                myVal = myVal + (rectWidth * myFunct(z));
             }
             z = z + rectWidth;
         }
        */
         return myVal;
    }
    
    public static double simpsonSum(double lowerBound, double upperBound, int rectangleCount) {
        //trapezoid sum
         double rectWidth = (upperBound - lowerBound) / rectangleCount;
         double myVal = 0.0;
         int counter;
         double z = lowerBound;
         for (counter = 0; counter <= rectangleCount; ++counter) {
             if (counter == 0 || counter == rectangleCount ) {
                myVal = myVal + ((rectWidth / 3) * myFunct(z));
                System.out.println("Simpson end func" + counter + ". " + myVal);
                 
             } else if (counter % 2 == 0) { //even
                myVal = myVal + ((rectWidth / 3) * 2 * myFunct(z));
                System.out.println("Simpson even func" + counter + ". " + myVal);
             } else { //odd
                myVal = myVal + ((rectWidth / 3) * 4 * myFunct(z));
                System.out.println("Simpson odd func" + counter + ". " + myVal);
             }
             z = z + rectWidth;
         }
         return myVal;
    }
    
    public static void main(String[] args) {
         
         
         
         double myVal;
         double i;
         int counter;
         double lowerBound;
         double upperBound;
         int rectangleCount;
         System.out.println("Insert Lower Bound: ");
         lowerBound = SuperCalc.getNextDouble();
         System.out.println("Insert Upper Bound: ");
         upperBound = SuperCalc.getNextDouble();
         System.out.println("Insert Number of Rectangles: ");
         rectangleCount = SuperCalc.getNextInt();
         System.out.println("Left " + leftSum(lowerBound, upperBound, rectangleCount));
         System.out.println("Right " + rightSum(lowerBound, upperBound, rectangleCount));
         System.out.println("Trapezoid " + trapezoidSum(lowerBound, upperBound, rectangleCount));
         System.out.println("Simpson " + simpsonSum(lowerBound, upperBound, rectangleCount));
         double rectWidth = (upperBound - lowerBound) / rectangleCount;/*
         //left endpoint
         myVal = 0.0;
         counter = 0;
         double z = lowerBound;
         for (i = 0; i < rectangleCount; ++i) {
             ++counter;
             myVal = myVal + (rectWidth * myFunct(z));
             z = z + rectWidth;
             System.out.println("Left " + counter + ". " + myVal);
         }
         
         //original code
         for (i = lowerBound; i <= upperBound - rectWidth + .1; i = i + rectWidth) {
             ++counter;
             myVal = myVal + (rectWidth * myFunct(i));
             //System.out.println("Left " + counter + ". " + myVal);
         }
         System.out.println("Left " + counter + ". " + myVal);
         //right endpoint
         myVal = 0.0;
         counter = 0;
         for (i = lowerBound + rectWidth; i <= upperBound + .1; i = i + rectWidth) {
             ++counter;
             myVal = myVal + (rectWidth * myFunct(i));
             //System.out.println("Right " + counter + ". " + myVal);
         }
         System.out.println("Right " + counter + ". " + myVal);
         *///trapezoid rule
         /*myVal = 0.0;
         counter = 1;
         for (i = lowerBound; i <= upperBound + .1; i = i + rectWidth) {
             //FIXME round i back up after adding rectwidth(some instances its just under upperBound)
             if (i == lowerBound || i == upperBound) {
                System.out.println((int)i);
                myVal = myVal + ((rectWidth * .5) * myFunct(i));
                System.out.println("Trapezoid end" + counter + ". " + myVal);
                 
             } else {
                System.out.println(i);
                myVal = myVal + ((rectWidth * .5) * 2 * myFunct(i));
                System.out.println("Trapezoid " + counter + ". " + myVal);
             }
             ++counter;
         }*/
         
         //simpson's rule
         myVal = 0.0;
         counter = 0;
         for (i = lowerBound; i <= upperBound; i = i + rectWidth) {
             if (counter == 0 || counter == rectangleCount ) {
                myVal = myVal + ((rectWidth * (1 / 3.0)) * myFunct(i));
                System.out.println("Simpson end" + counter + ". " + myVal);
                 
             } else if (counter % 2 == 0) { //even
                myVal = myVal + ((rectWidth * (1 / 3.0)) * 2 * myFunct(i));
                System.out.println("Simpson even" + counter + ". " + myVal);
             } else { //odd
                myVal = myVal + ((rectWidth * (1 / 3.0)) * 4 * myFunct(i));
                System.out.println("Simpson odd" + counter + ". " + myVal);
             }
             ++counter;
         }
    }
    
}
