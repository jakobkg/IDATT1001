import java.util.Scanner;

class Oppg1{
    public static void main(String[] args) {
        System.out.println("Velkommen til superkalkulatoren!\nSkriv inn et antall tommer for å regne om til centimeter");

        double inches;

        try (Scanner input = new Scanner(System.in)) {
            inches = input.nextDouble();
        }
        
        System.out.println(inches + " tommer er " + inchesToCentimeters(inches) + " centimeter");
    }

    static double inchesToCentimeters(double inches) {
        return inches * 2.54;
    }
}