import types.Spiller;

public class Oppg2 {
    public static void main(String[] args) {
        Spiller spiller1 = new Spiller();
        Spiller spiller2 = new Spiller();
        int counter = 1;

        while (!(spiller1.erFerdig() || spiller2.erFerdig())) {
            spiller1.kastTerning();
            spiller2.kastTerning();

            counter++;
//            System.out.printf("Kast %d:\nSpiller 1 har %d poeng\nSpiller 2 har %d poeng\n\n", counter, spiller1.getPoengsum(), spiller2.getPoengsum());
        }

        System.out.printf("Spiller %d vinner etter %d kast, med %d poeng", spiller1.erFerdig() ? 1 : 2, counter, spiller1.erFerdig() ? spiller1.getPoengsum() : spiller2.getPoengsum());
    }
}
