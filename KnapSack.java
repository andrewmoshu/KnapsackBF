package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack {
    private Item itemList[];  // List of items
    private int n;           // number of items specified directly,due to requirements
    private int capacity;    // Maximum capacity for solution
    private int bestSoFar;  // best value found so far
    private int bestWeight;
    private boolean solution[];
    private boolean current[];  // Items being checked currently

    public KnapSack() throws FileNotFoundException {

        //Choose between parsing data automatically from file, or
        // entering data by hand
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "Original":

                Scanner sc= new Scanner(new File("test"));
                capacity=sc.nextInt();
                n=30;
                itemList=new Item[n];
                for(int i=0;i<n;i++){
                int v=sc.nextInt();
                int w=sc.nextInt();
                itemList[i]=new Item(w,v);
                    System.out.printf("%4d %5d %5d\n", i, w, v);
                }
                break;
            case"Custom":
                System.out.println("Define number of elements:");
                n=scanner.nextInt();
                System.out.println("Define maximum capacity of elements:");
                capacity=scanner.nextInt();
                itemList=new Item[n];
                for(int i=0;i<n;i++){
                    System.out.println("Enter value of element:");
                 int v=scanner.nextInt();
                    System.out.println("Enter weight value:");
                 int w=scanner.nextInt();
                 itemList[i]=new Item(w,v);
                    System.out.printf("%4d %5d %5d\n", i, w, v);
                }

        }

        // Initializations
        bestSoFar = Integer.MIN_VALUE;
        bestWeight= Integer.MIN_VALUE;
        solution = new boolean[n];
        current = new boolean[n];

        solve(n - 1);

        printSolution();
    }


    /**
     * Solving method, using BruteForce
     *
     */
    public void solve(int k) {

        // Base case: All items have been considered, so check result:
        if (k < 0) {
            // Find total weight and total value:
            int wt = 0;
            int val = 0;
            for (int i = 0; i < n; i++) {
                if (current[i]) {
                    wt += itemList[i].weight();
                    val += itemList[i].value();
                }
            }

            // Check to see if we've got a better solution:
            if (wt <= capacity && val > bestSoFar) {
                bestSoFar = val;
                bestWeight= wt;
                copySolution();
            }

            return;
        }

        // Recursive case: there are two possibilities for item k -- either
        // we select it for the knapsack or we don't. Trying each possibility:
        current[k] = true;
        solve(k - 1);

        current[k] = false;
        solve(k - 1);
    }

    /**
     * Printing the best value and characteristic vector
     */
    public void printSolution() {
        System.out.println("Best value: " + bestSoFar);
        System.out.println("Best weight: " + bestWeight);
        System.out.println("Vector:");
        for (int i = 0; i < n; i++) {
            if (solution[i]) {
                System.out.print("1");
            }
            else{
                System.out.print("0");
            }
        }
        System.out.println(" ");
    }


    /**
     * Used to preserve a newly-found improved solution:
     */
    public void copySolution() {
        for (int i = 0; i < n; i++)
            solution[i] = current[i];
    }

}