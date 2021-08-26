import java.util.Scanner;

public class Oppg2 {
    public static void main(String[] args) {
        System.out.println("La oss finne den billigste varen!\nOppgi vekten på vare 1 i kg:");

        double mass1, mass2, price1, price2;

        try (Scanner input = new Scanner(System.in)) {
            mass1 = input.nextDouble();

            System.out.println("Oppgi prisen på vare 1 i kroner og øre:");
            price1 = input.nextDouble();

            System.out.println("Oppgi vekten på vare 2 i kg:");
            mass2 = input.nextDouble();

            System.out.println("Oppgi prisen på vare 2 i kroner og øre:");
            price2 = input.nextDouble();
        }

        double cpm1 = price1 / mass1;
        double cpm2 = price2 / mass2;

        final int CHEAPEST = cpm1 < cpm2 ? 1 : 2;
        boolean equal = String.format("%.2f", cpm1).equals(String.format("%.2f", cpm2));

        if (equal) {
            System.out.printf("De to varene har samme kilopris, %.2f kr/kg. Kjøp den med finest innpakning! <3", cpm1);
        } else {
            System.out.printf("Vare %1d er den billigste! Den har kilopris %.2f kr/kg, mens vare %1d har kilopris %.2f kr/kg!",
                CHEAPEST, CHEAPEST == 1 ? cpm1 : cpm2,
                CHEAPEST == 1 ? 2 : 1, CHEAPEST == 1 ? cpm2 : cpm1);
        }
    }
}
