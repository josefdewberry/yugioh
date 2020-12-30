package yugioh;

import java.util.Scanner;

public class Date {
    
    int month;
    int day;
    int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year =year;
    }

    public Date(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("/");
        this.month = scanner.nextInt();
        this.day = scanner.nextInt();
        this.year = scanner.nextInt();
        scanner.close();
    }

    public String print() {
        String s = "";
        s += month + "/" + day + "/" + year;
        return s;
    }
}
