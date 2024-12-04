package ProgramOne;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Access Other class file
        LeapYear leapyear = new LeapYear();
        Height height = new Height();
        Series series = new Series();
        Diamond diamond = new Diamond();

        // Prompt user to enter their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        int choice;

        do {
            // Display menu options
            System.out.println("\nTell me what you want to do. Here are your options:");
            System.out.println("[ 1 ] Determine if a year is a LEAP YEAR or NOT");
            System.out.println("[ 2 ] HEIGHT COMPARISON of 3 persons");
            System.out.println("[ 3 ] Display the Series");
            System.out.println("[ 4 ] Display a diamond of asterisks");
            System.out.println("[ 0 ] Exit");

            // Get the user's choice
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    // Option 1: Determine if a year is a leap year
                    System.out.print("Enter a year: ");
                    int year = scanner.nextInt();
                    leapyear.leapYear(year);
                    break;
                }

                case 2: {
                    // Option 2: Height comparison of 3 persons
                    System.out.print("Enter height of person 1 (cm): ");
                    double heightOne = scanner.nextDouble();
                    System.out.print("Enter height of person 2 (cm): ");
                    double heightTwo = scanner.nextDouble();
                    System.out.print("Enter height of person 3 (cm): ");
                    double heightThree = scanner.nextDouble();
                    height.heightComparison(heightOne, heightTwo, heightThree);
                    break;
                }

                case 3: {
                    // Option 3: Display the series
                    System.out.print("Enter an integer (n): ");
                    int number = scanner.nextInt();
                    series.numberSeries(number);
                    break;
                }

                case 4: {
                    // Option 4: Display a diamond of asterisks
                    System.out.print("Enter the number of rows for the diamond (n): ");
                    int rows = scanner.nextInt();
                    diamond.diamond(rows);
                    break;
                }

                case 0: {
                    // Exit option
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                }

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }
}