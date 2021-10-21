package klasser;

import java.util.ArrayList;

public class Meny {
    private final String navn;
    private ArrayList<Rett> retter;

    public Meny(String navn) {
        this.navn = navn;
        this.retter = new ArrayList<Rett>();
    }

    public Meny(String navn, ArrayList<Rett> retter) {
        this.navn = navn;
        this.retter = retter;
    }

    @Override
    public String toString() {
        StringBuilder stringbuf = new StringBuilder();
        stringbuf.append(String.format("Meny: %s\n", this.navn));
        stringbuf.append(String.format("Pris: %.2f kr\n", this.getTotalPris()));
        stringbuf.append("Retter:");

        for (Rett rett : this.retter) {
            stringbuf.append("\n\n");
            stringbuf.append(rett);
        }

        return stringbuf.toString();
    }

    public String getNavn() {
        return this.navn;
    }

    public ArrayList<Rett> getRetter() {
        return this.retter;
    }

    public double getTotalPris() {
        int totalSum = 0;
        for (Rett rett : this.retter) {
            totalSum += rett.getPris();
        }

        return totalSum;
    }

    public void addRett(Rett rett) {
        this.retter.add(rett);
    }
}
