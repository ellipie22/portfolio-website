/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author Administrator
 */
import java.util.*;

public class Practice {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // Compute total owed, assuming 8% tax and 15% tip
        int Subtotal;
        double Tax;
        double Tip;
        double Total;
        Subtotal = 38 + 40 + 30;
        Tax = Subtotal * .08;
        Tip = Subtotal * 0.15;
        Tip = Subtotal.to
        Total = Subtotal + Tax + Tip;
        System.out.println("Subtotal: " + Subtotal);
        System.out.println("Tax: " + Tax);
        System.out.println("Tip: " + Tip);
        System.out.println("Total: " + Total);
    }
}


