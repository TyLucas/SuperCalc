/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalc;
import java.util.Scanner;
import util.*;
import parser.*;
/**
 *
 * @author andreas lees
 */
public class SuperCalc {
    public static final Scanner SCNR = new Scanner(System.in);

    public static String getNext() {
        String nextLine = SCNR.next();
        return nextLine;
        
    }

    public static String getNextLine() {
        String nextLine = SCNR.nextLine();
        return nextLine;
        
    }
    public static int getNextInt() {
        int nextLine = SCNR.nextInt();
        return nextLine;
        
    }
    public static double getNextDouble() {
        double nextLine = SCNR.nextDouble();
        return nextLine;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        printMenu();
    }
    public static void printMenuOptions() {
      
      System.out.println("\nMENU\n" +
        "a - Algebra expression\n" +
        "i - Solve integrals\n" +
        "rs - Solve Reimann Sums\n" +
        "d - Calculate Derivative\n" +
        "q - Quit\n" + "\nChoose an option:");
        
    }
    public static void printMenu() {
      MathExpression expr = new MathExpression();
      Boolean quitMenu = false;
      printMenuOptions();
      String usrInput = SuperCalc.getNextLine();
      
      while (!quitMenu) {
        switch (usrInput){
            case "a":
                System.out.println("Input algebra equation");
                //MathExpression expr = new MathExpression(ReimannSumm.getNextLine());
                expr.setExpression(SuperCalc.getNextLine());
                System.out.println("result: " + expr.solve());
                usrInput = SuperCalc.getNextLine();
                break;
            case "i":
                //example "f(x)=2*x; intg(f,1,3)"
                System.out.println("Input equation you want to integrate, with x as variable followed by lower and upper bound");
                System.out.println("ex: 2*x 1 3");
                usrInput = "f(x)=" + SuperCalc.getNext() + "; intg(f," + SuperCalc.getNextDouble() + "," + SuperCalc.getNextDouble() + ")";
                expr.setExpression(usrInput);
                System.out.println("result: " + expr.solve());
                usrInput = SuperCalc.getNextLine();
                break;
            case "rs":
                usrInput = SuperCalc.getNextLine();
                break;
            case "d":
                System.out.println("Input equation you want to derive, with x as variable");
                usrInput = "diff(@(x)" + SuperCalc.getNextLine() + ")";
                expr.setExpression(usrInput);
                System.out.println("result: " + expr.solve());
                usrInput = SuperCalc.getNextLine();
                break;
            case "q":
                quitMenu = true;
                break;
            default:
                System.out.println("Choose an valid option:");
                usrInput = SuperCalc.getNextLine();
                break;
        }
          
      }
        
    }
    
}
