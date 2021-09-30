import klasser.Tekst;

public class Oppg2 {
    public static void main(String[] args) {
        Tekst tekst = new Tekst("Dette er en tekst med flere ord! Den har også flere perioder, som: Denne? Denne! Og denne.");
        System.out.println(tekst.antallOrd());
        System.out.println(tekst.gjennomsnittligOrdlengde());
        System.out.println(tekst.erstattOrd("Denne", "Aeiou"));
        System.out.println(tekst.toUpper());
    }
}
