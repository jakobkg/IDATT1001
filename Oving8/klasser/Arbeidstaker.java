package klasser;

import java.util.Calendar;

public class Arbeidstaker {
    private Person personalia;
    private final int ansettelsesår;
    private double månedslønn;
    private double skatteprosent;

    /**
     * Enkel konstruktør
     * @param personalia    Person-objekt som representerer arbeidstakeren
     * @param ansettelsesår Året arbeidstakeren ble ansatt, som integer
     * @param månedslønn    Arbeidstakerens månedslønn i kroner og øre
     * @param skatteprosent Trekkprosenten til arbeidstakeren
     */
    public Arbeidstaker(Person personalia, int ansettelsesår, double månedslønn, double skatteprosent) {
        this.personalia = personalia;
        this.ansettelsesår = ansettelsesår;
        this.månedslønn = månedslønn;
        this.skatteprosent = skatteprosent;
    }

    @Override
    public String toString() {
        String buffer = "";
        buffer = buffer.concat(String.format("%s (%d)\n", this.getNavn(), this.getAlder()));
        buffer = buffer.concat(String.format("Ansatt i %d år, siden %d\n", this.getAntallÅrAnsatt(), this.getAnsettelsesår()));
        buffer = buffer.concat(String.format("Månedslønn: %.2f kr\n", this.månedslønn));
        buffer = buffer.concat(String.format("Skatteprosent: %.1f\n", this.skatteprosent));
        buffer = buffer.concat(String.format("Årslønn:\n"));
        buffer = buffer.concat(String.format("  Brutto: %.2f\n", this.getBruttolønn()));
        buffer = buffer.concat(String.format("  Netto: %.2f\n", this.getBruttolønn() - this.getÅrligSkattetrekk()));
        
        return buffer;
    }

    // Fancier getters
    public double getÅrligSkattetrekk() {
        return (double)((int)(1050 * this.månedslønn * (this.skatteprosent / 100.)) / 100.);
    }

    public double getBruttolønn() {
        return (double)((int)(1200 * this.månedslønn) / 100.);
    }

    public String getNavn() {
        return String.format("%s, %s", this.personalia.getEtternavn(), this.personalia.getFornavn());
    }

    public int getAlder() {
        return this.personalia.getAlder();
    }

    public int getAntallÅrAnsatt() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) - this.ansettelsesår;
    }

    public boolean ansattLengreEnn(int år) {
        return this.getAntallÅrAnsatt() >= år;
    }

    // Plain getters
    public Person getPersonalia() {
        return this.personalia;
    }

    public int getAnsettelsesår() {
        return this.ansettelsesår;
    }

    public double getMånedslønn() {
        return this.månedslønn;
    }

    public double getSkatteprosent() {
        return this.skatteprosent;
    }

    // Setters
    public void setPersonalia(Person personalia) {
        this.personalia = personalia;
    }

    public void setMånedslønn(double månedslønn) {
        this.månedslønn = månedslønn;
    }

    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }
}
