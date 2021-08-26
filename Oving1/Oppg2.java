import java.util.Scanner;

public class Oppg2 {
    public static void main(String[] args) {
        System.out.println("Nei shit jeg kan klokka også\nGi meg et helt antall timer:");

        int hours, minutes, seconds;

        try (Scanner input = new Scanner(System.in)) {
            hours = input.nextInt();

            System.out.println("Skriv et helt antall minutter:");
            minutes = input.nextInt();

            System.out.println("Skriv et helt antall sekunder:");
            seconds = input.nextInt();
        }

        int sum = seconds + 60 * minutes + 3600 * hours;

        System.out.println(hours + " timer, " + minutes + " minutter og " + seconds + " sekunder er " + sum + " sekunder");
    }
}
