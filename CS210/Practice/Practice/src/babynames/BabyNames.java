// CS210 Assignment #6 "baby names"
// Pierre Ellie

import java.io.*;
import java.util.*;
import java.awt.*;

public class BabyNames {

    public static void main(String[] args) throws FileNotFoundException {
        // Creates the scanner and graphics for the graph and console
        Scanner babynames = new Scanner(new File("Names.txt"));
        Scanner console = new Scanner(System.in);
        DrawingPanel graph = new DrawingPanel(450, 1020);
        Graphics g = graph.getGraphics();
        //prompts the user to ask for a name
        System.out.println("** Popularity of a baby name since year 1920 **");
        System.out.println("name?");
        String theName = console.next();
        Boolean detected = false;
        //while loop that runs through the entire file to find the name
        while (detected == false) {
            if (babynames.hasNext()) {
                String thisName = babynames.next();
                //this if runs once a name is found that matches the input
                if (thisName.equalsIgnoreCase(theName)) {
                    //creates the file that will be exported
                    String fileName = thisName + ".txt";
                    PrintStream outFile = new PrintStream(new File(fileName));
                    outFile.println(thisName + ",");
                    System.out.println(thisName + ",");
                    int ovalCount = 0;
                    int prevQTY = 0;
                    //this for loop writes the line of the output as well as puts the points on the graph and connects them to the previous one
                    for (int year = 1920; year <= 2000; year += 10) {
                        int qty = babynames.nextInt();
                        String qtyString = " " + qty;
                        System.out.println(year + " : " + qty);
                        outFile.println(year + " : " + qty + ", ");
                        //this if statement determines whether the value for that year was 0, meaning it was out of the top 100 and puts it at the bottom, otherwise it accurately places it
                        if (qty == 0) {
                            g.drawOval(25 + (ovalCount * 50), 1000, 5, 5);
                        } else {
                            g.drawOval(25 + (ovalCount * 50), qty, 5, 5);
                        }
                        g.drawString(qtyString, 25 + (ovalCount * 50), qty);
                        //this if draws the lines connecting the dots
                        if (ovalCount > 0) {
                            g.drawLine(25 + ((ovalCount - 1) * 50), prevQTY, 25 + (ovalCount * 50), qty);
                        }
                        ovalCount += 1;
                        prevQTY = qty;
                    }

                    detected = true;
                    //creates the outlines, title and years for the graph
                    g.drawLine(0, 1000, 450, 1000);
                    int yearNum = 1920;
                    String year = " " + yearNum;
                    //for loop to create the vertical lines seen on the graph
                    for (int i = 1; i <= 9; i++) {
                        g.drawLine(50 * i, 30, 50 * i, 1000);
                        g.drawString(year, -40 + (50 * i), 1015);
                        yearNum += 10;
                        year = " " + yearNum;
                    }

                    g.drawString(thisName, 200, 25);

                }
            } else {
                //if a matching name is not found, this runs and tells the user that the name wasn't found
                System.out.println("name not found");
                detected = true;
            }
        }
    }
}
