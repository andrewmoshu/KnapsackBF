package com.company;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new KnapSack();
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((end - start) / 60000d) + " minutes");
    }
}

