package klasser;

public class Rett {
    private final String navn, type;
    private double pris;
    
    public Rett(String navn, String type, double pris) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
    }

    public Rett(Rett other) {
        this.navn = other.navn;
        this.type = other.type;
        this.pris = other.pris;
    }

    @Override
    public String toString() {
        return String.format("Rett: %s\nType: %s\nPris: %.2f kr", this.navn, this.type, this.pris);
    }

    public String getNavn() {
        return this.navn;
    }

    public String getType() {
        return this.type;
    }

    public double getPris() {
        return this.pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}
