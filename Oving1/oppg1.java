import java.util.Scanner;

class oppg1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Velkommen til superkalkulatoren!\nSkriv inn et antall tommer for å regne om til centimeter");

        double inches = input.nextDouble();
        
        System.out.println(inches + " tommer er " + inchesToCentimeters(inches) + " centimeter");
        //System.out.printf("%f tommer er %f centimeter", inches, inchesToCentimeters(inches));
        input.close();
    }

    static double inchesToCentimeters(double inches) {
        return inches * 2.54;
    }
}