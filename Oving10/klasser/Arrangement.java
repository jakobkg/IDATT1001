package klasser;

/**
 * Arrangement
 */
public class Arrangement {

    private final long tidspunkt;
    private final int arrangementNummer;
    private final String navn, sted, arrangør, type;

    public Arrangement(int nummer, String navn, String sted, String arrangør, String type, long tidspunkt) {
        this.arrangementNummer = nummer;
        this.tidspunkt = tidspunkt;
        this.navn = navn;
        this.sted = sted;
        this.arrangør = arrangør;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("#%d: %s\nSted: %s\nTidspunkt: %s\nArrangør: %s\nType: %s\n",
                             this.arrangementNummer, this.navn, this.sted, this.getPrintableTidspunkt(), this.arrangør, this.type);
    }

    public int getArrangementNummer() {
        return this.arrangementNummer;
    }

    public String getArrangør() {
        return this.arrangør;
    }

    public String getNavn() {
        return this.navn;
    }

    public long getTidspunkt() {
        return this.tidspunkt;
    }

    public String getPrintableTidspunkt() {
        String tidspunktString = String.valueOf(this.tidspunkt);
        return String.format("%s.%s.%s, %s:%s",
                             tidspunktString.substring(6, 8), tidspunktString.substring(4, 6),
                             tidspunktString.substring(0, 4), tidspunktString.substring(8, 10),
                             tidspunktString.substring(10, 12));
    }

    public String getSted() {
        return this.sted;
    }

    public String getEventType() {
        return this.type;
    }
}
