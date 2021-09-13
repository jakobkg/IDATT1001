import helpers.MinRandom;

public class Oppg2 {
    public static void main(String[] args) {
        MinRandom generator = new MinRandom();

        System.out.println("Mellom 1.5 og 3.5:");

        for (int i = 0; i < 15; i++) {
            System.out.println(generator.nesteDesimaltall(1.5, 3.5));
        }

        int nedre = 50;
        int øvre = 75;
        int antall = 10000;

        int[] genererte = new int[øvre - nedre + 1];

        System.out.printf("\nMellom %d og %d\n", nedre, øvre);

        for (int i = 0; i < antall; i++) {
            genererte[generator.nesteHeltall(nedre, øvre) - nedre]++;
        }

        for (int j = 0; j < genererte.length; j++) {
            System.out.printf("%d: %d\n", nedre + j, genererte[j]);
        }
    }
}
