import java.util.Scanner;

public class oppg2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Nei shit jeg kan klokka også\nGi meg et helt antall timer:");
        int hours = input.nextInt();

        System.out.println("Skriv et helt antall minutter:");
        int minutes = input.nextInt();

        System.out.println("Skriv et helt antall sekunder:");
        int seconds = input.nextInt();

        input.close();

        int sum = seconds + 60 * minutes + 3600 * hours;

        System.out.println(hours + " timer, " + minutes + " minutter og " + seconds + " sekunder er " + sum + " sekunder");
    }
}
