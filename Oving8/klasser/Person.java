package klasser;

import java.util.Calendar;

/**
 * Person
 * Klasse for å representere en person, med enkle personalia
 */
public class Person {
    private final String fornavn, etternavn;
    private int fødselsår;

    /**
     * Enkel konstruktør
     * @param fornavn   Personens fornavn
     * @param etternavn Personens etternavn
     * @param fødselsår Personens fødselsår, som int
     */
    public Person(String fornavn, String etternavn, int fødselsår) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fødselsår = fødselsår;
    }

    // Getters
    public String getFornavn() {
        return this.fornavn;
    }

    public String getEtternavn() {
        return this.etternavn;
    }

    public int getFødselsår() {
        return this.fødselsår;
    }

    public String getNavn() {
        return String.format("%s %s", this.fornavn, this.etternavn);
    }

    public int getAlder() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) - this.fødselsår;
    }

    @Override
    public String toString() {
        return String.format("%s, f.:%d", this.getNavn(), this.fødselsår);
    }
}