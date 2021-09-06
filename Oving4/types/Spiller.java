package types;

import java.util.Random;

public class Spiller {
    private int poengsum;
    private Random terning;

    public Spiller() {
        this.poengsum = 0;
        this.terning = new Random();
    }

    public int getPoengsum() {
        return this.poengsum;
    }

    public void kastTerning() {
        int kast = terning.nextInt(6) + 1;
        
        if (kast == 1) {
            this.poengsum = 0;
        } else {
            this.poengsum += kast;
        }
    }

    public boolean erFerdig() {
        return this.poengsum >= 100;
    }
}
