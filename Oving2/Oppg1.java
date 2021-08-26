import java.util.Scanner;

public class Oppg1{
    public static void main(String[] args) {
        System.out.println("Skuddår-kalkulator! Skriv inn et årstall for å se om det er et skuddår:");

        int year;
        try (Scanner input = new Scanner(System.in)) {
            year = input.nextInt();
        }

        System.out.printf("%d er%s et skuddår", year, isLeapYear(year) ? "" : " ikke");
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0));
    }
}
