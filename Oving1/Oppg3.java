import java.util.Scanner;

public class Oppg3 {
    public static void main(String[] args) {
        System.out.println("Oppgave 2, men baklengs!\nSkriv inn et helt antall sekunder:");

        int inputSeconds;
        
        try (Scanner input = new Scanner(System.in)) {
            inputSeconds = input.nextInt();
        }

        int hours = inputSeconds / 3600;
        int seconds = inputSeconds % 3600;
        int minutes = seconds / 60;
        seconds = seconds % 60;

        System.out.println(inputSeconds + " sekunder er " + hours + ((hours == 1) ? " time, " : " timer, ") + minutes + " minutter og " + seconds + " sekunder");
    }
}
