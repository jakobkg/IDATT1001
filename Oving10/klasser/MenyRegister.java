package klasser;

import java.util.ArrayList;

public class MenyRegister {
    private ArrayList<Meny> menyer;
    private ArrayList<Rett> retter;

    public MenyRegister() {
        this.menyer = new ArrayList<Meny>();
        this.retter = new ArrayList<Rett>();
    }

    public ArrayList<Rett> getRetter() {
        return this.retter;
    }

    public ArrayList<Meny> getMenyer() {
        return this.menyer;
    }

    public Rett finnRett(String navn) {
        for (Rett rett : this.retter) {
            if (rett.getNavn().equals(navn)) {
                return rett;
            }
        }

        return null;
    }

    public Meny finnMeny(String navn) {
        for (Meny meny : this.menyer) {
            if (meny.getNavn().equals(navn)) {
                return meny;
            }
        }

        return null;
    }

    public ArrayList<Rett> finnRetterAvType(String type) {
        ArrayList<Rett> resultatbuffer = new ArrayList<Rett>();

        for (Rett rett : this.retter) {
            if (rett.getType().equals(type)) {
                resultatbuffer.add(rett);
            }
        }

        return resultatbuffer;
    }

    public void registrerMeny(String navn, ArrayList<Rett> retter) {
        this.menyer.add(new Meny(navn, retter));
    }

    public void registrerRett(String navn, String type, double pris) {
        this.retter.add(new Rett(navn, type, pris));
    }

    public ArrayList<Meny> finnMenyerMedPrisMellom(double fra, double til) {
        ArrayList<Meny> resultatbuffer = new ArrayList<Meny>();
        for (Meny meny : this.menyer) {
            if (meny.getTotalPris() >= fra && meny.getTotalPris() <= til) {
                resultatbuffer.add(meny);
            }
        }

        return resultatbuffer;
    }
}
