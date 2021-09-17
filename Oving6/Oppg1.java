import java.util.Random;

public class Oppg1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] antall = new int[10];

        for (int i = 0; i < 10000; i++) {
            antall[random.nextInt(10)]++;
        }

        for (int j = 0; j < antall.length; j++) {
            System.out.printf("%d: %4d %s\n", j, antall[j], "*".repeat(antall[j] / 100));
        }
    }
}
