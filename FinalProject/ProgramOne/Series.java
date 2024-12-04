package ProgramOne;

public class Series {

    public void numberSeries(int number){

            System.out.print("Series: ");
            int a = 1, b = 1;

            for (int i = 1; i <= number; i++) {
                System.out.print(a + " ");
                int next = a + b;
                a = b; // Move to the next number in the series
                b = next; // Update b to the next number
            }
        return;
    }
}
