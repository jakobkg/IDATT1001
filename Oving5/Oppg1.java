import helpers.Fraction;

public class Oppg1 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(1, 2);

        f2.divide(f1);

        System.out.printf("Resultatet er %s\n", f2);
    }
}