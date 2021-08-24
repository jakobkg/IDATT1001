import java.util.Scanner;

public class oppg1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Skuddår-kalkulator! Skriv inn et årstall for å se om det er et skuddår:");
        int year = input.nextInt();
        input.close();

        System.out.printf("%4d er%s et skuddår", year, isLeapYear(year) ? "" : " ikke");
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0));
    }
}
