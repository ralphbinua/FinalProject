package ProgramOne;

public class LeapYear {

    public void leapYear ( int year){

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a LEAP YEAR.");
        } else {
            System.out.println(year + " is NOT a LEAP YEAR.");
        }
        return;
    }

}
