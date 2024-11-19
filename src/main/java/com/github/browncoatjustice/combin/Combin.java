/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.github.browncoatjustice.combin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * combin - the binary combiner, of sorts. Read below: (and yes, its all small letters, completely intentional. 
 * Generates all possible combinations of binary values of size n.
 * The combinations can be printed to the console, stored in an ArrayList, or written to a file.
 * @author habis
 */
public class Combin {

    // Default binary characters (can be customized by the user)
    private static char bin0 = '0';
    private static char bin1 = '1';

    // List to store results if the user selects "arraylist" option
    private static List<String> outcomes = new ArrayList<>();

    // Maximum size of the binary combinations (set limit for short type)
    private static final short MAX_SIZE = 16; // 2^16 combinations max

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        if (argsParse(args)) {
            if (outcomes.size() > 0) {
                System.out.println("Generated combinations:");
                for (String outcome : outcomes) {
                    System.out.println(outcome);  // Print outcomes to console as requested
                }
            }
        }
    }

    private static boolean argsParse(String[] args) {
        if (args.length > 0) {
            try {
                // Parse the first argument as the memory size (n), using short
                short m = Short.parseShort(args[0]);

                if (m <= 0 || m > MAX_SIZE) {
                    System.err.println("Error: Memory size (n) must be a positive number and less than or equal to " + MAX_SIZE);
                    return false;
                }

                System.out.println("Generating binary combinations for size: " + m);

                // Optionally, parse the second and third arguments as binary characters
                if (args.length > 1) {
                    bin0 = args[1].charAt(0);
                    if (args[1].length() != 1) {
                        throw new IllegalArgumentException("Binary character must be a single character.");
                    }
                }

                if (args.length > 2) {
                    bin1 = args[2].charAt(0);
                    if (args[2].length() != 1) {
                        throw new IllegalArgumentException("Binary character must be a single character.");
                    }
                }

                String filename = null;
                Boolean printToConsole = false;

                // Check if the filename is provided
                if (args.length > 3) {
                    filename = args[3];
                    printToConsole = false; // User only wants to output to a file
                }

                // Check if the user wants to print to console as well
                if (args.length > 4 && args[4].equalsIgnoreCase("console")) {
                    printToConsole = true;
                }

                // Call the appropriate overloaded method
                if (filename != null && printToConsole) {
                    generateOutcomes(m, "", filename, printToConsole);  // Both console and file output
                } else if (filename != null) {
                    generateOutcomes(m, "", filename, null);  // Only file output (null for printToConsole)
                } else {
                    generateOutcomes(m, "", null, printToConsole);  // Only console output (null for filename)
                }

                return true;

            } catch (NumberFormatException e) {
                System.err.println("Error: Memory size (n) must be a valid integer. Please provide a valid positive integer.");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        } else {
            System.err.println("Error: No input provided. Please provide the size of binary combinations (n).");
        }

        return false;
    }

    /**
     * Generates binary combinations of size n recursively and prints the
     * results to the console. It also saves the results in the ArrayList.
     *
     * @param n The size of the binary combination.
     * @param current The current combination being generated.
     */
    public static void generateOutcomes(short n, String current) {
        generateOutcomes(n, current, null, null); // Default to console output and no filename
    }

    /**
     * Generates binary combinations of size n recursively and stores or prints
     * the results to a file.
     *
     * @param n The size of the binary combination.
     * @param current The current combination being generated.
     * @param filename The filename to save the results to (if provided).
     */
    public static void generateOutcomes(short n, String current, String filename) {
        generateOutcomes(n, current, filename, null); // Only file output
    }

    /**
     * Generates binary combinations of size n recursively and stores or prints
     * the results.
     *
     * @param n The size of the binary combination.
     * @param current The current combination being generated.
     * @param filename The filename to save the results to (if provided).
     * @param printToConsole Whether to print results to the console (if true).
     */
    public static void generateOutcomes(short n, String current, String filename, Boolean printToConsole) {
        // Base case: when n is 0, the combination is complete
        if (n == 0) {
            try {
                // Output depending on the format selected
                if (filename != null) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                        writer.write(current + "\n");
                    }
                }
                if (printToConsole != null && printToConsole) {
                    System.out.println(current);  // Print to console if the flag is set
                }
                outcomes.add(current);  // Store the combination in the ArrayList
            } catch (IOException e) {
                System.err.println("Error: Failed to write to file \"" + filename + "\". " + e.getMessage());
            }
            return;
        }

        // Recursive calls to generate combinations by adding bin0 and bin1
        generateOutcomes((short) (n - 1), current + bin0, filename, printToConsole); // Add bin0 to the combination
        generateOutcomes((short) (n - 1), current + bin1, filename, printToConsole); // Add bin1 to the combination
    }
}
