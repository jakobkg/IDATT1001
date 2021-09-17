import klasser.Tekst;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Oppg2 {
    public static void main(String[] args) {
        String loremString;
        
        try {
            loremString = Files.readString(Path.of("lorem.txt"));
        } catch (IOException e) {
            loremString = "aeiou";
        }

        Tekst analyse = new Tekst(loremString);
        analyse.visFordeling();
        System.out.printf("Antall bokstaver: %d\n", analyse.antallBokstaver());
        System.out.printf("Antall ikke bokstaver: %d\n", loremString.length() - analyse.antallBokstaver());
        System.out.printf("Andel ikke bokstaver: %.2f\n", analyse.andelIkkeBokstaver());
        System.out.printf("Antall forskjellige bokstaver: %d\n", analyse.forskjelligeBokstaver());
    }
}
