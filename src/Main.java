import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int fromYear = 2010;
        int toYear = 2015;
        printBonusDatesBetween(fromYear, toYear);
    }
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        // From year must not be greater than To year
        // From and To years must not be equal
        // From and To years must be over 1000 and under 9999
        if (fromYear > toYear || fromYear == toYear || fromYear > 9999 || fromYear < 1000 || toYear > 9999) {
            System.out.print("Invalid input.");
            return;
        }

        for (int year = fromYear; year <= toYear; year++) {
            int month = (year % 10) * 10 + (year % 100) / 10; // Gets the month from the year (2 last year numbers reversed)
            int day = year % 1000 / 100 * 10 + year / 1000; // Gets the day from the year (2 first year numbers reversed)

            // Checks if the date exists, if it doesn't, goes to the next date
            try {
                LocalDate date = LocalDate.of(year, month, day);
            }
            catch (Exception e){
                continue;
            }

            // Prints the date if there are no errors prior
            System.out.print(year + "-");
            if (month < 10) System.out.print("0" + month + "-"); // If the month integer is single digit, adds a 0 in front
            else System.out.print(month + "-");
            if (day < 10) System.out.print("0" + day + "\n"); // If the day integer is single digit, adds a 0 in front
            else System.out.print(day + "\n");
        }
    }
}