package ProgramOne;

public class Height {

    public void heightComparison(double heightOne, double heightTwo, double heightThree) {

        // Check if all heights are equal
        if (heightOne == heightTwo && heightTwo == heightThree) {
            System.out.println("All three persons have EQUAL heights.");
        } else {
            // Identify the tallest person
            double tallest = Math.max(heightOne, Math.max(heightTwo, heightThree)); // Math.max to determine the maximum of two values
            String tallestPerson = ""; //  empty string to hold the result

            // Determine which person is the tallest
            if (tallest == heightOne) {
                tallestPerson = "Person 1";
            }
            if (tallest == heightTwo) {
                tallestPerson = "Person 2";
            }
            if (tallest == heightThree) {
                tallestPerson = "Person 3";
            }
            // Print the result
            System.out.println(tallestPerson + " has the tallest height of " + tallest + " cm.");
        }
    }
}