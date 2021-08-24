import java.util.Scanner;

public class oppg2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("La oss finne den billigste varen!\nOppgi vekten på vare 1 i kg:");
        double mass1 = input.nextDouble();

        System.out.println("Oppgi prisen på vare 1 i kroner og øre:");
        double price1 = input.nextDouble();

        System.out.println("Oppgi vekten på vare 2 i kg:");
        double mass2 = input.nextDouble();

        System.out.println("Oppgi prisen på vare 2 i kroner og øre:");
        double price2 = input.nextDouble();
        input.close();

        double cpm1 = price1 / mass1;
        double cpm2 = price2 / mass2;

        final int CHEAPEST = cpm1 < cpm2 ? 1 : 2;
        boolean equal = cpm1 == cpm2;

        if (equal || "$.2f".formatted(cpm1).equals("$.2f".formatted(cpm2))) {
            System.out.printf("De to varene har samme kilopris, %.2f kr/kg. Kjøp den med finest innpakning! <3", cpm1);
        } else {
            System.out.printf("Vare %1d er den billigste! Den har kilopris %.2f kr/kg, mens vare %1d har kilopris %.2f kr/kg!",
                CHEAPEST, CHEAPEST == 1 ? cpm1 : cpm2,
                CHEAPEST == 1 ? 2 : 1, CHEAPEST == 1 ? cpm2 : cpm1);
        }
    }
}
