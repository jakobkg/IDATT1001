package klasser;

public class Matrise {
    public Matrise(double[][] verdier) {
        this.verdier = verdier;
        int biggestWidth = 0;
        int currWidth = 0;

        this.m = verdier.length;
        this.n = verdier[0].length;

        for (double[] rad : verdier) {
            if (rad.length != this.n) {
                throw new IllegalArgumentException("Matrisen har ugyldig data, rader er av ulik lengde");
            }

            for (double verdi : rad) {
                currWidth = String.format("%.2f", verdi).length();
                if (currWidth > biggestWidth) {
                    biggestWidth = currWidth;
                }
            }
        }

        this.width = biggestWidth;
    }

    public Matrise adder(Matrise B) {
        if (!((this.m == B.m) && (this.n == B.n))) {
            throw new IllegalArgumentException("Matriser må ha samme dimensjoner for å kunne legges sammen");
        }

        double[][] buf = new double[this.m][this.n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                buf[i][j] = this.verdier[i][j] + B.verdier[i][j];
            }
        }

        return new Matrise(buf);
    }

    public Matrise multipliser(Matrise B) {
        if (!(this.n == B.m)) {
            throw new IllegalArgumentException("Matrise A må ha like manger rader som matrise B har kolonner for at multiplikasjon skal være gyldig");
        }

        double[][] buf = new double[this.m][B.n];

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < B.n; j++) {
                for (int k = 0; k < this.n; k++) {
                    buf[i][j] += this.verdier[i][k] * B.verdier[k][j];
                }
            }
        }

        return new Matrise(buf);
    }

    public Matrise transponer() {
        double[][] buf = new double[this.n][this.m];
        
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                buf[j][i] = this.verdier[i][j];
            }
        }
        
        return new Matrise(buf);
    }
    
    public String toString() {
        String buf = "\n";

        for (double[] rad : verdier) {
            buf = buf.concat("| ");
            for (double verdi : rad) {
                buf = buf.concat(String.format("%" + width + ".2f ", verdi));
            }
            buf = buf.concat("|\n");
        }

        return buf;
    }

    public final int m, n;
    private final double[][] verdier;
    private final int width;
}
