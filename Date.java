package yugioh;

import java.util.Scanner;

/**
 * A personal date class to be used to the initial release date of cards.
 * I'm sure something exactly like this already exists but I was too lazy
 * to look it up and figured it would be easier to build it myself.
 */
public class Date {
    
    // The only fields I need are month/day/year.
    int month;
    int day;
    int year;

    /**
     * Constructor for when the fields are given as ints.
     * The fields represent the initial release date of a card.
     * @param month The month
     * @param day The day
     * @param year The year
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year =year;
    }

    /**
     * Constructor for when the fields are given as a single string.
     * @param s Should be given as "MM/DD/YYYY", for example 12/12/2002
     * or 2/4/2005.
     */
    public Date(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("/");
        this.month = scanner.nextInt();
        this.day = scanner.nextInt();
        this.year = scanner.nextInt();
        scanner.close();
    }

    /**
     * A simple print statement to print the date in MM/DD/YYYY format.
     * @return The formatted date.
     */
    public String print() {
        String s = "";
        s += month + "/" + day + "/" + year;
        return s;
    }
}