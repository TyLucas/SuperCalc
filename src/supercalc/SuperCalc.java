/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercalc;
import util.*;
import parser.*;
/**
 *
 * @author andreas lees
 */
public class SuperCalc {

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
      Boolean quitMenu = false;
      printMenuOptions();
      String usrInput = ReimannSumm.getNextLine();
      
      while (!quitMenu) {
        switch (usrInput){
            case "a":
                System.out.println("Input algebra equation");
                MathExpression expr = new MathExpression(ReimannSumm.getNextLine());
                System.out.println("result: " + expr.solve());
                usrInput = ReimannSumm.getNextLine();
                break;
            case "i":
                usrInput = ReimannSumm.getNextLine();
                break;
            case "rs":
                usrInput = ReimannSumm.getNextLine();
                break;
            case "d":
                usrInput = ReimannSumm.getNextLine();
                break;
            case "q":
                quitMenu = true;
                break;
            default:
                System.out.println("Choose an valid option:");
                usrInput = ReimannSumm.getNextLine();
                break;
        }
          
      }
        
    }
    
}
