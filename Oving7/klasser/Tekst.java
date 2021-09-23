package klasser;

/**
 * klassebeskrivelse
 */
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
        Tekst ingenTegn = this.fjernTegnsetting();
        double antall = ingenTegn.toString().split(" ").length;
        double sum = ingenTegn.toString().replaceAll(" ", "").length();

        return sum / antall;
    }

    /**
     * metodebeskrivelse
     * @return
     */
    public double gjennomsnittligAntallOrdPerPeriode() {
        int antallOrd = this.fjernTegnsetting().toString().split(" ").length;
        int antallPerioder = this.innhold.split("[.!:?]").length;
        return Double.valueOf(antallOrd) / antallPerioder;
    }

    public Tekst erstattOrd(String eksisterende, String erstatning) {
        return new Tekst(this.innhold.replaceAll("\\b".concat(eksisterende).concat("\\b"), erstatning));
    }

    public String toString() {
        return this.innhold;
    }

    public String toUpper() {
        return this.innhold.toUpperCase();
    }

    public String toLower() {
        return this.innhold.toLowerCase();
    }

    private Tekst fjernTegnsetting() {
        return new Tekst(this.innhold.replaceAll("(?u)(?m)\\p{Punct}", ""));
    }

    private final String innhold;
}