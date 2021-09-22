package klasser;

public class Tekst {
    public Tekst(String str) {
        this.innhold = str;
    }

    public int antallOrd() {
        int sum = 0;

        for (String ord : this.innhold.split(" ")) {
            sum += ord.length() > 0 ? 1 : 0;
        }

        return sum;
    }

    public double gjennomsnittligOrdlengde() {
        String ingenTegn = this.innhold.replaceAll("[ÆØÅæøåA-Za-z0-9 ]+", "");
        int antall = ingenTegn.split(" ").length;
        int sum = ingenTegn.replaceAll(" ", "").length();

        return Double.valueOf(sum) / antall;
    }

    public Tekst erstattOrd(String eksisterende, String erstatning) {
        return new Tekst(this.innhold.replaceAll("\\b".concat(eksisterende).concat("\\b"), erstatning));
    }

    public String toString() {
        return this.innhold;
    }

    private final String innhold;
}